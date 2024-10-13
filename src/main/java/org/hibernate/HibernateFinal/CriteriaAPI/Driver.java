package org.hibernate.HibernateFinal.CriteriaAPI;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Driver {
    static Configuration configuration = new Configuration();
    static SessionFactory sessionFactory;

    static {
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "KavinDharani@3");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernateFinal");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.cache.use_second_level_cache", "true");
        configuration.setProperty("hibernate.cache.use_query_level_cache", "true");
        configuration.setProperty("hibernate.cache.Region_factory", "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
    }

    static {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                                .applySettings(configuration.getProperties())
                                                .build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
}
