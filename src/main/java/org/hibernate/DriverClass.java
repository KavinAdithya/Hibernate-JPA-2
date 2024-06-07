package org.hibernate;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.entity.Laptop;
import org.hibernate.entity.Student;
import org.hibernate.service.ServiceRegistry;

public class DriverClass {
    //Driver mode
    public static void main(String[] args) {
        transaction();
    }

    public static void transaction(){
        Laptop laptop = new Laptop();
        laptop.setPrice(4500.00);
        laptop.setName("ASH");
        laptop.setId(3333);

        Laptop laptop1 = new Laptop();
        laptop1.setPrice(3500.00);
        laptop1.setName("ASH");
        laptop1.setId(433);
        try{
            Configuration configure = new Configuration()
                    .addAnnotatedClass(Laptop.class);
            configure.configure("Hibernate.xml");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configure.getProperties())
                    .build();

            SessionFactory sessionFactory = configure.buildSessionFactory();

            Session session = sessionFactory.openSession();

            try{
                session.getTransaction().begin();

                session.persist(laptop1);
                session.persist(laptop);

                session.getTransaction().commit();
            }catch(Exception e){
//                if(session != null)
//                    session.getTransaction().rollback();
                e.printStackTrace();
            }
        } catch(Exception e){
          e.printStackTrace();
        }
    }
    public static void performMapping(){
        Configuration config = new Configuration();
        config.configure("Hibernate.xml")
                .addResource("Mapping.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();


        SessionFactory sessionFactory1 = config.buildSessionFactory(serviceRegistry);

        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();

        Laptop laptop = new Laptop();
        laptop.setName("Techno");
        //laptop.setId(83);
        laptop.setPrice(10091.0);
        laptop.setStudent(null);

        session.getTransaction().begin();
        session.persist(laptop);
        laptop.setPrice(452222.0078);

        //session.update(laptop);
        session.getTransaction().commit();

//            laptop.setPrice(4562.00);
//            session.getTransaction().begin();
//            session.update(laptop);
//            session.getTransaction().commit();

//            Session session1 = sessionFactory1.openSession();
//            session1.getTransaction().begin();
//
//            session1.getTransaction().commit();


    }
}
