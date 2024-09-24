package org.hibernate.HibernateFinal.mappingRelationship;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "emp_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "depart_ink")
    private Department department;

    public Employee() {
        super();
    }

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getId() == employee.getId() && Objects.equals(getName(), employee.getName()) && Objects.equals(getDepartment(), employee.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDepartment());
    }

    @Override
    public String toString() {
        return "Employee : " +
                "        EmployeeId         : " + id + "\n" +
                "        EmployeeName       : " + name + "\n" +
                "        EmployeeDepartment : " + department ;
    }
}
