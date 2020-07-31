package ru.kobinyak.websiteshop.services;

import ru.kobinyak.websiteshop.models.Category;
import ru.kobinyak.websiteshop.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Category> getCategoryById(int id_product);
    List<Category> getCategoryByName(String name);
    Integer findMaxAmountByIdProducte(Integer idProduct);
    Product findById(Integer id);
    List<Product>  findAllByNameLike(String name);
}
