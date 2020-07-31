package ru.kobinyak.websiteshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kobinyak.websiteshop.controllers.dto.CartDTO;
import ru.kobinyak.websiteshop.services.CartService;
import ru.kobinyak.websiteshop.services.ClientService;
import ru.kobinyak.websiteshop.services.ProductInOrderService;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private  CartService cartService;
    @Autowired
    private ProductInOrderService productInOrderService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/cart")
    public String getCart(Model model){
        List<CartDTO> cartDTOList = cartService.getProduct();
        model.addAttribute("cartProduct", cartDTOList);
        model.addAttribute("sum", productInOrderService.sumAllByIdOrder(3));
        return "cart";
    }

    @GetMapping("/cart/delete/{id}")
    public String deleteProductInOrder(@PathVariable(value = "id") Integer id, Model model){
        productInOrderService.delete(id, 3);
        List<CartDTO> cartDTOList = cartService.getProduct();
        model.addAttribute("cartProduct", cartDTOList);
        model.addAttribute("sum", productInOrderService.sumAllByIdOrder(3));
        return "cart";

    }



}
