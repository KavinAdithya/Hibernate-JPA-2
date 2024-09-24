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
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/finalhibernate");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.cache.use_second_level_cache", "true");
        configuration.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
        configuration.setProperty("net.sf.ehcache.configurationResourceName", "ehcache.xml");

        return configuration;
    }

    public static void main(String[] args) {
        Configuration configuration = getConfiguration();
        Configuration configuration1 = getConfiguration();

        System.out.println(configuration1.equals( configuration));


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

       Laptop laptop1 = session.get(Laptop.class, 1);

//       System.out.print(laptop2);
//
//       System.out.print(laptop1);

        transaction.commit();

        Session session1 = sessionFactory.openSession();
        Transaction transaction1 = session1.getTransaction();
        transaction1.begin();

        Laptop laptop2 = session1.get(Laptop.class, 1);
        transaction1.commit();
    }
}
