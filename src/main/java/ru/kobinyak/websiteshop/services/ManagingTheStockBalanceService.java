package ru.kobinyak.websiteshop.services;

import ru.kobinyak.websiteshop.models.Product;

public interface ManagingTheStockBalanceService {

    Integer findProductInBD(String nameProduct);
    void updateTableProductMaxAmount(Product product, Integer amountInOrder);
}
