package ru.kobinyak.websiteshop.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orderr")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "sum")
    private BigDecimal sum;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal amount) {
        this.sum = amount;
    }
}
