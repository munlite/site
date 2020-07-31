package ru.kobinyak.websiteshop.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.kobinyak.websiteshop.models.Category;
import ru.kobinyak.websiteshop.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer>,
        PagingAndSortingRepository<Product, Integer>,
        JpaRepository<Product, Integer>,
        JpaSpecificationExecutor<Product> {
    @Query(value = "SELECT c.category  FROM Catalog c join c.product where c.product.name = ?1")
    List<Category> findCategoryByProductName(String name);

    @Query(value = "SELECT c.category  FROM Catalog c join c.product where c.product.id = ?1")
    List<Category> findCategoryByProductId(int id);

    Optional<Product> findById(Integer id);

    @Query(value = "SELECT amount FROM Product where id=?1")
    Integer findMaxAmountByIdProducte(Integer idProduct);
    @Query(value = "SELECT c FROM Product c WHERE c.name LIKE %:name%")
    List<Product> findAllByName(@Param("name") String name);

}
