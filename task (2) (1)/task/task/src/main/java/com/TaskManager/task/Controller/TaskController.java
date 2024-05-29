package com.TaskManager.task.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TaskManager.task.Services.TaskService;
import com.TaskManager.task.entity.Task;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class TaskController {
	
	private TaskService taskservice;

	@Autowired
	public TaskController(TaskService taskservice) {
		super();
		this.taskservice = taskservice;
	}
	
	@GetMapping("/fff")
	public String saveTask(Model model) {
		model.addAttribute("task", new Task());
		return "addtask" ;	
	}
	
	@PostMapping("/savetask")
	public String getStatus(@Valid @ModelAttribute("task") Task task, BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return "addTask";
		}
		taskservice.saveTask(task);
		return "redirect:/read";
	}
	
	
	@GetMapping("/read")
	public String displayAllTask(Model model){
		List<Task> tasklist =taskservice.getAllTask();
		model.addAttribute("task", tasklist );
		return "display";
	}
	
	
	@PostMapping("/task/delete")
	public String deleteTT(@RequestParam("id") int ttID, Model model) {
		taskservice.deleteTask(ttID);
		String deleteMessage ="Task succesfully deleated with ID:"+ttID;
		model.addAttribute("message", deleteMessage);
		return "redirect:/read";
	}
	
	
	@GetMapping("/task/update")
	public String updateTT(@RequestParam("id") int id, Model model) {
		Task task =taskservice.findByID(id);
		model.addAttribute("task", task);
		return "updateForm";		
	}
	
	@PostMapping("/saveupdate")
	public String getUpdate(@Valid @ModelAttribute("task") Task task, BindingResult bindresult) {
		System.out.println(bindresult.getAllErrors());
		if(bindresult.hasErrors()) {
			return "updateForm";
		}
		taskservice.updateTask(task);
		return "redirect:/read";
		
	}

	
}

	
	





