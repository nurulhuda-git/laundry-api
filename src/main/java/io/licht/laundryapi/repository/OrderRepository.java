package io.licht.laundryapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.licht.laundryapi.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    
}
