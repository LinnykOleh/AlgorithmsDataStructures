package com.linnyk.jpa.safari.data.apps;

import com.linnyk.jpa.safari.data.entities.User;
import com.linnyk.jpa.safari.data.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class UserApp {

    @Test
    public void testAnnotation() {
        final Session session = HibernateUtil.getSessionFactoryAnnotation().openSession();
        session.beginTransaction();

        final User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedDate(new Date());
        user.setCreatedBy("Oleh ANNOTATION 1");
        user.setEmailAddress("Oleh@Linnyk.com");
        user.setFirstName("Oleh");
        user.setLastName("Linnyk");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Oleh");

        session.save(user);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testXML() {
        final Session session = HibernateUtil.getSessionFactoryXML().openSession();
        session.beginTransaction();

        final User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedDate(new Date());
        user.setCreatedBy("Oleh XML 1");
        user.setEmailAddress("Oleh@Linnyk.com");
        user.setFirstName("Oleh");
        user.setLastName("Linnyk");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Oleh");

        session.save(user);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testUpdateNotUpdatable() {
        final Session session = HibernateUtil.getSessionFactoryXML().openSession();
        session.beginTransaction();

        final User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedDate(new Date());
        user.setCreatedBy("Oleh XML 1");
        user.setEmailAddress("Oleh@Linnyk.com");
        user.setFirstName("Oleh");
        user.setLastName("Linnyk");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Oleh");

        session.save(user);
        session.getTransaction().commit();

        session.beginTransaction();
        final User user1 = session.get(User.class, user.getUserId());
        user.setFirstName("Oleh New");

        session.update(user1);
        /*
            update
                FINANCES_USER
            set
                BIRTH_DATE=?,
                EMAIL_ADDRESS=?,
                FIRST_NAME=?,
                LAST_NAME=?,
                LAST_UPDATED_BY=?,
                LAST_UPDATED_DATE=?
            where
                USER_ID=?
         */
        session.getTransaction().commit();

        session.close();
    }

    @Test
    public void testTransient() {
        final Session session = HibernateUtil.getSessionFactoryXML().openSession();
        session.beginTransaction();

        final User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedDate(new Date());
        user.setCreatedBy("Oleh XML 1");
        user.setEmailAddress("Oleh@Linnyk.com");
        user.setFirstName("Oleh");
        user.setLastName("Linnyk");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Oleh");
        user.setValid(true);

        session.save(user); // insert
                            // into
                            //    FINANCES_USER
                            //    (USER_ID, BIRTH_DATE, CREATED_BY, CREATED_DATE, EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, LAST_UPDATED_BY, LAST_UPDATED_DATE)
                            // values
                            //    (null, ?, ?, ?, ?, ?, ?, ?, ?)
                            // There is no VALID field
        session.getTransaction().commit();

        session.close();
    }

    @Test
    public void testFormula() {
        final Session session = HibernateUtil.getSessionFactoryXML().openSession();
        session.beginTransaction();

        final User user = new User();
        user.setBirthDate(java.sql.Date.valueOf(LocalDate.of(1993, Month.MAY, 07)));
        user.setCreatedDate(new Date());
        user.setCreatedBy("Oleh XML 1");
        user.setEmailAddress("Oleh@Linnyk.com");
        user.setFirstName("Oleh");
        user.setLastName("Linnyk");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Oleh");
        user.setValid(true);

        session.save(user);
        session.getTransaction().commit();

        session.refresh(user);

        session.close();

        System.out.println("My age is: " + user.getAge()); // My age is: 25
    }
}
