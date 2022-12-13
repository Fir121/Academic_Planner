package com.oops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
    // by being static this ensure there will only be one connection open at a time
    private static Connection connection = null;

    static{
        initiateConnection();
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS 'Courses' ('id' INTEGER NOT NULL, 'name' TEXT, 'code' TEXT, 'credits' INTEGER CHECK(credits >= 0), 'grade' TEXT NOT NULL DEFAULT 'Unknown', PRIMARY KEY('id' AUTOINCREMENT))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS 'Components'('courseid' INTEGER NOT NULL, 'id' INTEGER NOT NULL, 'name' TEXT, 'date' TEXT, 'percentage' NUMERIC CHECK(percentage >= 0), 'marks' NUMERIC CHECK(percentage >= 0), PRIMARY KEY('id' AUTOINCREMENT), FOREIGN KEY('courseid') REFERENCES Courses('id'))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS 'Weekly'('courseid' INTEGER NOT NULL, 'monday' INTEGER DEFAULT 0, 'tuesday' INTEGER DEFAULT 0, 'wednesday' INTEGER DEFAULT 0, 'thursday' INTEGER DEFAULT 0, 'friday' INTEGER DEFAULT 0, PRIMARY KEY('courseid'), FOREIGN KEY('courseid') REFERENCES 'Courses'('id'))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS 'Absences'('courseid' INTEGER NOT NULL, 'date' TEXT, FOREIGN KEY('courseid') REFERENCES Courses('id'), UNIQUE('courseid','date'))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS 'SpecialClasses'('courseid' INTEGER NOT NULL, 'date' TEXT, 'active' INTEGER, FOREIGN KEY('courseid') REFERENCES Courses('id'), UNIQUE('courseid','date'))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS 'Events'('id' INTEGER NOT NULL, 'name' TEXT, 'category' TEXT, 'date' TEXT, 'reminder' INTEGER, PRIMARY KEY('id' AUTOINCREMENT))");
        }
        catch (SQLException e){
            System.out.println(e);
            PopupFrame.showErrorMessage("Could not create tables");
        }
        finally{
            closeConn();
        }
    }

    public SQL() {
        initiateConnection();   
    }

    public static void initiateConnection(){
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        }
        catch(SQLException e){
            System.out.println(e);
            PopupFrame.showErrorMessage("Could not establish connection to Database");
        }
    }

    public static void closeConn(){
        try{
            connection.close();
        }
        catch(SQLException e){}
        catch(Exception e){}
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
            connection.close();
            return true;
        }
        catch (SQLException e){
            System.out.println(e);
            PopupFrame.showErrorMessage("Could not change data");
            return false;
        }
    }
}
