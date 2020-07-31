package ru.kobinyak.websiteshop.models;


import javax.persistence.*;

@Entity
@Table(name = "product_in_order")
public class ProductInOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name = "product_id")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
            CascadeType.MERGE,
                    CascadeType.REFRESH})
    private Product product;


    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH})
    @JoinColumn(name = "order_id")
    private Order order;
    private int amount;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
