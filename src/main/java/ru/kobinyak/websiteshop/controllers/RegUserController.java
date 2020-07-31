package ru.kobinyak.websiteshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kobinyak.websiteshop.models.Client;
import ru.kobinyak.websiteshop.services.CartService;
import ru.kobinyak.websiteshop.services.ClientService;
import ru.kobinyak.websiteshop.services.ProductInOrderService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegUserController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductInOrderService productInOrderService;
    @Autowired
    private ClientService clientService;

    @PostMapping("/regUser/")
    public String updateOrder(HttpServletRequest request,
                              Model model){
        String[] id = request.getParameterValues("idProduct");
        String[] amount = request.getParameterValues("amount");
        productInOrderService.updateAmountOrder(id, 3, amount);
        return "userDeteil";
    }

    @PostMapping("/regUser/{id}/reg/")
    public String regUser(@RequestParam String firstname,
                          @RequestParam String lastname,
                          @RequestParam String address,
                          @RequestParam String email,
                          Model model){
        productInOrderService.deleteAllByIdOrder(3);
        Client client = new Client();
        client.setFirstname(firstname);
        client.setLastname(lastname);
        client.setAddress(address);
        client.setEmail(email);
        clientService.save(client);

        return "home";
    }

}
