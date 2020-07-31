package ru.kobinyak.websiteshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kobinyak.websiteshop.data.ProductRepository;
import ru.kobinyak.websiteshop.models.Product;

import java.util.List;

@Component
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ProductService serviceProduct;

    @Override
    public List<Product> searchProduct(String nameProduct) {
        if (confirmSearchWord(serviceProduct.findAllByNameLike(nameProduct))){
            return serviceProduct.findAllByNameLike(nameProduct);
        }else {
            return serviceProduct.findAllByNameLike(nameProduct);
        }

    }
    private boolean confirmSearchWord(List<Product> products){
        if(products.isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}
