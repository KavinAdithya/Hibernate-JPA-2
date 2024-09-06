package org.hibernate.HibernateFinal;


import org.hibernate.HibernateFinal.entity.DateOfBirth;
import org.hibernate.HibernateFinal.entity.Employee;
import org.hibernate.HibernateFinal.mappingRelationship.Profile;
import org.hibernate.HibernateFinal.mappingRelationship.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;

public class Practise {
    public static void saveObject() {

        Configuration configuration = new Configuration()
                //.addAnnotatedClass(DateOfBirth.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Profile.class);

        setProperties(configuration);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        DateOfBirth dateOfBirth = new DateOfBirth(7, "March", (short) 2005);

        Employee employee = new Employee("Kavin", 2, LocalTime.now(), dateOfBirth);

        Transaction transaction = session.beginTransaction();

//        session.persist(employee);
//        //System.out.println(session.get(Employee.class, 1));
//        persistObjects(session);

        User user = new User(1, "Kavin_Adithya", "Kavinadithya3@gmail.com");
        session.update(user);

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
        User user = new User(1, "Kavin_Adithya", "Kavinadithya3@gmail.com");
        session.persist(user);
        Profile profile = new Profile(1, "Kavin", "Dharani", user);

        //session.persist(profile);

    }
}
