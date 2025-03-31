package it.unito.jpasession.service;

import it.unito.jpasession.repository.TaskRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskCleanupService {

    @PersistenceContext
    private EntityManager entityManager;

    private final TaskRepository taskRepository;
    public TaskCleanupService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    @Scheduled(fixedRate = 60000)
    public void cleanup() {
        List<String> activeSessionIds = entityManager.createNativeQuery("select SESSION_ID from SPRING_SESSION")
                .getResultList();
        taskRepository.deleteTasksNotInSession(activeSessionIds);
    }
}
