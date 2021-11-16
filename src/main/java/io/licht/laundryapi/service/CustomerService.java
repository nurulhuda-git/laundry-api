package io.licht.laundryapi.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.licht.laundryapi.model.Customer;

@Service
public class CustomerService 
{
    public Map<Integer, Customer> customerRepo = new HashMap<>();

    public Customer createCustomer(Customer customer)
    {
        int min = 100000;
        int max = 1000000000;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

        customer.setCreateBy("Admin");
        customer.setId(random_int);
        customer.setCreateAt(new Date(System.currentTimeMillis()));

        customerRepo.put(customer.getId(), customer);

        return customerRepo.get(random_int);
    }

    public Map<Integer, Customer> getAllCustomer ()
    {
        return customerRepo;
    }

    public Customer getCustomerById(Integer id)
    {
        return customerRepo.get(id);
    }

}
