package com.oops;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\moham\\Downloads\\Screenshot 2022-12-06 212157a.png"));
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
        JButton button = new JButton("Register");
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
        // TODO FN CALL AND HANDLE HERE
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
    }
}

class HomePanel extends AppFrame{
    JPanel homePanel;
    public HomePanel(){
        homePanel = new JPanel();
        mainFrame.setContentPane(homePanel);

        JButton button = new JButton("Opt 1");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
        homePanel.add(button);
        JButton button1 = new JButton("Opt 2");
		button1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        homePanel.add(button1);
        JButton button2 = new JButton("Opt 3");
		button2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        homePanel.add(button2);

        refresh();
    }
}