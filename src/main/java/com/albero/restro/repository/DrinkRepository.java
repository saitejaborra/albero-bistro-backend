package com.albero.restro.repository;

import com.albero.restro.model.Drinkmenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drinkmenu, Integer> {
}
