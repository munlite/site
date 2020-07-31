package ru.kobinyak.websiteshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
}
