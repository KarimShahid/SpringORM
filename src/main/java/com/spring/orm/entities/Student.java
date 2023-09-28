package com.spring.orm.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "student_details")   //for naming the table
public class Student {
	
	
	@Id
	@Column(name = "student_id") //naming the column
	private int studentId;
	
	@Column(name = "student_name")
	private String studentName;
	
	@Column(name = "student_city")
	private String studentCity;
}

