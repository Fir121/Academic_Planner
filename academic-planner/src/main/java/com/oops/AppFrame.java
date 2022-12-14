package com.oops;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import jiconfont.IconCode;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.Date;

public class AppFrame{
    static JFrame mainFrame;
    static{
		try { 
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			for (String type: new String[]{"Label","Button","RadioButton","Panel","OptionPane","ComboBox","TextArea","Spinner","TextField"}){
				UIManager.put(type+".font", new Font("SANS_SERIF", Font.PLAIN, 15));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		IconFontSwing.register(FontAwesome.getIconFont());
		
        mainFrame = new JFrame("Academic Planner");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(100, 100, 1200, 800);

    }
    public void refresh(){
        mainFrame.setVisible(true);
    }
	public static void setIcon(JButton but, IconCode ff, Boolean single){
		but.setIcon(IconFontSwing.buildIcon(ff, 20));
		if (single){
			but.setBorderPainted(false); 
			but.setContentAreaFilled(false); 
			but.setFocusPainted(false); 
			but.setOpaque(false);
		}
	}
	public static void setIcon(JButton but, IconCode ff){
		setIcon(but, ff, true);
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
    }
}
class RegisterPanel extends LogoPanel{
    public RegisterPanel(){
        JButton button = new JButton("Register Now");
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
		setIcon(backButton, FontAwesome.ANGLE_DOUBLE_LEFT, false);
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
		setIcon(backButton, FontAwesome.ANGLE_DOUBLE_LEFT, false);
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
		setIcon(button, FontAwesome.LEANPUB, false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CoursePanel();
			}
		});
        panel.add(button);

		JPanel panel1 = new JPanel();
		verticalBox.add(panel1);
        JButton button1 = new JButton("Calendar");
		setIcon(button1, FontAwesome.CALENDAR, false);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CalendarPanel();
			}
		});
        panel1.add(button1);

		JPanel panel2 = new JPanel();
		verticalBox.add(panel2);
        JButton button2 = new JButton("Attendance");
		setIcon(button2, FontAwesome.LINE_CHART, false);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AttendancePanel();
			}
		});
        panel2.add(button2);

		JPanel panel3 = new JPanel();
		verticalBox.add(panel3);
        JButton button3 = new JButton("Settings");
		setIcon(button3, FontAwesome.ASTERISK, false);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SettingsPanel();
			}
		});
        panel3.add(button3);

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
		setIcon(btnNewButton1, FontAwesome.ANGLE_DOUBLE_LEFT, false);
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

		for (Course course:courses.getArrayListCourses()){
			JPanel panel = new JPanel();
			panel.setBorder(null);
			verticalBox.add(panel);
			
			JLabel lblNewLabel = new JLabel(course.toString());
			panel.add(lblNewLabel);

			JButton btnNewButton_2 = new JButton();
			setIcon(btnNewButton_2, FontAwesome.LIST);
			btnNewButton_2.setToolTipText("Set Course Components");
			btnNewButton_2.putClientProperty( "id", course.getId());
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CourseComponentPanel((Integer)((JButton)e.getSource()).getClientProperty( "id" ));
				}
			});
			panel.add(btnNewButton_2);

			JButton btnNewButton_1 = new JButton();
			setIcon(btnNewButton_1, FontAwesome.CALENDAR_O);
			btnNewButton_1.setToolTipText("Set Weekly TimeTable");
			btnNewButton_1.putClientProperty( "id", course.getId());
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Integer id = (Integer)((JButton)e.getSource()).getClientProperty( "id" );
					boolean[] weekly = Courses.getWeekly(id);
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
					int option = JOptionPane.showConfirmDialog(mainFrame, message, "Set Weekly Schedule", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						if (Courses.setWeekly(id, new boolean[]{j1.isSelected(),j2.isSelected(),j3.isSelected(),j4.isSelected(),j5.isSelected()})){
							new CoursePanel();
						}
					}
				}
			});
			panel.add(btnNewButton_1);

			JButton btnNewButton_4 = new JButton();
			setIcon(btnNewButton_4, FontAwesome.PENCIL);
			btnNewButton_4.setToolTipText("Edit Course Details");
			btnNewButton_4.putClientProperty( "id", course.getId());
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Integer id = (Integer)((JButton)e.getSource()).getClientProperty( "id" );
					Course courseDetails = courses.getCourse(id);
					JTextField courseName = new JTextField();
					courseName.setText(courseDetails.getCourseName());
					JTextField courseCode = new JTextField();
					courseCode.setText(courseDetails.getCourseCode());
					JSpinner courseCredits = new JSpinner();
					courseCredits.setValue(courseDetails.getCourseCredits());
					Object[] message = {
						"Course Name:", courseName,
						"Course ID:", courseCode,
						"Course Credits:",courseCredits
					};

					int option = JOptionPane.showConfirmDialog(mainFrame, message, "Edit Course", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						if (Courses.setCourse(id, courseName.getText(), courseCode.getText(), (Integer)courseCredits.getValue())){
							new CoursePanel();
						}
					}
				}
			});
			panel.add(btnNewButton_4);

			JButton btnNewButton_3 = new JButton();
			setIcon(btnNewButton_3, FontAwesome.TRASH);
			btnNewButton_3.setToolTipText("Delete Course");
			btnNewButton_3.putClientProperty( "id", course.getId());
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (Courses.removeCourse((Integer)((JButton)e.getSource()).getClientProperty( "id" ))){
						new CoursePanel();
					}
				}
			});
			panel.add(btnNewButton_3);
		}

		JButton addCourse = new JButton("Add Course");
		setIcon(addCourse, FontAwesome.PLUS, false);
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

				int option = JOptionPane.showConfirmDialog(mainFrame, message, "Add Course", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					if (Courses.addCourse(courseName.getText(), courseCode.getText(), (Integer)courseCredits.getValue())){
						new CoursePanel();
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

	public CourseComponentPanel(int courseId){
		courseComponentPanel = new JPanel();
        mainFrame.setContentPane(courseComponentPanel);

		components = new Components(courseId);
		Course course = new Courses().getCourse(courseId);

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
		setIcon(btnNewButton1, FontAwesome.ANGLE_DOUBLE_LEFT, false);
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CoursePanel();
		}});
		pane.add(btnNewButton1);
		
		JPanel upperPanel = new JPanel();
		GridBagConstraints gbc_verticalBox_0 = new GridBagConstraints();
		gbc_verticalBox_0.gridx = 1;
		gbc_verticalBox_0.gridy = 0;
		courseComponentPanel.add(upperPanel, gbc_verticalBox_0);

		final Box verticalBox_0 = Box.createVerticalBox();
		JLabel gradelbl = new JLabel("Enter your grade");
		final JComboBox<String> grade = new JComboBox<>(Constants.GRADES);
		grade.setSelectedItem(course.grade);
		grade.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (Courses.setGrade(components.getCourseId(), String.valueOf(grade.getSelectedItem()))){
					verticalBox_0.remove(grade);
					new CourseComponentPanel(components.getCourseId());
				}
			}
		});
		verticalBox_0.add(gradelbl);
		verticalBox_0.add(grade);

		Box verticalBox_1 = Box.createVerticalBox();
		JLabel gradepred = new JLabel("Predicted Grade");
		JLabel predres = new JLabel("predres");
		predres.setText(Calculator.getPredicted(courseId));
		verticalBox_1.add(gradepred);
		verticalBox_1.add(predres);

		upperPanel.add(verticalBox_0);
		upperPanel.add(new JSeparator(SwingConstants.VERTICAL));
		upperPanel.add(verticalBox_1);

		Box verticalBox = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.gridx = 1;
		gbc_verticalBox.gridy = 1;
		courseComponentPanel.add(verticalBox, gbc_verticalBox);

		for (Component component:components.getArrayListComponents()){
			JPanel panel = new JPanel();
			panel.setBorder(null);
			verticalBox.add(panel);
			
			JLabel lblNewLabel = new JLabel(component.getComponentName()+" : "+component.getComponentPercentage()+"%");
			panel.add(lblNewLabel);

			JButton btnNewButton_4 = new JButton();
			setIcon(btnNewButton_4, FontAwesome.PENCIL);
			btnNewButton_4.setToolTipText("Edit Component Details");
			btnNewButton_4.putClientProperty( "componentid", component.getId());
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Integer componentId = (Integer)((JButton)e.getSource()).getClientProperty( "componentid" );

					Component componentDetails = components.getComponent(componentId);

					JTextField componentName = new JTextField();
					componentName.setText(componentDetails.getComponentName());

					JDateChooser  componentDate = new JDateChooser();
					componentDate.setMinSelectableDate(Constants.START);
					componentDate.setMaxSelectableDate(Constants.END);
					componentDate.setDate(componentDetails.getComponentDate());

					JTextField componentPercentage = new JTextField();
					componentPercentage.setText(String.valueOf(componentDetails.getComponentPercentage()));

					Object[] message = {
						"Component Name:", componentName,
						"Component Date:", componentDate,
						"Component Percentage:",componentPercentage
					};

					int option = JOptionPane.showConfirmDialog(mainFrame, message, "Add Course", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						try{
							Double percentage = Double.valueOf(componentPercentage.getText());
							if (Components.editComponent(components.getCourseId(), componentId, componentName.getText(), componentDate.getDate(), percentage)){
								new CourseComponentPanel(components.getCourseId());
							}
						}
						catch(NumberFormatException Exc){
							PopupFrame.showErrorMessage("Invalid Number input");
						}
					}
				}
			});
			panel.add(btnNewButton_4);

			JButton btnNewButton_3 = new JButton();
			setIcon(btnNewButton_3, FontAwesome.TRASH);
			btnNewButton_3.setToolTipText("Delete Component");
			btnNewButton_3.putClientProperty( "componentid", component.getId());
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (Components.removeComponent((Integer)((JButton)e.getSource()).getClientProperty( "componentid" ))){
						new CourseComponentPanel(components.getCourseId());
					}
				}
			});
			panel.add(btnNewButton_3);

			if(component.getComponentDate().compareTo(new Date()) <= 0){
				JButton btnNewButton_5 = new JButton("Marks");
				btnNewButton_5.putClientProperty( "componentid", component.getId());
				btnNewButton_5.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Integer componentId = (Integer)((JButton)e.getSource()).getClientProperty( "componentid" );

						Component componentDetails = components.getComponent(componentId);

						JTextField componentMarks = new JTextField();
						componentMarks.setText((componentDetails.getComponentMarks() == null)?"":String.valueOf(componentDetails.getComponentMarks()));

						Object[] message = {
							"Marks", componentMarks
						};

						int option = JOptionPane.showConfirmDialog(mainFrame, message, "Set Marks", JOptionPane.OK_CANCEL_OPTION);
						if (option == JOptionPane.OK_OPTION) {
							try{
								Double marks = Double.valueOf(componentMarks.getText());
								if (Components.setMarks(components.getCourseId(), componentId, marks)){
									new CourseComponentPanel(components.getCourseId());
								}
							}
							catch(NumberFormatException Exc){
								PopupFrame.showErrorMessage("Invalid Number input");
							}
						}
					}
				});
				panel.add(btnNewButton_5);
			}
		}

		
		JPanel lowerPanel = new JPanel();
		JButton calcGrade = new JButton("Grade Calculator");
		setIcon(calcGrade, FontAwesome.CALCULATOR, false);
		calcGrade.setToolTipText("Use This Calculator to get a rough estimate of your grade, if you only know your class mark details.");
		calcGrade.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				final JTextField average = new JTextField();
				final JTextField marks = new JTextField();
				final JLabel result = new JLabel();
				JButton calculate = new JButton("Generate Grade");
				calculate.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						try{
							Double avg = Double.parseDouble(average.getText());
							Double mrks = Double.parseDouble(marks.getText());
							result.setText(Calculator.calculateRange(avg, mrks));
						}
						catch(NumberFormatException Exc){
							PopupFrame.showErrorMessage("Invalid Number input");
						}
					}
				});

				Object[] message = {
					"Enter current class average: ", average,
					"Enter your marks: ",marks,					
					result,calculate
				};

				JOptionPane.showConfirmDialog(mainFrame, message, "Calculate Grade", JOptionPane.CANCEL_OPTION);
			}
		});
		lowerPanel.add(calcGrade);
		JButton addComponent = new JButton("Add Component");
		setIcon(addComponent, FontAwesome.PLUS, false);
		lowerPanel.add(addComponent);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		addComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField componentName = new JTextField();

				JDateChooser  componentDate = new JDateChooser();
				componentDate.setMinSelectableDate(Constants.START);
				componentDate.setMaxSelectableDate(Constants.END);

				JTextField componentPercentage = new JTextField();
				Object[] message = {
					"Component Name:", componentName,
					"Component Date:", componentDate,
					"Component Percentage:",componentPercentage
				};

				int option = JOptionPane.showConfirmDialog(mainFrame, message, "Add Component", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					if (Components.addComponent(components.getCourseId(), componentName.getText(), componentDate.getDate(), Double.parseDouble(componentPercentage.getText()))){
						new CourseComponentPanel(components.getCourseId());
					}
				}
			}
		});
		courseComponentPanel.add(lowerPanel, gbc_btnNewButton);
		refresh();
	}
}

class CalendarPanel extends AppFrame{
	JPanel calendarPanel;

	public CalendarPanel(){
		this(null,null);
	}
	public CalendarPanel(Integer year, Integer month){
		
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
		setIcon(btnNewButton1, FontAwesome.ANGLE_DOUBLE_LEFT, false);
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
		calendarPanel.add(new CalendarDatesPanel(mainFrame, false,null,year, month), gbc_pos);

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
		setIcon(btnNewButton1, FontAwesome.ANGLE_DOUBLE_LEFT, false);
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

		for (Attendance attendance:attendances.getArrayListAttendances()){
			JPanel panel = new JPanel();
			panel.setBorder(null);
			verticalBox.add(panel);
			
			JLabel lblNewLabel = new JLabel(attendance.getCourse());
			panel.add(lblNewLabel);

			if (!attendance.isHasWeekly()){
				JButton btnNewButton_1 = new JButton("Set Weekly");
				setIcon(btnNewButton_1, FontAwesome.CALENDAR_O, false);
				btnNewButton_1.setToolTipText("You need to set a weekly schedule before you can mark attendance");
				btnNewButton_1.putClientProperty( "id", attendance.getCourseid());
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
						int option = JOptionPane.showConfirmDialog(mainFrame, message, "Set Weekly Schedule", JOptionPane.OK_CANCEL_OPTION);
						if (option == JOptionPane.OK_OPTION) {
							if (Courses.setWeekly(id, new boolean[]{j1.isSelected(),j2.isSelected(),j3.isSelected(),j4.isSelected(),j5.isSelected()})){
								new AttendancePanel();
							}
						}
					}
				});
				panel.add(btnNewButton_1);
			}
			else{
				JButton btnNewButton_2 = new JButton("Mark Absences");
				setIcon(btnNewButton_2, FontAwesome.CHECK_CIRCLE, false);
				btnNewButton_2.setToolTipText("Completed classes are marked as present by default");
				btnNewButton_2.putClientProperty( "id", attendance.getCourseid());
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
		setIcon(btnNewButton1, FontAwesome.ANGLE_DOUBLE_LEFT, false);
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AttendancePanel();
		}});
		pane.add(btnNewButton1);

		GridBagConstraints gbc_pos = new GridBagConstraints();
		gbc_pos.fill = GridBagConstraints.HORIZONTAL;
		gbc_pos.gridx = 1;
		gbc_pos.gridy = 1;
		markAttendancePanel.add(new CalendarDatesPanel(mainFrame,true,courseid,cur_year,cur_month), gbc_pos);

		refresh();
	}
}

class SettingsPanel extends AppFrame{
	JPanel settingsPanel;

	public SettingsPanel(){
		settingsPanel = new JPanel();
		mainFrame.setContentPane(settingsPanel);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0,1,0};
		gbl_contentPane.rowHeights = new int[]{0,5,0};
		gbl_contentPane.columnWeights = new double[]{0.5, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.5, 1.0, 1.0, Double.MIN_VALUE};
		settingsPanel.setLayout(gbl_contentPane);

		JPanel pane = new JPanel();
		GridBagConstraints gbc_pane = new GridBagConstraints();
		gbc_pane.anchor = GridBagConstraints.WEST;
		gbc_pane.insets = new Insets(0, 0, 5, 5);
		gbc_pane.fill = GridBagConstraints.VERTICAL;
		gbc_pane.gridx = 0;
		gbc_pane.gridy = 0;
		settingsPanel.add(pane, gbc_pane);
		pane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton1 = new JButton("Back");
		setIcon(btnNewButton1, FontAwesome.ANGLE_DOUBLE_LEFT, false);
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomePanel();
		}});
		pane.add(btnNewButton1);


		Box mainSettings = Box.createVerticalBox();
		GridBagConstraints gbc_pos = new GridBagConstraints();
		gbc_pos.fill = GridBagConstraints.HORIZONTAL;
		gbc_pos.gridx = 1;
		gbc_pos.gridy = 1;
		settingsPanel.add(mainSettings, gbc_pos);

		JPanel h1 = new JPanel();
		JLabel lbl = new JLabel("Start Of Semester: ");
		final JDateChooser startDate = new JDateChooser();
		startDate.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e){
				if ("date".equals(e.getPropertyName())) {
					if (!Constants.setStartDate((Date) e.getNewValue())){
						startDate.setDate(Constants.START);
						PopupFrame.showErrorMessage("Something went wrong");
					}
				}
			}
		});
		startDate.setDate(Constants.START);
		h1.add(lbl);
		h1.add(startDate);
		mainSettings.add(h1);

		JPanel h2 = new JPanel();
		JLabel lbl1 = new JLabel("End Of Semester: ");
		final JDateChooser endDate = new JDateChooser();
		endDate.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e){
				if ("date".equals(e.getPropertyName())) {
					if (!Constants.setEndDate((Date) e.getNewValue())){
						endDate.setDate(Constants.END);
						PopupFrame.showErrorMessage("Something went wrong");
					}
				}
			}
		});
		endDate.setDate(Constants.END);
		h2.add(lbl1);
		h2.add(endDate);
		mainSettings.add(h2);

		Box hb = Box.createHorizontalBox();
		JButton logout = new JButton("Reset App");
		logout.setToolTipText("Clears all saved app data");
		logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				File myObj = new File("database.db"); 
				File myObj2 = new File("credentials.locked");
				File myObj3 = new File("email.locked");
				File myObj4 = new File("startdate.txt");
				File myObj5 = new File("enddate.txt");
				if ((!myObj.exists() || myObj.delete()) && (!myObj2.exists() || myObj2.delete()) && (!myObj3.exists() || myObj3.delete()) && (!myObj4.exists() || myObj4.delete()) && (!myObj5.exists() || myObj5.delete())) { 
					mainFrame.dispose();
				} 
				else {
					PopupFrame.showErrorMessage("Couldn't delete file(s)");
				} 
			}
		});
		
		JButton clear = new JButton("New Semester");
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				File myObj = new File("database.db"); 
				File myObj2 = new File("startdate.txt");
				File myObj3 = new File("enddate.txt");
				if ((!myObj.exists() || myObj.delete()) && (!myObj2.exists() || myObj2.delete()) && (!myObj3.exists() || myObj3.delete())) { 
					mainFrame.dispose();
				} 
				else {
					PopupFrame.showErrorMessage("Couldn't delete file(s)");
				} 
			}
		});

		hb.add(logout);
		hb.add(clear);

		mainSettings.add(new JLabel(" "));
		mainSettings.add(hb);

		refresh();
	}
}