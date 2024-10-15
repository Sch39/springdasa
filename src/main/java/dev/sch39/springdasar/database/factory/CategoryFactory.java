package dev.sch39.springdasar.database.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.sch39.springdasar.entities.Category;
import dev.sch39.springdasar.repositories.CategoryRepository;

@Component
public class CategoryFactory {
  @Autowired
  private CategoryRepository categoryRepository;

  public void run() {
    Category food = new Category("Food", "food", "All kinds of food");
    Category beverage = new Category("Beverage", "beverage", "All kinds of drinks");
    Category medicine = new Category("Medicine", "medicine", "All kinds of meds");
    categoryRepository.save(food);
    categoryRepository.save(beverage);
    categoryRepository.save(medicine);
  }
}
