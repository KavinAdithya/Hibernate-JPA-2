package org.hibernate;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.entity.Laptop;
import org.hibernate.entity.Student;
import org.hibernate.service.ServiceRegistry;

public class DriverClass {
    //Driver mode
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("Hibernate.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();


        SessionFactory sessionFactory1 = config.buildSessionFactory(serviceRegistry);

        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();

        Laptop laptop = new Laptop();
            laptop.setName("Techno");
            laptop.setId(803);
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
