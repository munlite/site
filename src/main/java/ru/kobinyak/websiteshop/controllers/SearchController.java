package ru.kobinyak.websiteshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kobinyak.websiteshop.models.Product;
import ru.kobinyak.websiteshop.services.CartService;
import ru.kobinyak.websiteshop.services.SearchService;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;
    @Autowired
    private CartService cartService;
    private List<Product> products;

    @GetMapping("/search")
    public String search(Model model){
        model.addAttribute("title","search");
        return "search";
    }
    @PostMapping("/search/word/")
    public String searchProduct(@RequestParam String productName, Model model) {
        products = searchService.searchProduct(productName);
        model.addAttribute("products", products);
        return "search";
    }
    @PostMapping("/search/add/")
    public String addProductInOrder(@RequestParam Integer id, @RequestParam Integer amount, Model model){
        cartService.addProductInOrder(id, amount);
        model.addAttribute("products", products);
        return "search";
    }

}
