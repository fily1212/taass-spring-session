package it.unito.jpasession.repository;

import it.unito.jpasession.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findBySessionId(String sessionId);

    @Modifying
    @Query("DELETE FROM Task t where t.sessionId not in (:sessionIds)")
    void deleteTasksNotInSession(List<String> sessionIds);
}
