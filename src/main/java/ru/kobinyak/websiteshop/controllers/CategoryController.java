package ru.kobinyak.websiteshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kobinyak.websiteshop.models.Category;
import ru.kobinyak.websiteshop.services.CategoryService;

import java.util.List;


@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String category(Model model){
        List<Category> categoryes = categoryService.findAll();
        model.addAttribute("categoryes", categoryes);
        return "category";
    }

}
