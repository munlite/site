package ru.kobinyak.websiteshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kobinyak.websiteshop.controllers.dto.ProductItemDTO;
import ru.kobinyak.websiteshop.data.ProductInOrderRepository;
import ru.kobinyak.websiteshop.models.Product;
import ru.kobinyak.websiteshop.models.ProductInOrder;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductInOrderServiceImpl implements ProductInOrderService {
    @Autowired
    private ProductInOrderRepository productInOrderRepository;


    @Override
    public BigDecimal ProductPriceMultiplyAmount(Integer id) {
        return null;
//        productInOrderRepository.findAllByIdOrder(id);
    }

    @Override
    public List<Product> findProductByOrderId(Integer idOrder) {
        return productInOrderRepository.findProductByOrderId(idOrder);
    }

    @Override
    public List<ProductInOrder> findAllByOrderId(Integer idOrder) {
        return productInOrderRepository.findAllByOrderId(idOrder);
    }

    @Override
    public Optional<Product> findByProductAndOrder(Integer idProduct, Integer idOrder) {
        return productInOrderRepository.findByProductAndOrder(idProduct, idOrder);
    }

    @Override
    public ProductInOrder findProductInOrderByProductAndOrder(Integer idProduct, Integer idOrder) {
        return productInOrderRepository.findProductInOrderByProductAndOrder(idProduct, idOrder);
    }

    @Override
    public void updateAmountOrder(Integer idProduct, Integer idOrder, Integer amount) {
        productInOrderRepository.updateAmountOrder(idProduct,idOrder, amount);
    }

    @Override
    public Product findProductByProductName(String name) {
        return productInOrderRepository.findProductByProductName(name);
    }

    @Override
    public void delete(Integer idProduct, Integer idOrder) {
        productInOrderRepository.delete(idProduct, idOrder);
    }

    @Override
    public BigDecimal sumAllByIdOrder(Integer idOrder) {
        return productInOrderRepository.sumAllByIdOrder(idOrder);
    }

    @Override
    public void checkedDelete(ProductItemDTO productItemDTO) {
        if(productItemDTO.isDelete.equals("on")){
            productInOrderRepository.delete(productItemDTO.id, 3);
        }
    }

    @Override
    public void updateAmountOrder(String[] id, Integer idOrder, String[] amount) {
        for (int i = 0; i < id.length; i++){
            updateAmountOrder(Integer.parseInt(id[i]),3, Integer.parseInt(amount[i]));
        }
    }

    @Override
    public void deleteAllByIdOrder(Integer idOrder) {
        productInOrderRepository.deleteAllByIdOrder(idOrder);
    }
}
