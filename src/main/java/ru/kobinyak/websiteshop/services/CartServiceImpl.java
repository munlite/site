package ru.kobinyak.websiteshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kobinyak.websiteshop.controllers.dto.CartDTO;
import ru.kobinyak.websiteshop.controllers.dto.ProductDTO;
import ru.kobinyak.websiteshop.data.CartRepository;
import ru.kobinyak.websiteshop.data.OrderRepository;
import ru.kobinyak.websiteshop.data.ProductInOrderRepository;
import ru.kobinyak.websiteshop.data.ProductRepository;
import ru.kobinyak.websiteshop.models.Product;
import ru.kobinyak.websiteshop.models.ProductInOrder;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CartServiceImpl implements CartService {
    private ProductInOrder productInOrder;
    @Autowired
    private ProductInOrderRepository pio;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;

    public BigDecimal calcPriceProductInOrder(Integer idOrder){
        return pio.sumAllByIdOrder(idOrder);
    }

    @Override
    public List<CartDTO> getProduct() {
        List<ProductInOrder> products = cartRepository.findProductByIdCart(1);
        return tranformationProductInCartDTO(products);
    }

    @Override
    public boolean addProductInOrder(Integer idProduct, Integer amountInAdd) {
        productInOrder = new ProductInOrder();
       if (checkTheProduct(findById(idProduct),amountInAdd)) {
            productInOrder.setProduct(findById(idProduct));
            productInOrder.setAmount(amountInAdd);
            productInOrder.setOrder(orderRepository.findById(3).get());
            pio.save(productInOrder);
            return true;
        }
       else {
           return false;
       }
    }

    private boolean checkTheProduct(Product product, Integer amount){
        if (pio.findByProductAndOrder(product.getId(), 3).isEmpty()){
            return true;
        }
        else {
            if (pio.findProductInOrderByProductAndOrder(product.getId(), 3).getAmount()+amount <= product.getAmount()) {
                pio.updateAmountOrder(product.getId(), 3, amount);
                return false;
            }
            else {
               return false;
            }
        }
    }
    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).get();
    }

    public List<Product> findProductByOrderId(Integer id){
        return pio.findProductByOrderId(id);
    }


    private List<CartDTO> tranformationProductInCartDTO(List<ProductInOrder> productInOrderList) {
        List<CartDTO> cartDTOList = new ArrayList<>();
        for (ProductInOrder p : productInOrderList){
            CartDTO cartDTO = new CartDTO();
            cartDTO.setId(p.getProduct().getId());
            cartDTO.setMaxAmount(productRepository.findMaxAmountByIdProducte(p.getProduct().getId()));
            cartDTO.setAmount(p.getAmount());
            cartDTO.setName(p.getProduct().getName());
            cartDTO.setPrice(p.getProduct().getPrice());
            cartDTO.setPhoto(p.getProduct().getPhoto());
            cartDTOList.add(cartDTO);
        }
        return cartDTOList;
    }


}
