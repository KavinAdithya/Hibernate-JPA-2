package org.hibernate.HibernateFinal.fetchAndEager;

import jakarta.persistence.*;

@Entity
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

    @OneToOne(mappedBy = "keyBoard")
    private Laptop laptop;

    public KeyBoard() {
        super();
    }

    public KeyBoard(String name, double cost, Laptop laptop ) {
        this.name = name;
        this.cost = cost;
        this.laptop = laptop;
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

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "KeyBoard{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", cost= " + cost +
                ", laptop = " + laptop +
                '}';
    }
}
