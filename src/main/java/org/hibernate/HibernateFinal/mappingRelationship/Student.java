package org.hibernate.HibernateFinal.mappingRelationship;

import javax.persistence.*;


import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @Column(name = "student_name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "students", fetch = FetchType.LAZY)
    private List<Course> courses;
    public Student() {
        super();
    }

    public Student(String name, List<Course> courses) {

        this.name = name;
        this.courses = courses;
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getId() == student.getId() && Objects.equals(getName(), student.getName()) && Objects.equals(getCourses(), student.getCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCourses());
    }

    @Override
    public String toString() {
        return "Student    : "                    + "\n" +
                "          StudentId       : " + id   + "\n" +
                "          StudentName     : " + name + "\n" +
                "          EnrolledCourses : " + courses;
    }
}
