package com.oops;

import javax.swing.JOptionPane;

public class PopupFrame extends AppFrame {
    public static void showErrorMessage(){
        showErrorMessage("An error occurred while processing your request.\nPlease check your input or restart the app.");
    }
    public static void showErrorMessage(String s){
        JOptionPane.showMessageDialog(mainFrame, s, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
