package com.example.controllers;

import com.example.models.Task;
import com.example.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("task-api/task")
public class TaskController {
    @GetMapping("/{user_id}/all")
    public ResponseEntity getAllTasks(@PathVariable String user_id) {
        if (user_id != null && user_id.length() > 0) {
            TaskService taskService = new TaskService();
            List<Task> tasks = taskService.getAllTaskOfUser(user_id);
            return new ResponseEntity(tasks, HttpStatus.OK);
        } else {
            return new ResponseEntity("Error: Invalid parameter of request", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("{user_id}/add")
    public ResponseEntity addTask(@PathVariable String user_id, @RequestBody Task task) {
        if (user_id != null && user_id.length() > 0 && task != null && task.getDate() != null && task.getDate() != null) {
            TaskService taskService = new TaskService();
            taskService.addTask(task, user_id);
            return new ResponseEntity(task, HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Error: Invalid parameter of request", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("{user_id}/edit")
    public ResponseEntity editTask(@PathVariable String user_id, @RequestBody Task task) {
        if (user_id != null && user_id.length() > 0 && task != null && task.getId() != null) {
            TaskService taskService = new TaskService();
            taskService.editTask(task, user_id);
            return new ResponseEntity(task, HttpStatus.OK);
        } else {
            return new ResponseEntity("Error: Invalid parameter of request", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{user_id}/delete")
    public ResponseEntity deleteTask(@PathVariable String user_id, @PathParam("idTask") String idTask) {
        if (user_id != null && user_id.length() > 0 && idTask != null) {
            TaskService taskService = new TaskService();
            taskService.deleteTask(idTask);
            return new ResponseEntity(idTask, HttpStatus.OK);
        } else {
            return new ResponseEntity("Error: Invalid parameter of request", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{user_id}/deleteV2")
    public ResponseEntity deleteTaskV2(@PathVariable String user_id, @PathParam("idTask") String idTask) {
        return deleteTask(user_id, idTask);
    }

    @GetMapping("/test")
    public ResponseEntity testConnection() {
        return new ResponseEntity("Successful test task-manager-api", HttpStatus.OK);
    }

    private boolean validateTask(Task task) {
        return false;
    }

}
