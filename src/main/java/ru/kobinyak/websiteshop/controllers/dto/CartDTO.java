package ru.kobinyak.websiteshop.controllers.dto;

import java.math.BigDecimal;

public class CartDTO {
    private Integer id;
    private String name;
    private Integer maxAmounte;
    private Integer amount;
    private BigDecimal price;
    private String photo;
    public CartDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxAmounte() {
        return maxAmounte;
    }

    public void setMaxAmounte(Integer maxAmounte) {
        this.maxAmounte = maxAmounte;
    }

    public CartDTO(Integer id, String name, Integer maxAmount, Integer amount, BigDecimal price, String photo) {
        this.id = id;
        this.name = name;
        this.maxAmounte = maxAmount;
        this.amount = amount;
        this.price = price;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxAmount() {
        return maxAmounte;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmounte = maxAmount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

