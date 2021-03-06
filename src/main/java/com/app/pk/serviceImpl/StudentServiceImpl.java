package com.app.pk.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.pk.model.Student;
import com.app.pk.repo.StudentRepository;
import com.app.pk.service.IStudentService;
@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repo;
	
	@Override
	public Integer saveStudent(Student s) {
		int k=50;
		int j=40;
		return repo.save(s).getStdId();
	}

	@Override
	public void updateStudent(Student s) {
		repo.save(s);
	}

	@Override
	public void deleteStudent(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Student> getOneStudent(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@Override
	public boolean isStudentExist(Integer id) {
		return repo.existsById(id);
	}
	public Page<Student> getStudentsPage(Pageable p) {
		  return repo.findAll(p);
		}
}
