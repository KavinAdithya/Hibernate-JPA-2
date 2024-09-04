package org.hibernate.HibernateFinal.entity;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "co_workers")
public class Employee {

    @Column(name = "emp_name")
    private String name;

    @Id
    @Column(name = "emp_id")
    private int id;

    @Column(name = "work_time")
    private LocalTime localTime;

    public Employee(String name, int id, LocalTime localTime) {
        this.name = name;
        this.id = id;
        this.localTime = localTime;
    }

    public Employee() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", localTime=" + localTime +
                '}';
    }
}
