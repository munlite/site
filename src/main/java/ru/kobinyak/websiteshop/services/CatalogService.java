package ru.kobinyak.websiteshop.services;

import ru.kobinyak.websiteshop.models.Product;

import java.util.List;

public interface CatalogService {
    List<Product> findProductByCategoryId(Integer id);
    List<Product> findProductByCategoryIdSortedByPriceASC( Integer id);
    List<Product> findProductByCategoryIdSortedByPriceDESC( Integer id);
    List<Product> findProductByCategoryIdSortedByAlfavite( Integer id);
}
