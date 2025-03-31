package it.unito.jpasession.repository;

import it.unito.jpasession.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findBySessionId(String sessionId);
}
