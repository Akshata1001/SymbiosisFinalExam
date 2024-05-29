package com.TaskManager.task.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManager.task.DAO.TaskRepository;
import com.TaskManager.task.entity.Task;



@Service
public class TaskServiceIMP implements TaskService {
	
	private TaskRepository taskRepo;
	
	@Autowired
	public TaskServiceIMP(TaskRepository taskRepo) {
		super();
		this.taskRepo = taskRepo;
	}
	
	

	@Override
	public Task saveTask(Task tt) {
		// TODO Auto-generated method stub
		return taskRepo.save(tt);
	}

	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		List<Task> findAll=taskRepo.findAll();
		return findAll;
		
	}

	@Override
	public void deleteTask(int id) {
		// TODO Auto-generated method stub
		taskRepo.deleteById(id);
		
	}

	@Override
	public Task findByID(int id) {
		// TODO Auto-generated method stub
		Optional<Task> findByid=taskRepo.findById(id);
		Task tt=findByid.get();
		return tt;
		
	}

	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepo.save(task);
		
	}

}
