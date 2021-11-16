package io.licht.laundryapi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.licht.laundryapi.model.Order;
import io.licht.laundryapi.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController 
{
    @Autowired
    OrderService orderService;

    @PostMapping("/")
    public Map<String, Object> createOrder(@RequestBody Order order)
    {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", orderService.createOrder(order));
            result.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("data", null);
            result.put("status", "failed");
        }

        return result;
    }

    @GetMapping("/{orderId}")
    public Map<String, Object> getOrderById(@PathVariable Integer orderId)
    {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", orderService.getOrderById(orderId));
            result.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("data", null);
            result.put("status", "failed");
        }

        return result;
    }

    @PutMapping("/{orderId}")
    public Map<String, Object> updateStatusOrderById(@PathVariable Integer orderId, @RequestBody Order order)
    {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", orderService.updateStatusOrderById(orderId, order));
            result.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("data", null);
            result.put("status", "failed");
        }

        return result;
    }

}
