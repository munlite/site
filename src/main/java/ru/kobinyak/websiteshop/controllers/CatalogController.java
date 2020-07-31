package ru.kobinyak.websiteshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.kobinyak.websiteshop.models.Product;
import ru.kobinyak.websiteshop.services.CartService;
import ru.kobinyak.websiteshop.services.CatalogService;
import ru.kobinyak.websiteshop.services.ProductInOrderService;
import ru.kobinyak.websiteshop.services.ProductService;

import java.util.List;


@Controller
public class CatalogController {
    private Integer id;
    private List<Product> products;
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductInOrderService productInOrderService;

    @GetMapping("/catalogy/{id}")
    public String getCatalog(@PathVariable(value = "id") Integer id, Model model){
        this.id=id;
        products = catalogService.findProductByCategoryId(id);
        model.addAttribute("products", products);
        model.addAttribute("id", id);
        return "catalog";
    }
    @PostMapping("/catalogy/{id}/")
    public String sortedCatalogy(@RequestParam String sel, Model model){
        switch (sel) {
            case "PriceUp":
            {
                products = catalogService.findProductByCategoryIdSortedByPriceASC(id);
                model.addAttribute("products", products);
                break;
            }
            case "PriceDown":
            {
                products = catalogService.findProductByCategoryIdSortedByPriceDESC(id);
                model.addAttribute("products", products);
                break;


            }
            case "Alfavite":
            {
                products = catalogService.findProductByCategoryIdSortedByAlfavite(id);
                model.addAttribute("products", products);
                break;

            }
        }
        return "catalog";
    }
    @PostMapping("/catalogy/add/")
    public String addProductInOrder(@RequestParam Integer id, @RequestParam Integer amount, Model model){
        cartService.addProductInOrder(id, amount);
        model.addAttribute("products", products);
        return "catalog";
    }

//    private Integer calcAmoun(@RequestParam String name, @RequestParam Integer amount) {
//        Integer amountInStorage = productService.findByName(name).getAmount();
//        Integer amountInOrder = productInOrderService.findProductByProductName(name).getAmount();
//        Integer sumAmount = amountInStorage - amountInOrder - amount;
//        return sumAmount;
//    }
}
