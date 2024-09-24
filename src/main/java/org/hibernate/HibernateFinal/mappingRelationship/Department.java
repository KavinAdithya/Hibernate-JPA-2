package org.hibernate.HibernateFinal.mappingRelationship;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @Column(name = "depart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "depart_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.EAGER)
    private List<Employee> listOfEmployees;

    public Department() {
        super();
    }

    public Department( String name, List<Employee> listOfEmployees) {
        this.name = name;
        this.listOfEmployees = listOfEmployees;
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

    public List<Employee> getEmployee() {
        return listOfEmployees;
    }

    public void setEmployee(List<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (! (o instanceof Department department)) return false;

        return this.id == department.id && this.name.equals(department.name) && this.listOfEmployees.equals(department.listOfEmployees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, listOfEmployees);
    }

    @Override
    public String toString() {
        return "Department : " + "\n" +
                "          DepartmentId   :  " + id + "\n" +
                "          DepartmentName :  " + name + "\n" +
                "          Employees  : " + listOfEmployees;
    }
}
