package ru.kobinyak.websiteshop.services;

import org.springframework.stereotype.Service;
import ru.kobinyak.websiteshop.models.Product;
@Service
public class ManagingTheStockBalanceServiceImpl implements ManagingTheStockBalanceService {
    @Override
    public Integer findProductInBD(String nameProduct) {
//        if (pio.findByProductAndOrder(product.getId(), 3).equals(null)==false){
//            return true;
//        }
        return null;
    }

    @Override
    public void updateTableProductMaxAmount(Product product, Integer amountInOrder) {

    }
}
