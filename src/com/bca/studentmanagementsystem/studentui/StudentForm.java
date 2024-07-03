package com.bca.studentmanagementsystem.studentui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bca.studentmanagementsystem.model.Student;
import com.bca.studentmanagementsystem.services.StudentServices;
import com.bca.studentmanagementsystem.services.StudentServicesImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentForm extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JTextField contactTextField;
	StudentServices studentServices = new StudentServicesImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentForm frame = new StudentForm();
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
	public StudentForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 751);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblName.setBounds(83, 50, 90, 31);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAddress.setBounds(83, 113, 90, 31);
		contentPane.add(lblAddress);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblContact.setBounds(83, 188, 90, 31);
		contentPane.add(lblContact);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGender.setBounds(83, 269, 90, 31);
		contentPane.add(lblGender);
		
		JLabel lblFaculty = new JLabel("Faculty");
		lblFaculty.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblFaculty.setBounds(83, 359, 90, 31);
		contentPane.add(lblFaculty);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSubject.setBounds(83, 449, 90, 31);
		contentPane.add(lblSubject);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nameTextField.setBounds(257, 50, 198, 33);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		addressTextField.setColumns(10);
		addressTextField.setBounds(257, 113, 198, 33);
		contentPane.add(addressTextField);
		
		contactTextField = new JTextField();
		contactTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contactTextField.setColumns(10);
		contactTextField.setBounds(257, 186, 198, 33);
		contentPane.add(contactTextField);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnMale.setBounds(257, 258, 79, 42);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnFemale.setBounds(362, 258, 101, 42);
		contentPane.add(rdbtnFemale);
		
		JRadioButton rdbtnOthers = new JRadioButton("Others");
		rdbtnOthers.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnOthers.setBounds(477, 258, 79, 42);
		contentPane.add(rdbtnOthers);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);
		bg.add(rdbtnOthers);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BCA", "BCSIT", "BIM", "BIT"}));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox.setBounds(257, 348, 198, 42);
		contentPane.add(comboBox);
		
		
		JCheckBox chckbxC = new JCheckBox("C");
		chckbxC.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		chckbxC.setBounds(257, 456, 60, 21);
		contentPane.add(chckbxC);
		
		JCheckBox chckbxJava = new JCheckBox("Java");
		chckbxJava.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		chckbxJava.setBounds(362, 456, 79, 21);
		contentPane.add(chckbxJava);
		
		JCheckBox chckbxPhp = new JCheckBox("PHP");
		chckbxPhp.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		chckbxPhp.setBounds(464, 456, 92, 21);
		contentPane.add(chckbxPhp);
		
		JCheckBox chckbxAssembly = new JCheckBox("Assembly");
		chckbxAssembly.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		chckbxAssembly.setBounds(257, 520, 117, 31);
		contentPane.add(chckbxAssembly);
		
		JCheckBox chckbxDotnet = new JCheckBox("Dotnet");
		chckbxDotnet.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		chckbxDotnet.setBounds(395, 520, 101, 31);
		contentPane.add(chckbxDotnet);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameTextField.getText();
				String address = addressTextField.getText();
				String contact = contactTextField.getText();
				long contactLong = Long.parseLong(contact);
				String gender = "";
				if(rdbtnMale.isSelected()) {
					gender = "male";
				}
				else if(rdbtnFemale.isSelected()) {
					gender = "female";
				}
				else if (rdbtnOthers.isSelected()) {
					gender = "others";
				}
				String faculty = (String)comboBox.getSelectedItem();
				String subject = "";
				if(chckbxC.isSelected()) {
					subject += " C/";
				}
				if(chckbxJava.isSelected()) {
					subject += " Java/";
				}
				if(chckbxDotnet.isSelected()) {
					subject += " Dotnet/";
				}
				if(chckbxPhp.isSelected()) {
					subject += " Php/";
				}
				if(chckbxAssembly.isSelected()) {
					subject += "Assembly/";
				}
				Student student = new Student();
				student.setName(name);
				student.setAddress(address);
				student.setContact(contactLong);
				student.setGender(gender);
				student.setSubject(subject);
				student.setFaculty(faculty);
				
				studentServices.saveStudent(student);
				dispose();
				StudentDetails studentDetails = new StudentDetails();
				studentDetails.setVisible(true);
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnSubmit.setBounds(202, 614, 134, 52);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudentDetails details = new StudentDetails();
				details.setVisible(true);
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnCancel.setBounds(405, 614, 134, 52);
		contentPane.add(btnCancel);
	}
}
