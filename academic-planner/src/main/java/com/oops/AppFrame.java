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

class LoginFormPanel extends AppFrame{
    JPanel loginFormPanel;
    public LoginFormPanel(){
        loginFormPanel = new JPanel();
        mainFrame.setContentPane(loginFormPanel);

        refresh();
    }
}
class RegisterFormPanel extends AppFrame{
    JPanel registerFormPanel;
    public RegisterFormPanel(){
        registerFormPanel = new JPanel();
        mainFrame.setContentPane(registerFormPanel);

        refresh();
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