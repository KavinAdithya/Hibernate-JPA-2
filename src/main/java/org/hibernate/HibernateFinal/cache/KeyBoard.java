package org.hibernate.HibernateFinal.cache;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE,  region = "org.hibernate.HibernateFinal.fetchAndEager.Laptop")
@Table(name = "KeyBoard")
public class KeyBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KeyBoard_id")
    private int id;

    @Column(name = "Model_Name")
    private String name;

    @Column(name = "KeyBoard_price")
    private double cost;



    public KeyBoard() {
        super();
    }

    public KeyBoard(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", cost= " + cost +
                '}';
    }
}
