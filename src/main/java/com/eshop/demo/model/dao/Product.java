package com.eshop.demo.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Ani Poghosyan on 14/02/2022
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String catagory;
    private String madein;
    private int price;

    public Product() {
    }

    protected Product(Long id, String name, String brand, String madein, int price) {
        super();
        this.id = id;
        this.name = name;
        this.catagory = catagory;
        this.madein = madein;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice (int price) {
        this.price = price;
    }


}
