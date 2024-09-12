package org.hibernate.HibernateFinal;


import org.hibernate.HibernateFinal.entity.DateOfBirth;
import org.hibernate.HibernateFinal.mappingRelationship.Employee;
import org.hibernate.HibernateFinal.mappingRelationship.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Practise {
    public static void saveObject() {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Profile.class)
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class);

        setProperties(configuration);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        DateOfBirth dateOfBirth = new DateOfBirth(7, "March", (short) 2005);

       // Employee employee = new Employee("Kavin", 3, LocalTime.now(), dateOfBirth);
       // User user = new User("Kavin_Adithya", "Kavinadithya3@gmail.com");

        Transaction transaction = session.beginTransaction();

//        session.persist(employee);
//        System.out.println(session.get(Employee.class, 3));
      //  persistObjects(session);

      //  persistBooks(session);
        persistDepartment(session);


        //session.persist(user);

        transaction.commit();
    }


    private static void setProperties(Configuration configuration) {
        configuration.setProperty("hibernate.connection.Driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/finalHibernate");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "KavinDharani@3");
        configuration.setProperty("hibernate.show_sql", true);
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
    }


    private static void persistObjects(Session session) {
        User user = new User( "Kavin_Adithya", "Kavinadithya3@gmail.com");
        user.setId(3);
        //session.persist(user);
        Profile profile = new Profile( "Kavin", "Dharani", user);

       session.persist(profile);

    }


    private static void persistBooks(Session session) {

        List<Book> bookLists = new ArrayList<>();

       // session.persist(author);

        Author author = new Author("James Gosling", bookLists);
        Book book1 = new Book("Java Programming",author );
        book1.setId(1);

        bookLists.add(book1);

        session.persist(author);
    }

    private static void persistDepartment(Session session) {
        List<Employee> employees = new ArrayList<>();
        employees.add( new Employee("Kavin", null));
        employees.add( new Employee("Dharani", null));
        employees.add( new Employee("KavinDharani", null));
        employees.add( new Employee("DharaniKavin", null));

        Department department = new Department("Computer Science And Engineering", employees);

        session.persist(department);


    }
}
