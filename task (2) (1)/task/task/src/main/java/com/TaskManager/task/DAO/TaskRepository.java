package com.TaskManager.task.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskManager.task.entity.Task;



public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	

}
