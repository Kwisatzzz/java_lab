package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class ShapeDAO {
    private static final String PERSISTENCE_UNIT_NAME = "shapesPU";
    private final EntityManagerFactory emf;

    public ShapeDAO() {
        this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public void save(Shape shape) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            if (shape.getId() == null || em.find(shape.getClass(), shape.getId()) == null) {
                em.persist(shape);
            } else {
                em.merge(shape);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public <T extends Shape> T findById(Class<T> shapeType, Long id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(shapeType, id);
        } finally {
            em.close();
        }
    }

    public <T extends Shape> List<T> findAll(Class<T> shapeType) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT s FROM " + shapeType.getSimpleName() + " s", shapeType)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public <T extends Shape> void deleteById(Class<T> shapeType, Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            T shape = em.find(shapeType, id);
            if (shape != null) {
                em.remove(shape);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
