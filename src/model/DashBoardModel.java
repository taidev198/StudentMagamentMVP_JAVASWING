/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.dbHelper;
import database.ConnectDataHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author traig
 */
public class DashBoardModel implements IDashBoardModel{
    
   

    @Override
    public List<List<String>> getStudent() {
        return dbHelper.getStudent();
    }

    @Override
    public boolean addStudent(Student student) {
        return false;
    }

    @Override
    public boolean removeStudent(int studentId) {
      return dbHelper.removeStudent(studentId);
    }

    @Override
    public boolean updateStudent(Student student) {
        return dbHelper.update(0, student);
    }

    @Override
    public Map<Integer, List<List<String>>> getResult() {
        return dbHelper.getResult();
    }

    @Override
    public boolean addResults(int idstudent, List<List<String>> results) {
        
        return dbHelper.addResults(idstudent, results);
        
    }

    @Override
    public boolean removeResults(int idstudent) {

        return dbHelper.removeResults(idstudent);
    }

    @Override
    public boolean updateResults(int oldId, int newId, List<List<String>> results) {

        return dbHelper.updateResults(oldId, newId, results);
    }
}
