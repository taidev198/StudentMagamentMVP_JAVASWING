/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.Map;

/**
 *
 * @author traig
 */
public interface IDashBoardModel {
    List<List<String>> getStudent();
    Map<Integer, List<List<String>>> getResult();
    boolean addStudent(Student student);
    boolean addResults(int idstudent, List<List<String>> results);
    boolean removeStudent(int idstudent);
    boolean removeResults(int idstudent);
    boolean updateStudent(Student student);
    boolean updateResults(int oldId, int newId, List<List<String>> results);
}
