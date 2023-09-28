package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

//************************************************************
/*We are making a small console based application
Using spring ORM.
CRUD application.*/
//************************************************************

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//        Student student = new Student(33, "Robin Chan", "Tokyo");
//        student.setStudentId(129);
//        student.setStudentName("Jack Ma");
//        student.setStudentCity("Beijing");
//        
//        int r = studentDao.insert(student);
//        System.out.println("Done..."+r);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;

		while (go) {
			System.out.println("PRESS 1 for adding new Student");
			System.out.println("PRESS 2 for display all Student");
			System.out.println("PRESS 3 for display details of single Student");
			System.out.println("PRESS 4 for delete Student");
			System.out.println("PRESS 5 for update Student");
			System.out.println("PRESS 6 for Exit");

			try {
				int input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					// adding std

					// Taking id, name and city from user
					System.out.println("Enter user id: ");
					int uid = Integer.parseInt(br.readLine());

					System.out.println("Enter user name: ");
					String uName = br.readLine();

					System.out.println("Enter user city: ");
					String uCity = br.readLine();

					// Storing the user inputs in Student obj
					Student s = new Student();
					s.setStudentId(uid);
					s.setStudentName(uName);
					s.setStudentCity(uCity);

					// Saving the student obj in database using studentDao obj and calling insert
					// method of StudentDao.java
					int r = studentDao.insert(s); // Returns the id set of the std
					System.out.println("Successfully added student.");
					System.out.println("************************************************");

					break;
				case 2:
					// display all students

					// using getAll() method
					System.out.println("************************************************");
					List<Student> allStds = studentDao.getAll();
					for (Student std : allStds) {
						System.out.println("----------------------------------------------");
						System.out.println("Id: " + std.getStudentId());
						System.out.println("Name: " + std.getStudentName());
						System.out.println("City: " + std.getStudentCity());
					}
					System.out.println("************************************************");
					break;

				case 3:
					// get single std data

					// Taking user id
					System.out.println("Enter user id: ");
					int userId = Integer.parseInt(br.readLine());

					// input the id as parameter in getStudent() method
					Student student = studentDao.getStudent(userId);

					// Printing the result
					System.out.println("----------------------------------------------");
					System.out.println("Id: " + student.getStudentId());
					System.out.println("Name: " + student.getStudentName());
					System.out.println("City: " + student.getStudentCity());
					System.out.println("************************************************");
					break;
				case 4:
					// delet std

					// Taking user id
					System.out.println("Enter user id: ");
					int user_Id = Integer.parseInt(br.readLine());

					// input the id as parameter in deleteStd() method
					studentDao.deleteStd(user_Id);
					
					//Printing output
					System.out.println("----------------------------------------------");
					System.out.println("Successfully Deleted!");
					System.out.println("************************************************");

					break;
				case 5:
					// update std
					
					// Taking id, name and city from user
					System.out.println("Enter user id: ");
					int u_id = Integer.parseInt(br.readLine());

					System.out.println("Enter user name: ");
					String u_Name = br.readLine();

					System.out.println("Enter user city: ");
					String u_City = br.readLine();

					// Storing the user inputs in Student obj
					Student stds = new Student();
					stds.setStudentId(u_id);
					stds.setStudentName(u_Name);
					stds.setStudentCity(u_City);
					
					//updating the value of stds in database
					studentDao.updateStd(stds);
					
					//Printing output
					System.out.println("----------------------------------------------");
					System.out.println("Successfully Updated!");
					System.out.println("************************************************");
					break;
					
				case 6:
					// exit
					go = false;
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid Input. Try Again!");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Bye bye. See you again!");

	}
}
