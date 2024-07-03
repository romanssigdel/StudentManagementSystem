package com.bca.studentmanagementsystem.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.bca.studentmanagementsystem.databaseconnection.DatabaseConnection;
import com.bca.studentmanagementsystem.model.Student;

public class StudentServicesImpl implements StudentServices{
	PreparedStatement ps = null;
	
	@Override
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		List<Student> studentList = new ArrayList<>();
		try {
			String sql = "Select * from student";
			ps= DatabaseConnection.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {				
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setAddress(rs.getString("address"));
			student.setGender(rs.getString("gender"));
			student.setContact(rs.getLong("contact"));
			student.setFaculty(rs.getString("faculty"));
			student.setSubject(rs.getString("subject"));
			studentList.add(student);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return studentList;
	}

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			String sql = "Insert into student(name,address,contact,gender,faculty,subject)values(?,?,?,?,?,?)";
			ps=DatabaseConnection.getConnection().prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getAddress());
			ps.setLong(3, student.getContact());
			ps.setString(4, student.getGender());
			ps.setString(5, student.getFaculty());
			ps.setString(6, student.getSubject());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

	@Override
	public List<Student> searchForStudentByString(String name) {
		// TODO Auto-generated method stub
		List<Student> studentList = new ArrayList<>();
		try {
			String sql = "Select * from student where name like ?";
			ps= DatabaseConnection.getConnection().prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {				
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setAddress(rs.getString("address"));
			student.setGender(rs.getString("gender"));
			student.setContact(rs.getLong("contact"));
			student.setFaculty(rs.getString("faculty"));
			student.setSubject(rs.getString("subject"));
			studentList.add(student);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return studentList;
		
	}

}
