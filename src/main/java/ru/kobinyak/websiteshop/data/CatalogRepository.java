package ru.kobinyak.websiteshop.data;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.kobinyak.websiteshop.models.Catalog;
import ru.kobinyak.websiteshop.models.Product;

import java.util.List;

public interface CatalogRepository extends CrudRepository<Catalog, Integer>,
        PagingAndSortingRepository<Catalog, Integer>,
        JpaRepository<Catalog, Integer>,
        JpaSpecificationExecutor<Catalog> {
    @Query(value = "SELECT c.product  FROM Catalog c join c.category where c.category.id = ?1")
    List<Product> findProductByCategoryId(Integer id);

    @Query(value = "SELECT c.product  FROM Catalog c join c.category where c.category.id = ?1 order by c.product.price asc")
    List<Product> findProductByCategoryIdSortedByPriceASC( Integer id);

    @Query(value = "SELECT c.product  FROM Catalog c join c.category where c.category.id = ?1 order by c.product.price desc")
    List<Product> findProductByCategoryIdSortedByPriceDESC( Integer id);

    @Query(value = "SELECT c.product  FROM Catalog c join c.category where c.category.id = ?1 order by c.product.name asc")
    List<Product> findProductByCategoryIdSortedByAlfavite( Integer id);

}
