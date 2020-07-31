package ru.kobinyak.websiteshop.controllers.dto;

public class ProductItemDTO {
    public Integer id;

    public Integer amountInOrder;
    public String isDelete;

    public ProductItemDTO(Integer id, Integer amountInOrder, String isDelete) {
        this.id = id;

        this.amountInOrder = amountInOrder;
        this.isDelete = isDelete;
    }

    public ProductItemDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getAmountInOrder() {
        return amountInOrder;
    }

    public void setAmountInOrder(Integer amountInOrder) {
        this.amountInOrder = amountInOrder;
    }

    public String isDelete() {
        return isDelete;
    }

    public void setDelete(String delete) {
        isDelete = delete;
    }
}
