package ru.kobinyak.websiteshop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.kobinyak.websiteshop.models.Category;
import ru.kobinyak.websiteshop.models.Product;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer>, PagingAndSortingRepository<Category, Integer>,
        JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {

    @Query(value = "SELECT c.product  FROM Catalog c join c.category where c.category.id = ?1")
    List<Product> findAllProductById(int id_category);
    @Query(value = "SELECT c.product  FROM Catalog c join c.category where c.category.name = ?1")
    List<Product> findAllProductByName(String name);
}
