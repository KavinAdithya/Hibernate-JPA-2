package org.hibernate.HibernateFinal.entity;

import javax.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "co_workers")
public class Employee {

    @Column(name = "emp_name")
    private String name;

    @Id
    @Column(name = "emp_id")
    private int id;

    private DateOfBirth dateOfBirth;

    @Column(name = "work_time")
    private LocalTime localTime;

    public Employee(String name, int id, LocalTime localTime, DateOfBirth dateOfBirth) {
        this.name = name;
        this.id = id;
        this.localTime = localTime;
        this.dateOfBirth = dateOfBirth;
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

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateOfBirth dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", dateOfBirth=" + dateOfBirth +
                ", localTime=" + localTime +
                '}';
    }
}
