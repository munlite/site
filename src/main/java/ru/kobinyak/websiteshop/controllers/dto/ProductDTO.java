package ru.kobinyak.websiteshop.controllers.dto;

public class ProductDTO {
    public Integer id;
    public String name;
    public Integer amountInOrder;
    public Integer amountInStorage;

    public ProductDTO(Integer id, String name, Integer amountInOrder, Integer amountInStorage) {
        this.id = id;
        this.name = name;
        this.amountInOrder = amountInOrder;
        this.amountInStorage = amountInStorage;
    }

    public ProductDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmountInOrder() {
        return amountInOrder;
    }

    public void setAmountInOrder(Integer amountInOrder) {
        this.amountInOrder += amountInOrder;
    }

    public Integer getAmountInStorage() {
        return amountInStorage;
    }

    public void setAmountInStorage(Integer amountInStorage) {
        this.amountInStorage = amountInStorage;
    }

    public boolean amountMaximum(){
        if (amountInOrder>amountInStorage) return true;
        else return false;
    }
}
