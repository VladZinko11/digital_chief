package com.digitalchief.zinko.digital_chief_test.data.repository;

import com.digitalchief.zinko.digital_chief_test.data.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}