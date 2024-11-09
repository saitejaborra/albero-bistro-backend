package com.albero.restro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Mailbody {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "mailfrom")
    private String mailfrom;

    @Column
    private String subject;

    @Column(name= "text")
    private String message;
}
