package com.example.dao;

import com.example.models.Task;
import com.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

public class TaskDaoImpl extends CRUDTaskManagerImpl<Task> {
    public TaskDaoImpl() {
        super(Task.class);
    }

    public List<Task> getAllTasksOfUser(String idUser) {
        List<Task> tasks = new LinkedList<>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query query = session.createQuery("from Task where user_id = :idUser");
        query.setParameter("idUser", idUser);
        tasks = query.getResultList();
        return tasks;
    }

    public Task findById(String id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Task entity = session.get(Task.class, id);
        session.close();
        return entity;
    }

    public void delete(String idTask) {
        Task task = findById(idTask);
        if (task != null) {
            delete(task);
        }
    }
}
