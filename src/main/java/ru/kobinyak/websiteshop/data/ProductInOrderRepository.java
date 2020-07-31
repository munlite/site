package ru.kobinyak.websiteshop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.kobinyak.websiteshop.models.Product;
import ru.kobinyak.websiteshop.models.ProductInOrder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductInOrderRepository extends
        CrudRepository<ProductInOrder, Integer>,
        PagingAndSortingRepository<ProductInOrder, Integer>,
        JpaRepository<ProductInOrder, Integer>,
        JpaSpecificationExecutor<ProductInOrder> {
    @Query(value = "SELECT SUM(pio.amount * pio.product.price) FROM ProductInOrder pio join pio.order where pio.order.id = ?1")
    BigDecimal sumAllByIdOrder(Integer idOrder);

    @Query(value = "SELECT pio.product FROM ProductInOrder pio join pio.order where pio.order.id = ?1")
    List<Product> findProductByOrderId(Integer idOrder);

    @Query(value = "SELECT pio.product FROM ProductInOrder pio join pio.order where pio.product.name = ?1")
    Product findProductByProductName(String name);

    @Query(value = "SELECT pio FROM ProductInOrder pio where pio.order.id = ?1")
    List<ProductInOrder> findAllByOrderId(Integer idOrder);

    @Query(value = "SELECT pio.product FROM ProductInOrder pio join pio.order where pio.order.id = ?2 and pio.product.id=?1")
    Optional<Product> findByProductAndOrder(Integer idProduct, Integer idOrder);

    @Query(value = "SELECT pio FROM ProductInOrder pio join pio.order where pio.order.id = ?2 and pio.product.id=?1")
    ProductInOrder findProductInOrderByProductAndOrder(Integer idProduct, Integer idOrder);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ProductInOrder pio SET pio.amount = pio.amount + ?3 where pio.order.id=?2 and pio.product.id = ?1")
    void updateAmountOrder(Integer idProduct, Integer idOrder, Integer amount);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ProductInOrder pio WHERE pio.order.id=?2 and pio.product.id = ?1")
    void delete(Integer idProduct, Integer idOrder);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ProductInOrder pio WHERE pio.order.id=?1")
    void deleteAllByIdOrder(Integer idOrder);
}
