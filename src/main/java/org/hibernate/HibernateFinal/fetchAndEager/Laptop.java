package org.hibernate.HibernateFinal.fetchAndEager;

import org.hibernate.CustomEntityDirtinessStrategy;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
    private KeyBoard keyBoard;

    public Laptop( String name, double cost, KeyBoard keyBoard) {
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
