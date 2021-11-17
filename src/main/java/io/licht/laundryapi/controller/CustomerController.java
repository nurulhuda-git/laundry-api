package io.licht.laundryapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.licht.laundryapi.model.Customer;
import io.licht.laundryapi.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{
    @Autowired
    CustomerService customerService;

    @PostMapping("/")
    public Map<String, Object> createCustomer (@RequestBody Customer customer)
    {
        Map<String, Object> result = new HashMap<>();
        try {
            Customer createdCustomer = customerService.createCustomer(customer);
            result.put("data", createdCustomer);
            result.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("data", null);
            result.put("status", "failed");
        }
        return result;
    }

    @GetMapping("/")
    public Map<String, Object> getAllCustomer()
    {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Customer> customers = customerService.getAllCustomer();
            result.put("data", customers);
            result.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("data", null);
            result.put("status", "failed");
        }
        return result;
    }
}
