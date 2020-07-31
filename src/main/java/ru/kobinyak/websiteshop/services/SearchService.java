package ru.kobinyak.websiteshop.services;

import ru.kobinyak.websiteshop.models.Product;

import java.util.List;

public interface SearchService {
    List<Product> searchProduct(String nameProduct);
}
