package org.hibernate.HibernateFinal.cache;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "Laptop")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Laptop_id")
    private int id;

    @Column(name = "Model_name")
    private String name;

    @Column(name = "cost")
    private double cost;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    private KeyBoard keyBoard;

    public Laptop(String name, double cost, KeyBoard keyBoard) {
        this.name = name;
        this.cost = cost;
        this.keyBoard = keyBoard;
    }

    public Laptop() {
        super();
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

    public KeyBoard getKeyBoard() {
        return keyBoard;
    }

    public void setKeyBoard(KeyBoard keyBoard) {
        this.keyBoard = keyBoard;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", cost = " + cost +
                ", keyBoard = " + keyBoard +
                '}';
    }
}
