/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementmvp.model;

import database.Student;
import database.dbHelper;
import helper.ConnectDataHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author traig
 */
public class DashBoardModelImpl implements DashBoardModel{
    
   

    @Override
    public List<List<String>> getStudent() {
        return dbHelper.getDB();
    }

    @Override
    public void addStudent(Student student) {
    }

    @Override
    public void deleteStudent(int studentId) {
    }

    @Override
    public void updateStudent(Student student) {
    }
}
