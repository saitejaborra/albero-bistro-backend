package com.albero.restro.repository;

import com.albero.restro.model.Foodmenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Foodmenu, Integer> {
}
