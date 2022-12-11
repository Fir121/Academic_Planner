package com.oops;

import java.io.*;
import java.security.MessageDigest;

public class Registration {
    public static boolean register(String email, String password){
        // TODO EMAIL CHECK
        if (email.equals("") || password.equals("")){
            return false;
        }
        try {
            FileWriter  fobj = new FileWriter("email.locked", false);
            fobj.write(email);
            fobj.close();
        } 
        catch (Exception e) {
            return false;
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
      
            FileWriter fileWriter = new FileWriter("credentials.locked");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (byte b : hash) {
              bufferedWriter.write(String.format("%02x", b));
            }
            bufferedWriter.close();
            fileWriter.close();
          } 
          catch (Exception e) {
            return false;
          }

          return true;
    }
    public static boolean login(String password){
        if (password.equals("")){
            return false;
        }
        
        String passwordHash = "";
        try {
            FileReader fileReader = new FileReader("credentials.locked");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            passwordHash = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
        } 
        catch (Exception e) {
            return false;
        }

        String inpPasswordHash = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] inputHash = md.digest(password.getBytes());

            for (byte b : inputHash) {
                inpPasswordHash += String.format("%02x", b);
            }
            return inpPasswordHash.equals(passwordHash);
        } 
        catch (Exception e) {
            return false;
        }
    }
    public static boolean userHasRegistered(){
        File file = new File("credentials.locked");

        if (file.exists()) {
            return true;
        } 
        return false;
    }
}
