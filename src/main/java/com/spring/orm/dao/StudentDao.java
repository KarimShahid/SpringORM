package com.spring.orm.dao;



import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDao {
	

	private HibernateTemplate hibernateTemplate;
	
	//Save student
	@Transactional
	public int insert(Student student) {
		//Insert 
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
		
	}

	//Get Single data
	//No need for @Transactional for reading data
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	
	//Get multiple data
	//No need for @Transactional for reading data
	public List<Student> getAll(){
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
		
	}
	
	@Transactional
	//delete row based on id
	public void deleteStd(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	
	@Transactional
	//Updating the row with student obj
	public void updateStd(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	
	
}
