package io.licht.laundryapi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.licht.laundryapi.service.QrService;

@RestController
@RequestMapping("/qr")
public class QrController {

    @Autowired
    QrService qrService;

    @GetMapping("/{qrId}")
    public Map<String, Object> getQrById (@PathVariable Integer qrId)
    {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", qrService.getQrById(qrId));
            result.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("data", null);
            result.put("status", "failed");
        }


        return result;
    }
}
