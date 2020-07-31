package ru.kobinyak.websiteshop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import ru.kobinyak.websiteshop.models.Client;
import ru.kobinyak.websiteshop.models.Order;

import java.math.BigDecimal;
import java.util.List;

public interface OrderRepository extends
        CrudRepository<Order, Integer>,
        PagingAndSortingRepository<Order, Integer>,
        JpaRepository<Order, Integer>,
        JpaSpecificationExecutor<Order> {
        @Query(value = "SELECT pio.order.id FROM ProductInOrder pio join pio.order where pio.order.id = ?1")
        Integer sum(Integer idOrder);

        @Query(value = "SELECT r.client FROM Order r join r.client where r.id = ?1")
        List<Client> findById_client(Integer id);
}
