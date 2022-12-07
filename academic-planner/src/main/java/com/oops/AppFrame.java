package com.oops;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AppFrame{
    static JFrame mainFrame;
    static{
        mainFrame = new JFrame("Academic Planner");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(0, 0, 1000, 750);
    }
    public void refresh(){
        mainFrame.setVisible(true);
    }
}

abstract class LogoPanel extends AppFrame{
    JPanel logoPanel;
    public LogoPanel(){
        logoPanel = new JPanel();
        mainFrame.setContentPane(logoPanel);
        GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{1, 0};
		gbl_contentPane.rowHeights = new int[]{4, 301, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		logoPanel.setLayout(gbl_contentPane);

        JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/Screenshot 2022-12-06 212157a.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		logoPanel.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
    }
}
class RegisterPanel extends LogoPanel{
    public RegisterPanel(){
        JButton button = new JButton("Register Now");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegisterFormPanel();
            }
        });
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridx = 0;
		gbc_button.gridy = 1;
		logoPanel.add(button, gbc_button);
        refresh();
    }
}
class LoginPanel extends LogoPanel{
    public LoginPanel(){
        JButton button = new JButton("Login");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginFormPanel();
            }
        });
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridx = 0;
		gbc_button.gridy = 1;
		logoPanel.add(button, gbc_button);
        refresh();
    }
}

class LoginFormPanel extends AppFrame implements ActionListener{
    JPanel loginFormPanel;
    JPasswordField passwordField;
    public LoginFormPanel(){
        loginFormPanel = new JPanel();
        mainFrame.setContentPane(loginFormPanel);

        GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{151, 1, 151, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 28, 28, 28, 28, 28, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		loginFormPanel.setLayout(gbl_contentPane);
		
        JButton backButton = new JButton("Back");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.insets = new Insets(0, 20, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 0;
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginPanel();
            }
        });
		loginFormPanel.add(backButton, gbc_btnNewButton_1);
        
		JLabel lblNewLabel_1 = new JLabel("Password");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		loginFormPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.anchor = GridBagConstraints.NORTH;
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 5;
		loginFormPanel.add(passwordField, gbc_passwordField);
		
		JButton btnNewButton = new JButton("Enter");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 7;
		loginFormPanel.add(btnNewButton, gbc_btnNewButton);

        btnNewButton.addActionListener(this);

        refresh();
    }

    public void actionPerformed(ActionEvent e){
        System.out.println(passwordField.getPassword());
        new HomePanel();
    }
}
class RegisterFormPanel extends AppFrame implements ActionListener{
    JPanel registerFormPanel;
    JTextField emailField;
    JPasswordField passwordField;
    public RegisterFormPanel(){
        registerFormPanel = new JPanel();
        mainFrame.setContentPane(registerFormPanel);

        GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{151, 1, 151, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 28, 28, 28, 28, 28, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		registerFormPanel.setLayout(gbl_contentPane);
		
        JButton backButton = new JButton("Back");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.insets = new Insets(0, 20, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 0;
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegisterPanel();
            }
        });
		registerFormPanel.add(backButton, gbc_btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		registerFormPanel.add(lblNewLabel, gbc_lblNewLabel);
		
        emailField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 4;
		registerFormPanel.add(emailField, gbc_textField);
		emailField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		registerFormPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.anchor = GridBagConstraints.NORTH;
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 6;
		registerFormPanel.add(passwordField, gbc_passwordField);
		
		JButton btnNewButton = new JButton("Register");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 7;
		registerFormPanel.add(btnNewButton, gbc_btnNewButton);

        btnNewButton.addActionListener(this);

        refresh();
    }

    public void actionPerformed(ActionEvent e){
        System.out.println(emailField.getText());
        System.out.println(passwordField.getPassword());
        // TODO FN CALL AND HANDLE HERE
		new HomePanel();
    }
}

class HomePanel extends AppFrame{
    JPanel homePanel;
    public HomePanel(){
        homePanel = new JPanel();
        mainFrame.setContentPane(homePanel);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{59, 0};
		gbl_contentPane.rowHeights = new int[]{48, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		homePanel.setLayout(gbl_contentPane);
		
		Box verticalBox = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.insets = new Insets(20, 20, 20, 20);
		gbc_verticalBox.gridx = 0;
		gbc_verticalBox.gridy = 0;
		homePanel.add(verticalBox, gbc_verticalBox);

		JPanel panel = new JPanel();
		verticalBox.add(panel);
        JButton button = new JButton("Courses");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CoursePanel();
			}
		});
        panel.add(button);

		JPanel panel1 = new JPanel();
		verticalBox.add(panel1);
        JButton button1 = new JButton("Opt 2");
		button1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel1.add(button1);

		JPanel panel2 = new JPanel();
		verticalBox.add(panel2);
        JButton button2 = new JButton("Opt 3");
		button2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel2.add(button2);

        refresh();
    }
}

class CoursePanel extends AppFrame{
	JPanel coursePanel;
	JButton addCourse;

	ArrayList<String> courses;
	public CoursePanel(){
		coursePanel = new JPanel();
        mainFrame.setContentPane(coursePanel);

		courses = Courses.getCourses();

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{59, 0};
		gbl_contentPane.rowHeights = new int[]{48, 107, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		coursePanel.setLayout(gbl_contentPane);

		Box verticalBox = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.gridx = 0;
		gbc_verticalBox.gridy = 0;
		coursePanel.add(verticalBox, gbc_verticalBox);

		for (String course:courses){
			JPanel panel = new JPanel();
			panel.setBorder(null);
			verticalBox.add(panel);
			
			JLabel lblNewLabel = new JLabel(course);
			panel.add(lblNewLabel);

			JButton btnNewButton_2 = new JButton("Remove");
			btnNewButton_2.putClientProperty( "course", course);
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (Courses.removeCourse((String)((JButton)e.getSource()).getClientProperty( "course" ))){
						new CoursePanel();
					}
					else{
						//failed
					}
				}
			});
			panel.add(btnNewButton_2);
		}

		addCourse = new JButton("Add Course");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField courseName = new JTextField();
				JTextField courseId = new JTextField();
				JSpinner courseCredits = new JSpinner();
				Object[] message = {
					"Course Name:", courseName,
					"Course ID:", courseId,
					"Course Credits:",courseCredits
				};

				int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					if (Courses.addCourse(courseName.getText(), courseId.getText(), (Integer)courseCredits.getValue())){
						new CoursePanel();
					}
					else{
						// failed
					}
				} else {
					// none
				}
			}
		});
		coursePanel.add(addCourse, gbc_btnNewButton);
		refresh();
	}
}