package ru.kobinyak.websiteshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kobinyak.websiteshop.data.CategoryRepository;
import ru.kobinyak.websiteshop.data.ProductRepository;
import ru.kobinyak.websiteshop.models.Category;
import ru.kobinyak.websiteshop.models.Product;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;



    @Override
    public List<Category> getCategoryById(int id_product) {
        return productRepository.findCategoryByProductId(id_product);
    }

    @Override
    public List<Category> getCategoryByName(String name) {
        return productRepository.findCategoryByProductName(name);
    }

    @Override
    public Integer findMaxAmountByIdProducte(Integer idProduct) {
        return productRepository.findMaxAmountByIdProducte(idProduct);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findAllByNameLike(String name) {
        return productRepository.findAllByName(name.toLowerCase());
    }
}
