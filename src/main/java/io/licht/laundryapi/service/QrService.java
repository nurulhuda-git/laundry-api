package io.licht.laundryapi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.licht.laundryapi.model.QrData;

@Service
public class QrService {
    public Map<Integer, QrData> qrRepo = new HashMap<>();

    public QrData getQrById(Integer qrId)
    {
        return qrRepo.get(qrId);
    }

    public QrData generateQr(Integer orderId)
    {
        QrData qr = new QrData();

        int min = 100000;
        int max = 1000000000;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

        qr.setId(random_int);
        qr.setOrderId(orderId);
        qr.setImage(generateQrImage(orderId));

        qrRepo.put(qr.getId(), qr);
        return qrRepo.get(qr.getId());
    }

    public String generateQrImage(Integer orderId)
    {
        return orderId.toString();
    }
}
