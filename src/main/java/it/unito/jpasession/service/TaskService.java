package it.unito.jpasession.service;

import it.unito.jpasession.model.Task;
import it.unito.jpasession.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> getTasksForSession(String sessionId){
        return taskRepository.findBySessionId(sessionId);
    }
    public Task addTaskForSession(String sessionId, Task task){
        task.setSessionId(sessionId);
        return taskRepository.save(task);
    }
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
