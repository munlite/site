package ru.kobinyak.websiteshop.services;


import ru.kobinyak.websiteshop.models.Client;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    BigDecimal summPriceProductInOrderByIdClient(int id_client);
    List<Client> findById_client(Integer id);
}
