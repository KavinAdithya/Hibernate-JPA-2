package DriverTester;

import com.mysql.cj.protocol.a.authentication.AuthenticationLdapSaslClientPlugin;
import org.hibernate.DAO;
import org.hibernate.entity.Laptop;
import org.hibernate.entity.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ONETOMANY {

    DAO persist=new DAO();

    Student student=new Student();

    Laptop laptop=new Laptop();

    @BeforeAll
    public void updateLaptopObject(){
        laptop=persist.<Laptop>getData(Laptop.class,1);
//        laptop.setName("Lenovo");
//        laptop.setPrice(75000.00);
////        student.getLaptop()
//        student.setStudentName("Dharani");
//        student.setDeveloperSalary(100000.00);
        laptop.getStudent().add(persist.<Student>getData(Student.class,1));
        laptop.getStudent().add(persist.<Student>getData(Student.class,2));
//        student=persist.<Student>getData(Student.class,2);
//        student.setLaptop(laptop);

    }

    @Test
    public void test(){
        //persist.<Laptop>insertData(laptop);
        //persist.<Student>insertData(student);
        //persist.<Student>updateData(student);
        persist.<Laptop>updateData(laptop);
    }

}
