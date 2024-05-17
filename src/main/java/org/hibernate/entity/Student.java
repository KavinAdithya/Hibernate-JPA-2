package org.hibernate.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "developers")
public class Student {


    @Column(name = "developer_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "developer_name")
    private String studentName;



//    @OneToOne

    @ManyToMany

    private List<Laptop> laptop = new ArrayList<Laptop>();



    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }



    @Column(name = "developer_salary")
    private double developerSalary;



    //Id
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


    //Name
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    //Salary
    public double getDeveloperSalary() {
        return developerSalary;
    }

    public void setDeveloperSalary(double developerSalary) {
        this.developerSalary = developerSalary;
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", laptop=" + laptop +
                ", developerSalary=" + developerSalary +
                '}';
    }
}
