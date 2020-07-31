package ru.kobinyak.websiteshop.services;

import ru.kobinyak.websiteshop.controllers.dto.ProductItemDTO;
import ru.kobinyak.websiteshop.models.Product;
import ru.kobinyak.websiteshop.models.ProductInOrder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductInOrderService {

    BigDecimal ProductPriceMultiplyAmount(Integer id);
    List<Product> findProductByOrderId(Integer idOrder);
    List<ProductInOrder> findAllByOrderId(Integer idOrder);
    Optional<Product> findByProductAndOrder(Integer idProduct, Integer idOrder);
    ProductInOrder findProductInOrderByProductAndOrder(Integer idProduct, Integer idOrder);
    void updateAmountOrder(Integer idProduct, Integer idOrder, Integer amount);
    Product findProductByProductName(String name);
    void delete(Integer idProduct, Integer idOrder);
    BigDecimal sumAllByIdOrder(Integer idOrder);
    void checkedDelete(ProductItemDTO productItemDTO);
    void updateAmountOrder(String[] id, Integer idOrder, String[] amount);
    void deleteAllByIdOrder(Integer idOrder);
}
