package ru.kobinyak.websiteshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kobinyak.websiteshop.data.CategoryRepository;
import ru.kobinyak.websiteshop.data.ProductRepository;
import ru.kobinyak.websiteshop.models.Category;
import ru.kobinyak.websiteshop.models.Product;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public List<Product> findAllProductById(int id_category){
        return categoryRepository.findAllProductById(id_category);
    }
    public List<Product> findAllProductByName(String name){
        return categoryRepository.findAllProductByName(name);
    }
}
