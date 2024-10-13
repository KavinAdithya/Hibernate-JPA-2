package org.hibernate.HibernateFinal.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;


import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;

public class SecondLevel {
    static Configuration configuration = getConfiguration();
    static SessionFactory sessionFactory = buildSessionFactory();
    public static void main(String[] args) {
        criteriaAPI1();
    }

    public static void criteriaAPI1() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Laptop> criteriaQuery = criteriaBuilder.createQuery(Laptop.class);
        Root<Laptop> root = criteriaQuery.from(Laptop.class);


        Predicate predicate = criteriaBuilder.greaterThan(root.get("id"), 2);

        criteriaQuery.select(root).where(predicate);

        TypedQuery<Laptop> typedQuery = session.createQuery(criteriaQuery);

        System.out.println(typedQuery.getResultList());

        session.close();
        sessionFactory.close();
    }


    public static void criteriaAPI() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Laptop> criteriaQuery = criteriaBuilder.createQuery(Laptop.class);

        Root<Laptop> root = criteriaQuery.from(Laptop.class);

        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), "Mega Book"));

        TypedQuery<Laptop> typedQuery = session.createQuery(criteriaQuery);

        List<Laptop> list = typedQuery.getResultList();

        for (Laptop laptop : list)
            System.out.println(laptop);


        session.close();
        sessionFactory.close();
    }
    public static void fetch() {
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Laptop laptop = session.get(Laptop.class, 4);

        session.getTransaction().commit();

        session.close();
        System.out.println(laptop.getKeyBoard());


        sessionFactory.close();
    }

    private static void pagination() {
        Session session = sessionFactory.openSession();


        Transaction transaction = session.getTransaction();
        transaction.begin();

        String hql = "from Laptop l Inner Join l.keyBoard k where l.id = 4";

        Query<Object[]> query = session.createQuery(hql);
        query.setCacheable(true);

        Object[] lap = query.uniqueResult();

        System.out.println(Arrays.toString(lap));

        Query<Object[]> query1 = session.createQuery(hql);
        query1.setCacheable(true);
        Object[] lap1 = query1.uniqueResult();

        System.out.println(Arrays.toString(lap1));
        transaction.commit();

        session.close();
        sessionFactory.close();
    }



    private static void hql() {
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
