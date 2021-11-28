package io.licht.laundryapi.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.licht.laundryapi.helpers.ZXingHelper;
import io.licht.laundryapi.model.QrData;
import io.licht.laundryapi.repository.QrDataRepository;

@Service
public class QrService {

    @Value("${userBucket.path}")
    private String path;

    @Value("${tracker.path}")
    private String hostPath;

    @Autowired
    QrDataRepository qrDataRepository;

    public QrData getQrById(UUID qrId)
    {
        return qrDataRepository.findById(qrId).get();
    }

    public QrData generateQr(Integer orderId)
    {
        String filename = path + orderId + "_qrcode.png";
        QrData qr = new QrData();

        try {
            String link = generateLinkTracker(orderId.toString());
            ZXingHelper.generateQRCodeImage(link, 320, 320, filename);
            qr.setImage(link);
            qr.setOrderId(UUID.randomUUID());
            return qrDataRepository.save(qr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String generateLinkTracker(String orderId)
    {
        return hostPath + orderId.toString();
    }
}
