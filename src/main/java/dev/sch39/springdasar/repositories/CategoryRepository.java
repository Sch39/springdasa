package dev.sch39.springdasar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.sch39.springdasar.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
