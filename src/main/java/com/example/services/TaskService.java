package com.example.services;

import com.example.dao.TaskDaoImpl;
import com.example.models.Task;
import com.example.models.User;

import java.util.List;

public class TaskService {

    private TaskDaoImpl taskDao;

    public TaskService() {
        taskDao = new TaskDaoImpl();
    }

    public List<Task> getAllTaskOfUser(String idUser) {
        return taskDao.getAllTasksOfUser(idUser);
    }

    public void addTask(Task task, String idUser) {
        if (task.getUser() == null && task.getUser().getId() == null) {
            task.setUser(new User(idUser));
        }
        if (task.getId() == null) {
            task.generateTaskId();
        }
        taskDao.save(task);
    }

    public void editTask(Task task, String idUser) {
        if (task.getUser() == null) {
            task.setUser(new User(idUser));
        }
        taskDao.update(task);
    }

    public void deleteTask(String idTask) {
        taskDao.delete(idTask);
    }
}
