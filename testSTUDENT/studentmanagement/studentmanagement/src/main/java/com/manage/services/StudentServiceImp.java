package com.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.dao.StudentRepository;
import com.manage.entity.Student;


@Service
public class StudentServiceImp implements StudentService {

	
	private StudentRepository studentRepo;
	
	
	@Autowired
	public StudentServiceImp(StudentRepository studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}

	@Override
	public Student saveStudent(Student std) {
		// TODO Auto-generated method stub
		return studentRepo.save(std);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		List<Student> findAll =studentRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		 studentRepo.deleteById(id);
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public Student findByID(int id) {
		Optional<Student> findByid=studentRepo.findById(id);
		Student stu=findByid.get();
		return stu;
	}
	
	
}
