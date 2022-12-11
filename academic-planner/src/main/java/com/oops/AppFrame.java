package com.oops;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.*;

public class AppFrame{
    static JFrame mainFrame;
    static{
        mainFrame = new JFrame("Academic Planner");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(100, 100, 1000, 750);
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
		if (Registration.login(String.valueOf(passwordField.getPassword()))){
			new HomePanel();
		}
        else{
			PopupFrame.showErrorMessage();
		}
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
        if (Registration.register(emailField.getText(), String.valueOf(passwordField.getPassword()))){
			new HomePanel();
		}
		else{
			PopupFrame.showErrorMessage();
		}
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
        JButton button1 = new JButton("Calendar");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CalendarPanel();
			}
		});
		button1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel1.add(button1);

		JPanel panel2 = new JPanel();
		verticalBox.add(panel2);
        JButton button2 = new JButton("Attendance");
		button2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AttendancePanel();
			}
		});
        panel2.add(button2);

        refresh();
    }
}

class CoursePanel extends AppFrame{
	JPanel coursePanel;
	Courses courses;

	public CoursePanel(){
		coursePanel = new JPanel();
        mainFrame.setContentPane(coursePanel);

		courses = new Courses();

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0,59, 0};
		gbl_contentPane.rowHeights = new int[]{0, 107, 0};
		gbl_contentPane.columnWeights = new double[]{0.5,1.0,1.0,Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.5, 1.0,1.0, Double.MIN_VALUE};
		coursePanel.setLayout(gbl_contentPane);

		JPanel pane = new JPanel();
		GridBagConstraints gbc_pane = new GridBagConstraints();
		gbc_pane.anchor = GridBagConstraints.WEST;
		gbc_pane.insets = new Insets(0, 0, 5, 5);
		gbc_pane.fill = GridBagConstraints.VERTICAL;
		gbc_pane.gridx = 0;
		gbc_pane.gridy = 0;
		coursePanel.add(pane, gbc_pane);
		pane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton1 = new JButton("Back");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomePanel();
		}});
		pane.add(btnNewButton1);

		Box verticalBox = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.gridx = 1;
		gbc_verticalBox.gridy = 1;
		coursePanel.add(verticalBox, gbc_verticalBox);

		for (Course course:courses.courses){
			JPanel panel = new JPanel();
			panel.setBorder(null);
			verticalBox.add(panel);
			
			JLabel lblNewLabel = new JLabel(course.toString());
			panel.add(lblNewLabel);

			JButton btnNewButton_1 = new JButton("Set Weekly");
			btnNewButton_1.putClientProperty( "id", course.id);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Integer id = (Integer)((JButton)e.getSource()).getClientProperty( "id" );
					boolean[] weekly = courses.getWeekly(id);
					JRadioButton j1 = new JRadioButton("Monday");
					j1.setSelected(weekly[0]);
					JRadioButton j2 = new JRadioButton("Tuesday");
					j2.setSelected(weekly[1]);
					JRadioButton j3 = new JRadioButton("Wednesday");
					j3.setSelected(weekly[2]);
					JRadioButton j4 = new JRadioButton("Thursday");
					j4.setSelected(weekly[3]);
					JRadioButton j5 = new JRadioButton("Friday");
					j5.setSelected(weekly[4]);
					Object[] message = {
						j1,j2,j3,j4,j5
					};
					int option = JOptionPane.showConfirmDialog(null, message, "Set Weekly Schedule", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						if (Courses.setWeekly(id, new boolean[]{j1.isSelected(),j2.isSelected(),j3.isSelected(),j4.isSelected(),j5.isSelected()})){
							new CoursePanel();
						}
						else{
							// failed
						}
					}
				}
			});
			panel.add(btnNewButton_1);

			JButton btnNewButton_2 = new JButton("Set Components");
			btnNewButton_2.putClientProperty( "id", course.id);
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CourseComponentPanel((Integer)((JButton)e.getSource()).getClientProperty( "id" ));
				}
			});
			panel.add(btnNewButton_2);

			JButton btnNewButton_3 = new JButton("Remove");
			btnNewButton_3.putClientProperty( "id", course.id);
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (Courses.removeCourse((Integer)((JButton)e.getSource()).getClientProperty( "id" ))){
						new CoursePanel();
					}
					else{
						//failed
					}
				}
			});
			panel.add(btnNewButton_3);

			JButton btnNewButton_4 = new JButton("Edit");
			btnNewButton_4.putClientProperty( "id", course.id);
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Integer id = (Integer)((JButton)e.getSource()).getClientProperty( "id" );
					Course courseDetails = courses.getCourse(id);
					JTextField courseName = new JTextField();
					courseName.setText(courseDetails.courseName);
					JTextField courseCode = new JTextField();
					courseCode.setText(courseDetails.courseCode);
					JSpinner courseCredits = new JSpinner();
					courseCredits.setValue(courseDetails.courseCredits);
					Object[] message = {
						"Course Name:", courseName,
						"Course ID:", courseCode,
						"Course Credits:",courseCredits
					};

					int option = JOptionPane.showConfirmDialog(null, message, "Edit Course", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						if (Courses.setCourse(id, courseName.getText(), courseCode.getText(), (Integer)courseCredits.getValue())){
							new CoursePanel();
						}
						else{
							// failed
						}
					}
				}
			});
			panel.add(btnNewButton_4);
		}

		

		JButton addCourse = new JButton("Add Course");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField courseName = new JTextField();
				JTextField courseCode = new JTextField();
				JSpinner courseCredits = new JSpinner();
				Object[] message = {
					"Course Name:", courseName,
					"Course ID:", courseCode,
					"Course Credits:",courseCredits
				};

				int option = JOptionPane.showConfirmDialog(null, message, "Add Course", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					if (Courses.addCourse(courseName.getText(), courseCode.getText(), (Integer)courseCredits.getValue())){
						new CoursePanel();
					}
					else{
						// failed
					}
				}
			}
		});
		coursePanel.add(addCourse, gbc_btnNewButton);
		refresh();
	}
}

class CourseComponentPanel extends AppFrame{
	JPanel courseComponentPanel;
	Components components;

	public CourseComponentPanel(int courseCode){
		courseComponentPanel = new JPanel();
        mainFrame.setContentPane(courseComponentPanel);

		components =new Components(courseCode);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0,59, 0};
		gbl_contentPane.rowHeights = new int[]{0, 107, 0};
		gbl_contentPane.columnWeights = new double[]{0.5,1.0,1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.5,1.0, 1.0, Double.MIN_VALUE};
		courseComponentPanel.setLayout(gbl_contentPane);

		JPanel pane = new JPanel();
		GridBagConstraints gbc_pane = new GridBagConstraints();
		gbc_pane.anchor = GridBagConstraints.WEST;
		gbc_pane.insets = new Insets(0, 0, 5, 5);
		gbc_pane.fill = GridBagConstraints.VERTICAL;
		gbc_pane.gridx = 0;
		gbc_pane.gridy = 0;
		courseComponentPanel.add(pane, gbc_pane);
		pane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton1 = new JButton("Back");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CoursePanel();
		}});
		pane.add(btnNewButton1);

		Box verticalBox = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.gridx = 1;
		gbc_verticalBox.gridy = 1;
		courseComponentPanel.add(verticalBox, gbc_verticalBox);

		for (Component component:components.components){
			JPanel panel = new JPanel();
			panel.setBorder(null);
			verticalBox.add(panel);
			
			JLabel lblNewLabel = new JLabel(component.componentName);
			panel.add(lblNewLabel);

			JButton btnNewButton_3 = new JButton("Remove");
			btnNewButton_3.putClientProperty( "componentid", component.id);
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (Components.removeComponent((Integer)((JButton)e.getSource()).getClientProperty( "componentid" ))){
						new CourseComponentPanel(components.courseCode);
					}
					else{
						//failed
					}
				}
			});
			panel.add(btnNewButton_3);

			JButton btnNewButton_4 = new JButton("Edit");
			btnNewButton_4.putClientProperty( "componentid", component.id);
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Integer componentId = (Integer)((JButton)e.getSource()).getClientProperty( "componentid" );

					Component componentDetails = components.getComponent(componentId);

					JTextField componentName = new JTextField();
					componentName.setText(componentDetails.componentName);

					JDateChooser  componentDate = new JDateChooser();
					componentDate.setDate(componentDetails.componentDate);

					JTextField componentPercentage = new JTextField();
					componentPercentage.setText(String.valueOf(componentDetails.componentPercentage));

					Object[] message = {
						"Component Name:", componentName,
						"Component Date:", componentDate,
						"Component Percentage:",componentPercentage
					};

					int option = JOptionPane.showConfirmDialog(null, message, "Add Course", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						try{
							Double percentage = Double.valueOf(componentPercentage.getText());
							if (components.editComponent(componentId, componentName.getText(), componentDate.getDate(), percentage)){
								new CourseComponentPanel(components.courseCode);
							}
							else{
								// failed
							}
						}
						catch(NumberFormatException Exc){
							// failed
						}
					}
				}
			});
			panel.add(btnNewButton_4);
		}

		

		JButton addComponent = new JButton("Add Component");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		addComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField componentName = new JTextField();

				JDateChooser  componentDate = new JDateChooser();


				JTextField componentPercentage = new JTextField();
				Object[] message = {
					"Component Name:", componentName,
					"Component Date:", componentDate,
					"Component Percentage:",componentPercentage
				};

				int option = JOptionPane.showConfirmDialog(null, message, "Add Course", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					if (Components.addComponent(componentName.getText(), componentDate.getDate(), Double.parseDouble(componentPercentage.getText()))){
						new CourseComponentPanel(components.courseCode);
					}
					else{
						// failed
					}
				}
			}
		});
		courseComponentPanel.add(addComponent, gbc_btnNewButton);
		refresh();
	}
}

class CalendarPanel extends AppFrame{
	JPanel calendarPanel;

	public CalendarPanel(){
		calendarPanel = new JPanel();
        mainFrame.setContentPane(calendarPanel);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0,1,0};
		gbl_contentPane.rowHeights = new int[]{0,4, 1,0};
		gbl_contentPane.columnWeights = new double[]{0.5, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.5, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		calendarPanel.setLayout(gbl_contentPane);

		JPanel pane = new JPanel();
		GridBagConstraints gbc_pane = new GridBagConstraints();
		gbc_pane.anchor = GridBagConstraints.WEST;
		gbc_pane.insets = new Insets(0, 0, 5, 5);
		gbc_pane.fill = GridBagConstraints.VERTICAL;
		gbc_pane.gridx = 0;
		gbc_pane.gridy = 0;
		calendarPanel.add(pane, gbc_pane);
		pane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton1 = new JButton("Back");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomePanel();
		}});
		pane.add(btnNewButton1);

		// put cal panel on top
		GridBagConstraints gbc_pos = new GridBagConstraints();
		gbc_pos.fill = GridBagConstraints.HORIZONTAL;
		gbc_pos.gridx = 1;
		gbc_pos.gridy = 1;
		calendarPanel.add(new CalendarDatesPanel(false,null), gbc_pos);

		// put buttons below
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JButton but = new JButton();
		but.setText("Add Event");
		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField eventName = new JTextField();
				JComboBox<String>  eventCategory = new JComboBox<>(Constants.CATEGORIES);
				JDateChooser eventDate = new JDateChooser();
				JRadioButton remind = new JRadioButton("Reminder?");
				Object[] message = {
					"Event Name:", eventName,
					"Event Category:", eventCategory,
					"Event Date:",eventDate, 
					remind
				};

				int option = JOptionPane.showConfirmDialog(null, message, "Add Event", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					if (CalendarEvents.addEvent(eventName.getText(), String.valueOf(eventCategory.getSelectedItem()), eventDate.getDate(), remind.isSelected())){
						new CalendarPanel();
					}
					else{
						// failed
					}
				}
			}
		});
		panel.add(but);

		GridBagConstraints gbc_pos_2 = new GridBagConstraints();
		gbc_pos_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_pos_2.gridx = 1;
		gbc_pos_2.gridy = 2;
		calendarPanel.add(panel, gbc_pos_2);

		refresh();
	}
}

class AttendancePanel extends AppFrame{
	JPanel attendancePanel;
	Attendances attendances;

	public AttendancePanel(){
		attendancePanel = new JPanel();
        mainFrame.setContentPane(attendancePanel);

		attendances = new Attendances();

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0,59, 0};
		gbl_contentPane.rowHeights = new int[]{0, 107, 0};
		gbl_contentPane.columnWeights = new double[]{0.5,1.0,1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.5,1.0, 1.0, Double.MIN_VALUE};
		attendancePanel.setLayout(gbl_contentPane);

		JPanel pane = new JPanel();
		GridBagConstraints gbc_pane = new GridBagConstraints();
		gbc_pane.anchor = GridBagConstraints.WEST;
		gbc_pane.insets = new Insets(0, 0, 5, 5);
		gbc_pane.fill = GridBagConstraints.VERTICAL;
		gbc_pane.gridx = 0;
		gbc_pane.gridy = 0;
		attendancePanel.add(pane, gbc_pane);
		pane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton1 = new JButton("Back");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomePanel();
		}});
		pane.add(btnNewButton1);

		Box verticalBox = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.gridx = 1;
		gbc_verticalBox.gridy = 1;
		attendancePanel.add(verticalBox, gbc_verticalBox);

		for (Attendance attendance:attendances.attendances){
			JPanel panel = new JPanel();
			panel.setBorder(null);
			verticalBox.add(panel);
			
			JLabel lblNewLabel = new JLabel(attendance.course);
			panel.add(lblNewLabel);

			if (!attendance.hasWeekly){
				JButton btnNewButton_1 = new JButton("Set Weekly");
				btnNewButton_1.putClientProperty( "id", attendance.courseid);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Integer id = (Integer)((JButton)e.getSource()).getClientProperty( "id" );
						JRadioButton j1 = new JRadioButton("Monday");
						JRadioButton j2 = new JRadioButton("Tuesday");
						JRadioButton j3 = new JRadioButton("Wednesday");
						JRadioButton j4 = new JRadioButton("Thursday");
						JRadioButton j5 = new JRadioButton("Friday");
						Object[] message = {
							j1,j2,j3,j4,j5
						};
						int option = JOptionPane.showConfirmDialog(null, message, "Set Weekly Schedule", JOptionPane.OK_CANCEL_OPTION);
						if (option == JOptionPane.OK_OPTION) {
							if (Courses.setWeekly(id, new boolean[]{j1.isSelected(),j2.isSelected(),j3.isSelected(),j4.isSelected(),j5.isSelected()})){
								new AttendancePanel();
							}
							else{
								// failed
							}
						}
					}
				});
				panel.add(btnNewButton_1);
			}
			else{
				JButton btnNewButton_2 = new JButton("Mark Absences");
				btnNewButton_2.putClientProperty( "id", attendance.courseid);
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new MarkAttendancePanel((Integer)((JButton)e.getSource()).getClientProperty( "id" ));
					}
				});
				panel.add(btnNewButton_2);
			}
		}

		refresh();
	}
}

class MarkAttendancePanel extends AppFrame{
	JPanel markAttendancePanel;

	public MarkAttendancePanel(int courseid){
		this(courseid, null,null);
	}
	public MarkAttendancePanel(int courseid, Integer cur_year, Integer cur_month){
		markAttendancePanel = new JPanel();
        mainFrame.setContentPane(markAttendancePanel);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0,1,0};
		gbl_contentPane.rowHeights = new int[]{0,5,0};
		gbl_contentPane.columnWeights = new double[]{0.5, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.5, 1.0, 1.0, Double.MIN_VALUE};
		markAttendancePanel.setLayout(gbl_contentPane);

		JPanel pane = new JPanel();
		GridBagConstraints gbc_pane = new GridBagConstraints();
		gbc_pane.anchor = GridBagConstraints.WEST;
		gbc_pane.insets = new Insets(0, 0, 5, 5);
		gbc_pane.fill = GridBagConstraints.VERTICAL;
		gbc_pane.gridx = 0;
		gbc_pane.gridy = 0;
		markAttendancePanel.add(pane, gbc_pane);
		pane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton1 = new JButton("Back");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AttendancePanel();
		}});
		pane.add(btnNewButton1);

		// put cal panel on top
		GridBagConstraints gbc_pos = new GridBagConstraints();
		gbc_pos.fill = GridBagConstraints.HORIZONTAL;
		gbc_pos.gridx = 1;
		gbc_pos.gridy = 1;
		markAttendancePanel.add(new CalendarDatesPanel(true,courseid,cur_year,cur_month), gbc_pos);

		refresh();
	}
}