package com.example.dao;

import com.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class CRUDTaskManagerImpl<T> implements CRUDTaskManager<T> {
    private final Class<T> type;

    public CRUDTaskManagerImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public List<T> getAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(this.type);
        criteria.from(this.type);
        List<T> entityList = session.createQuery(criteria).getResultList();
        session.close();
        return entityList;
    }

    @Override
    public void save(T entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(T entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(T entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public T findById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        T entity = session.get(this.type, id);
        session.close();
        return entity;
    }
}
