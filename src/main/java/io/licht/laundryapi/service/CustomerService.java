package io.licht.laundryapi.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.licht.laundryapi.model.Customer;
import io.licht.laundryapi.repository.CustomerRepository;

@Service
public class CustomerService 
{
    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer)
    {
        customer.setCreateAt(new Date(System.currentTimeMillis()));
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomer ()
    {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(UUID id)
    {
        return customerRepository.findById(id).get();
    }

}
