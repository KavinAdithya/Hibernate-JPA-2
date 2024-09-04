package org.hibernate.HibernateFinal;


import org.hibernate.HibernateFinal.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;

public class Practise {
    public static void saveObject() {

        Configuration configuration = new Configuration().addAnnotatedClass(Employee.class);

        configuration.configure("hibernate.org.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Employee employee = new Employee("Kavin", 1, LocalTime.now());

        Transaction transaction = session.beginTransaction();

       // session.persist(employee);
        System.out.println(session.get(Employee.class, 1));

        transaction.commit();
    }


}
