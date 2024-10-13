package org.hibernate.HibernateFinal.CriteriaAPI;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "emp_name", nullable = false)
    private String name;

    @Column(name = "emp_age", nullable = false)
    private int age;

    @Column(name = "emp_salary", nullable = false)
    private double salary;


    public Employee() {
        super();
    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && getAge() == employee.getAge() && Double.compare(getSalary(), employee.getSalary()) == 0 && Objects.equals(getName(), employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getSalary());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
