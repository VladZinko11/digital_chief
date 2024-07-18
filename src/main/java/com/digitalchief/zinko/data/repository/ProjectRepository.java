package com.digitalchief.zinko.data.repository;

import com.digitalchief.zinko.data.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}