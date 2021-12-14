package org.hbrs.se2.project.npng.repository.impl;

import org.hbrs.se2.project.npng.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserInsertRepository {

    @PersistenceContext
    private EntityManager entityManager;
    private EntityManagerFactory emFactory;

    public UserInsertRepository(){

        //emFactory = Persistence.createEntityManagerFactory("test");
        //entityManager = emFactory.createEntityManager();
    }

    @Transactional
    public void insert(User user){

        entityManager.getTransaction().begin();
        this.entityManager.persist(user);
        this.entityManager.flush();

        entityManager.close();
        emFactory.close();
    }
}
