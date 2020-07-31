package ru.kobinyak.websiteshop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.kobinyak.websiteshop.models.Cart;
import ru.kobinyak.websiteshop.models.Product;
import ru.kobinyak.websiteshop.models.ProductInOrder;

import java.util.List;


public interface CartRepository extends CrudRepository<Cart, Integer>,
        PagingAndSortingRepository<Cart, Integer>,
        JpaRepository<Cart, Integer>,
        JpaSpecificationExecutor<Cart> {
    @Query(value = "SELECT pio FROM Cart c JOIN ProductInOrder pio on pio.order.id = c.order.id where  c.id = ?1")
    List<ProductInOrder> findProductByIdCart(Integer idCart);
}
