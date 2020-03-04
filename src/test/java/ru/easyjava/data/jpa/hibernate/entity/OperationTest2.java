package ru.easyjava.data.jpa.hibernate.entity;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
import javax.transaction.UserTransaction;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OperationTest2 {
    private EntityManagerFactory entityManagerFactory;

    @Before
    public void testManager() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
    }

    @Test
    public void testGreeter() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //saving new object
        tx.begin();
        Message message = new Message();
        message.setText("textMessage");
        em.persist(message);
        tx.commit();
        //reading saved object
        List<Message> messages = em.createQuery("select m from Message m").getResultList();
        assertEquals(messages.size(), 1);
        assertEquals(messages.get(0).getText(), "textMessage");
        //the end
        em.close();
    }
}