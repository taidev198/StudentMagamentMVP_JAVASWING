/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.dbHelper;
import database.ConnectDataHelper;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author traig
 */
public class EditModel implements IEditModel{
    Student student;
    List<List<String>> results;
    @Override
    public void setStudent(Student student) {
        this.student = student;

    }
    
    

    @Override
    public Student getStudent() {
        
        return this.student;
    }

    @Override
    public boolean addStudent(Student student) {
        System.out.println("add");
         addStudents(student.getStudentid(), student.getFullname(), student.getGender(), student.getBirth(),
                student.getAddress(),student.getClassName());

         return false;
    }

    @Override
    public boolean updateStudent(int id, Student student) {
        dbHelper.update(id, student);
        return true;

    }

    @Override
    public boolean removeStudent(int id) {
        dbHelper.removeStudent(id);
        return false;
    }
    public boolean addStudents(int studentid, String fullname, String gender, String birth,
            String address, String className){
     dbHelper.addStudent(studentid, fullname, gender, birth, address, className);
        return true;
    }

    @Override
    public void setResults(List<List<String>> results) {
        this.results = results;
    }
    @Override
    public List<List<String>> getResults() {
        return this.results;
    }

    @Override
    public boolean addResult(int idstudent, List<List<String>> result) {

        return dbHelper.addResults(idstudent, result);
    }

    @Override
    public boolean updateResult(int oldId, int newId, List<List<String>> result) {
          return dbHelper.updateResults(oldId, newId, results);
    }

    @Override
    public boolean removeResult(int id) {
        return dbHelper.removeResults(id);
    }
    
}
