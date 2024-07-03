package com.bca.studentmanagementsystem.studentui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.bca.studentmanagementsystem.model.Student;
import com.bca.studentmanagementsystem.services.StudentServices;
import com.bca.studentmanagementsystem.services.StudentServicesImpl;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudentDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;
	StudentServices studentServices = new StudentServicesImpl();
	private JTextField searchTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetails frame = new StudentDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentDetails() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(36, 84, 747, 416);
		contentPane.add(table);
		
		String columnName[]= {"id","name","address","contact","gender","faculty","services"};
		DefaultTableModel model = new DefaultTableModel(columnName,0);
		table.setModel(model);
		
		loadValueInTable();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 84, 747, 416);
		contentPane.add(scrollPane);
		
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudentForm studentForm = new StudentForm();
				studentForm.setVisible(true);
			}
		});
		btnNew.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNew.setBounds(78, 559, 119, 42);
		contentPane.add(btnNew);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEdit.setBounds(260, 559, 119, 42);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDelete.setBounds(462, 559, 119, 42);
		contentPane.add(btnDelete);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblSearch.setBounds(446, 21, 78, 29);
		contentPane.add(lblSearch);
		
		searchTextField = new JTextField();
		searchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			String searchName = searchTextField.getText();
			if(searchName == null || searchName.isEmpty()) {
				loadValueInTable();
			}
			else {
				searchValueInTable(searchName);
			}
			}
		});
		searchTextField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		searchTextField.setBounds(552, 21, 156, 28);
		contentPane.add(searchTextField);
		searchTextField.setColumns(10);
	}
	public void loadValueInTable() {
		List<Student> studentList= studentServices.getStudent();
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		
		for(Student student: studentList) {
			tableModel.addRow(new Object[] {student.getId(),student.getName(),student.getAddress(),student.getContact(),student.getGender(),student.getFaculty(),student.getSubject()});
		}
	}
	public void searchValueInTable(String name) {
		List<Student> studentList= studentServices.searchForStudentByString(name);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		
		for(Student student: studentList) {
			tableModel.addRow(new Object[] {student.getId(),student.getName(),student.getAddress(),student.getContact(),student.getGender(),student.getFaculty(),student.getSubject()});
		}
	}
}
