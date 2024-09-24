package org.hibernate.HibernateFinal.mappingRelationship;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int id;

    @Column(name = "course_name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Student> students;

    public Course() {
        super();
    }

    public Course(String name, List<Student> students) {

        this.name = name;
        this.students = students;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return getId() == course.getId() && Objects.equals(getName(), course.getName()) && Objects.equals(getStudents(), course.getStudents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStudents());
    }

    @Override
    public String toString() {
        return "Course : "               + "\n" +
                "      CourseId   : " + id + "\n" +
                "      CourseName : " + name + "\n" +
                "      Students   : " + students;
    }
}
