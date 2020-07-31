package ru.kobinyak.websiteshop.services;

import ru.kobinyak.websiteshop.models.Category;
import ru.kobinyak.websiteshop.models.Product;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    List<Product> findAllProductById(int id_category);
    List<Product> findAllProductByName(String name);
}
