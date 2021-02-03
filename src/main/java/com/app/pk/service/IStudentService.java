package com.app.pk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.pk.model.Student;

public interface IStudentService {
	public Integer saveStudent(Student s);
	public void updateStudent(Student s);
	public void deleteStudent(Integer id);
	
	public Optional<Student> getOneStudent(Integer id);
	public List<Student> getAllStudents();
	public Page<Student> getStudentsPage(Pageable p);
	public boolean isStudentExist(Integer id);
}
