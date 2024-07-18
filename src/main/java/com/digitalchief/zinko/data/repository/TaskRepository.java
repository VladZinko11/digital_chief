package com.digitalchief.zinko.data.repository;

import com.digitalchief.zinko.data.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("from Task where project.id =:projectId")
    List<Task> findByProjectId(Long projectId);

    @Transactional
    @Modifying
    @Query("delete from Task where id=:id")
    void deleteById(Long id);
}