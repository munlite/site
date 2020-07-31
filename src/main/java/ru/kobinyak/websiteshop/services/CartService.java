package ru.kobinyak.websiteshop.services;

import ru.kobinyak.websiteshop.controllers.dto.CartDTO;
import ru.kobinyak.websiteshop.models.Product;
import ru.kobinyak.websiteshop.models.ProductInOrder;

import java.util.List;

public interface CartService {
    //List<Product> findProductByIdCart(Integer idCart);
    List<CartDTO> getProduct();
    boolean addProductInOrder(Integer idProduct, Integer amount);
    Product findById(Integer id);
    List<Product> findProductByOrderId(Integer id);
}
