package DriverTester;

import org.hibernate.DataBase;
import org.hibernate.entity.Laptop;
import org.hibernate.entity.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.hibernate.DAO;

import java.io.DataOutput;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LapAndStud {

    Student student=new Student();

    Laptop laptop=new Laptop();

    DAO persist=new DAO();

    @BeforeAll
    public void objectLoaderStudent(){
        student.setStudentName("Kavin");
        student.setDeveloperSalary(200000.00);
        student.setStudentId(2);
        //student.setLaptop(laptop);
    }

    @BeforeAll
    public void objectLoaderLaptop(){
        laptop.setName("Mac");
        laptop.setPrice(30000.00);
        laptop.setId(5);
        //laptop.setStudent(student);
    }

    @Test
    public void tester(){
        //persist.<Student>insertData(student);
       // persist.<Laptop>insertData(laptop);
        persist.<Student>updateData(student);
        //persist.<Laptop>updateData(laptop);
    }

    @AfterAll
    public void close(){
        DataBase.shutDownSessionFactory();
    }
}
