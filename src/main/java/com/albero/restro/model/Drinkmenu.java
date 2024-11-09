package com.albero.restro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Drinkmenu {

    @Id
    private int id;
    private String drink;
    private float price;
    private String category;
}
