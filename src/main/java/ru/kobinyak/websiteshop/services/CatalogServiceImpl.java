package ru.kobinyak.websiteshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kobinyak.websiteshop.data.CatalogRepository;

import ru.kobinyak.websiteshop.models.Product;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;


    @Override
    public List<Product> findProductByCategoryId(Integer id) {
        return catalogRepository.findProductByCategoryId(id);
    }

    @Override
    public List<Product> findProductByCategoryIdSortedByPriceASC(Integer id) {
        return catalogRepository.findProductByCategoryIdSortedByPriceASC(id);
    }

    @Override
    public List<Product> findProductByCategoryIdSortedByPriceDESC(Integer id) {
        return catalogRepository.findProductByCategoryIdSortedByPriceDESC(id);
    }

    @Override
    public List<Product> findProductByCategoryIdSortedByAlfavite(Integer id) {
        return catalogRepository.findProductByCategoryIdSortedByAlfavite(id);
    }
}
