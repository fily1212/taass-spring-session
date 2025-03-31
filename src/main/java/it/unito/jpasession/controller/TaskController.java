package it.unito.jpasession.controller;

import it.unito.jpasession.model.Task;
import it.unito.jpasession.service.TaskService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task, HttpSession session){
        return taskService.addTaskForSession(session.getId(), task);
    }

    @GetMapping
    public List<Task> getTasks(HttpSession session){
        return taskService.getTasksForSession(session.getId());
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

}
