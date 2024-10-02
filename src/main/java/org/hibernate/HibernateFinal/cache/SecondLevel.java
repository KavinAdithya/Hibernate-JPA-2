package org.hibernate.HibernateFinal.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Transient;
import java.util.List;

public class SecondLevel {
    static Configuration configuration = getConfiguration();
    static SessionFactory sessionFactory = buildSessionFactory();
    public static void main(String[] args) {
        Laptop laptop = new Laptop("Mega Book", 1000.00, null );
        KeyBoard keyBoard = new KeyBoard("Dell", 2000.00);
        laptop.setKeyBoard(keyBoard);

        Session session = sessionFactory.openSession();
        String hql = "FROM Laptop l INNER JOIN l.keyBoard k ";

        Query<Object[]> query = session.createQuery(hql);
        query.setCacheable(true);
        List<Object[]> list = query.list();
        System.out.println(list.get(0)[0]);
        Session session1 = sessionFactory.openSession();
        String hql1 = "FROM Laptop l INNER JOIN l.keyBoard k ";

        Query<Object[]> query1 = session.createQuery(hql1);
        query1.setCacheable(true);
        List<Object[]> list1 = query1.list();

        System.out.println(list1.get(0)[0]);

        Query<Laptop> query2 = session1.createQuery("FROM Laptop where id = 1", Laptop.class);
        Laptop laptop3 = query2.uniqueResult();
        Laptop laptop1 = query2.getSingleResult();
        System.out.println(laptop3);
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
        configuration.setProperty("hibernate.cache.use_query_cache", "true");

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
