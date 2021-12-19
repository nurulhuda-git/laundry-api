package io.licht.laundryapi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.licht.laundryapi.model.Menu;
import io.licht.laundryapi.model.Order;
import io.licht.laundryapi.model.OrderList;
import io.licht.laundryapi.repository.OrderListRepository;
import io.licht.laundryapi.repository.OrderRepository;

@Service
public class OrderService 
{
    @Autowired
    CustomerService customerService;

    @Autowired
    MenuService menuService;

    @Autowired
    QrService qrService;

    @Autowired
    OrderListRepository orderListRepository;

    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(Order order)
    {
        order.setCreateAt(new Date(System.currentTimeMillis()));
        order.setCreateBy("Admin");
        order.setTotalAmount(sumAmmount(order.getOrderLists()));
        order.setTotalWeight(sumWeight(order.getOrderLists()));

        order = orderRepository.save(order);

        // Get customer
        order.setCustomer(customerService.getCustomerById(order.getCustomer().getId()));

        // Set OrderList
        order.setOrderLists(saveOrderList(order));

        // Set Link
        order.setLink(linkGenerator(order.getId()));

        order.setQrId(qrService.generateQr(order.getId()).getId());

        return orderRepository.save(order);
    }

    public Order getOrderById(UUID orderId)
    {
        return orderRepository.findById(orderId).get();
    }

    public Order updateStatusOrderById(UUID orderId, Order order)
    {
        for (OrderList i : order.getOrderLists())
        {
            OrderList orderList = orderListRepository.findById(i.getId()).get();
            orderList.setStatus(i.getStatus());
            orderListRepository.save(orderList);
        }

        return getOrderById(orderId);
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

    private String linkGenerator(UUID orderId)
    {
        return orderId.toString();
    }

    private List<OrderList> saveOrderList(Order order)
    {
        List<OrderList> orderLists = new ArrayList<>();
        for(OrderList i : order.getOrderLists())
        {
            i.setCreateAt(new Date(System.currentTimeMillis()));
            i.setCreateBy(order.getCreateBy());
            i.setStatus(0);
            i.setMenu(menuService.getMenuById(i.getMenu().getId()));
            i.setOrder(order);

            orderListRepository.save(i);
            orderLists.add(i);
        }

        return orderLists;
    }

}
