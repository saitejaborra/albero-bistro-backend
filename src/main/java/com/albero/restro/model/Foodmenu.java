package com.albero.restro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Foodmenu {
    @Id
    private int id;
    private String dish;
    private float price;
    private String category;
    private String description;
}
