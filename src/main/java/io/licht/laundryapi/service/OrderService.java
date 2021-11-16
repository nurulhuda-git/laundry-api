package io.licht.laundryapi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.licht.laundryapi.model.Menu;
import io.licht.laundryapi.model.Order;
import io.licht.laundryapi.model.OrderList;

@Service
public class OrderService 
{
    @Autowired
    CustomerService customerService;

    @Autowired
    MenuService menuService;

    @Autowired
    QrService qrService;

    public Map<Integer, Order> orderRepo = new HashMap<>();
    public Map<Integer, OrderList> orderListRepo = new HashMap<>();

    public Order createOrder(Order order)
    {
        int min = 100000;
        int max = 1000000000;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

        order.setId(random_int);
        order.setCreateAt(new Date(System.currentTimeMillis()));
        order.setCreateBy("Admin");
        order.setQrId(qrService.generateQr(order.getId()).getId());
        order.setOrderNo(order.getId().toString());
        order.setTotalAmount(sumAmmount(order.getOrderLists()));
        order.setTotalWeight(sumWeight(order.getOrderLists()));

        // Get customer
        order.setCustomer(customerService.getCustomerById(order.getCustomer().getId()));

        // Set OrderList
        order.setOrderLists(saveOrderList(order));

        // Set Link
        order.setLink(linkGenerator(order.getId()));

        orderRepo.put(order.getId(), order);

        return orderRepo.get(order.getId());
    }

    public Order getOrderById(Integer orderId)
    {
        Order order = orderRepo.get(orderId);

        // Get customer
        // order.setCustomer(customerService.getCustomerById(order.getCustomer().getId()));
        // Set OrderList
        // order.setOrderLists(orderListRepo.get(order.get));
        return order;
    }

    public Order updateStatusOrderById(Integer orderId, Order order)
    {
        // System.out.println(order.getOrderLists().size());
        Order savedOrder = getOrderById(orderId);

        Map<Integer, OrderList> orderListUpdate = new HashMap<>();
        List<OrderList> updatedOrderList = new ArrayList<>();

        for (OrderList i : order.getOrderLists())
        {
            // System.out.println(i.getId());
            orderListUpdate.put(i.getId(), i);
        }

        for (OrderList i : savedOrder.getOrderLists()) 
        {
            // System.out.println(i.getId());
            i.setStatus(orderListUpdate.get(i.getId()).getStatus());
            orderListRepo.replace(i.getId(), i);

            updatedOrderList.add(i);
        }

        savedOrder.setOrderLists(updatedOrderList);
        return savedOrder;
    }

    private Double sumAmmount(List<OrderList> orderLists)
    {
        Double sumAmount = 0.0;
        for (OrderList i : orderLists)
        {
            // Get Menu
            Menu menu = menuService.getMenuById(i.getMenu().getId());
            sumAmount += i.getWeight() * menu.getPrice();
        }

        return sumAmount;
    }

    private Double sumWeight(List<OrderList> orderLists)
    {
        Double sumWeight = 0.0;
        for (OrderList i : orderLists)
            sumWeight += i.getWeight();

        return sumWeight;
    }

    private String linkGenerator(Integer orderId)
    {
        return orderId.toString();
    }

    private List<OrderList> saveOrderList(Order order)
    {
        List<OrderList> orderLists = new ArrayList<>();
        for(OrderList i : order.getOrderLists())
        {
            int min = 100000;
            int max = 1000000000;
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            i.setId(random_int);

            i.setCustomer(order.getCustomer());
            i.setCreateAt(new Date(System.currentTimeMillis()));
            i.setCreateBy(order.getCreateBy());
            i.setStatus(0);
            i.setMenu(menuService.getMenuById(i.getMenu().getId()));

            orderListRepo.put(i.getId(), i);
            orderLists.add(i);
        }

        return orderLists;
    }

}
