package ru.kobinyak.websiteshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kobinyak.websiteshop.data.OrderRepository;
import ru.kobinyak.websiteshop.models.Client;


import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public BigDecimal summPriceProductInOrderByIdClient(int id_order) {
        return null;
                //orderRepository.summPriceAllProductInOrderByIdOrder(id_order);
    }

    @Override
    public List<Client> findById_client(Integer id) {
        return orderRepository.findById_client(id);
    }
}
