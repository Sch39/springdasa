package dev.sch39.springdasar.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.sch39.springdasar.database.factory.CategoryFactory;

@Component
public class DatabaseSeeder {
  @Autowired
  private CategoryFactory categoryFactory;

  public void run() {
    categoryFactory.run();
  }
}
