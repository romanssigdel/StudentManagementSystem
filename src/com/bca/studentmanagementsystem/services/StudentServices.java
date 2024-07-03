package com.bca.studentmanagementsystem.services;
import java.util.List;

import com.bca.studentmanagementsystem.model.Student;

public interface StudentServices {
	public void saveStudent(Student student);
	public List<Student> getStudent();
}
