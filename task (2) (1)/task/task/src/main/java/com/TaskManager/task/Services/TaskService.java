package com.TaskManager.task.Services;

import java.util.List;

import com.TaskManager.task.entity.Task;



public interface TaskService {
	
    public Task saveTask(Task tt);
	
	public List<Task> getAllTask();
		
	public void deleteTask(int id);
	
	public Task findByID(int id);

	
	public Task updateTask(Task task);
}
	


