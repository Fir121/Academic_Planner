package com.oops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
    public Connection connection = null;

    static{
        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS 'Courses' ('id' INTEGER NOT NULL, 'name' TEXT, 'code' TEXT, 'credits' INTEGER, PRIMARY KEY('id' AUTOINCREMENT))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS 'Components'('courseid' INTEGER NOT NULL, 'id' INTEGER NOT NULL, 'name' TEXT, 'date' TEXT, 'percentage' NUMERIC, PRIMARY KEY('id' AUTOINCREMENT), FOREIGN KEY('courseid') REFERENCES Courses('id'))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS 'Weekly'('courseid' INTEGER NOT NULL, 'monday' INTEGER DEFAULT 0, 'tuesday' INTEGER DEFAULT 0, 'wednesday' INTEGER DEFAULT 0, 'thursday' INTEGER DEFAULT 0, 'friday' INTEGER DEFAULT 0, PRIMARY KEY('courseid'), FOREIGN KEY('courseid') REFERENCES 'Courses'('id'))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS 'Absences'('courseid' INTEGER NOT NULL, 'date' TEXT, PRIMARY KEY('courseid'), FOREIGN KEY('courseid') REFERENCES Courses('id'))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS 'Events'('id' INTEGER NOT NULL, 'name' TEXT, 'category' TEXT, 'date' TEXT, 'reminder' INTEGER, PRIMARY KEY('id' AUTOINCREMENT))");
        }
        catch (SQLException e){
            System.out.println(e);
            PopupFrame.showErrorMessage("Could not create tables");
        }
    }

    public SQL() {
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        }
        catch(SQLException e){
            System.out.println(e);
            PopupFrame.showErrorMessage("Could not establish connection to Database");
        }
    }

    public ResultSet selectData(String q){
        try {
            Statement stmt  = connection.createStatement();
            ResultSet rs    = stmt.executeQuery(q);
            
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
            PopupFrame.showErrorMessage("Could not retrieve data");
            return null;
        }
    }

    public boolean changeData(String q,  Object... values){
        try{
            PreparedStatement pstmt = connection.prepareStatement(q);
            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]);
            }
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){
            System.out.println(e);
            PopupFrame.showErrorMessage("Could not change data");
            return false;
        }
    }
}
