package org.hibernate.HibernateFinal.fetchAndEager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Driver {

    public static Configuration getConfiguration() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(KeyBoard.class);

        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "KavinDharani@3");
        configuration.setProperty("hibernate.connection.Driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "mysql:jdbc://localhost:3306/finalhibernate");
        configuration.setProperty("hibernate.connection.show_sql", true);
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");

        return configuration;
    }

    public static void main(String[] args) {
        Configuration configuration = getConfiguration();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        SessionFactory sessionFactory =  configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();

        Laptop laptop = new Laptop("Techno", 50000.00, null);
        KeyBoard keyBoard = new KeyBoard("Dell", 2000.00, laptop);
        laptop.setKeyBoard(keyBoard);

        Transaction transaction = session.getTransaction();

        transaction.begin();

        session.persist(laptop);

        transaction.commit();
    }
}
