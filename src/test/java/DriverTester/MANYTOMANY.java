package DriverTester;

import org.hibernate.DAO;
import org.hibernate.entity.Laptop;
import org.hibernate.entity.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MANYTOMANY {
    DAO persist=new DAO();

    Laptop laptop=new Laptop();

    Student student=new Student();

    @BeforeAll
    public void objectLoaderLaptop(){
//        laptop.setPrice(10000.0);
//        laptop.setName("Techno");
          //student.setStudentName("Adithya");
          //student.setDeveloperSalary(120000.00);
//        laptop=persist.<Laptop>getData(Laptop.class,1);
//        laptop.getStudent().add(persist.<Student>getData(Student.class,1));
//        laptop.getStudent().add(persist.<Student>getData(Student.class,2));
          student=persist.<Student>getData(Student.class,1);
          student.getLaptop().add(persist.<Laptop>getData(Laptop.class,1));
          student.getLaptop().add(persist.<Laptop>getData(Laptop.class,2));
    }


    @Test
    public void test(){
        //persist.<Laptop>insertData(laptop);
        //persist.<Student>insertData(student);
        //persist.<Laptop>insertData(laptop);
        persist.<Student>updateData(student);
    }

}
