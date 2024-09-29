package org.hibernate.HibernateFinal.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SecondLevel {
    static Configuration configuration = getConfiguration();
    static SessionFactory sessionFactory = buildSessionFactory();
    public static void main(String[] args) {
        Laptop laptop = new Laptop("Mega Book", 1000.00, null );
        KeyBoard keyBoard = new KeyBoard("Dell", 2000.00);
        laptop.setKeyBoard(keyBoard);

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Laptop laptop1 = session.get(Laptop.class, 3);

        System.out.println(laptop1);
        transaction.commit();


        Session session1 = sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();
        Laptop laptop2 = session1.get(Laptop.class, 3);
        System.out.println(laptop2);
        session1.clear();
        Laptop laptop3 = session1.get(Laptop.class, 3);
        session1.clear();
        Laptop laptop4 = session1.get(Laptop.class, 3);
        transaction1.commit();
        session1.close();
        session.close();
        sessionFactory.close();
    }

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(KeyBoard.class);

        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "KavinDharani@3");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/finalHibernate");
        configuration.setProperty("hibernate.connection.Driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.cache.use_second_level_cache", "true");
        configuration.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
//       configuration.setProperty("net.sf.ehcache.configurationResourceName", "/ehcache.xml");

        configuration.setProperty("hibernate.format_sql", "true");

        return configuration;
    }

    private static SessionFactory buildSessionFactory() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
