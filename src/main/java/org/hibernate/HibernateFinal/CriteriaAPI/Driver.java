package org.hibernate.HibernateFinal.CriteriaAPI;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Driver {
    static Configuration configuration = new Configuration();
    static SessionFactory sessionFactory;

    static {
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "KavinDharani@3");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/finalHibernate");
        configuration.setProperty("hibernate.connection.Driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.cache.use_second_level_cache", "true");
        configuration.setProperty("hibernate.cache.use_query_level_cache", "true");
        configuration.setProperty("hibernate.format_sql", "true");
        configuration.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
        configuration.addAnnotatedClass(Employee.class);


    }

    static {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                                .applySettings(configuration.getProperties())
                                                .build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Kavin",20, 1000000.00);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(employee);

        transaction.commit();
    }
}
