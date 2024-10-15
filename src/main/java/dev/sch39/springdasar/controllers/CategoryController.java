package dev.sch39.springdasar.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.sch39.springdasar.entities.Category;
import dev.sch39.springdasar.repositories.CategoryRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
  @Autowired
  CategoryRepository categoryRepository;

  @GetMapping("")
  public ModelAndView getCategory() {
    ModelAndView view = new ModelAndView("category/index");
    Map<String, Object> categories = new HashMap<>() {
      {
        put("categories", categoryRepository.findAll());
        put("title", "Master Category");
      }
    };
    view.addAllObjects(categories);
    return view;
  }

  @GetMapping("/form")
  public ModelAndView form() {
    ModelAndView view = new ModelAndView("category/form");
    Category category = new Category();
    view.addObject("category", category);
    return view;
  }

  @PostMapping("/save")
  public ModelAndView save(@ModelAttribute Category category, BindingResult result) {
    if (!result.hasErrors()) {
      categoryRepository.save(category);
    }
    return new ModelAndView("redirect:/category");
  }
}
