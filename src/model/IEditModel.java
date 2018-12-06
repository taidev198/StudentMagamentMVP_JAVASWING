/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author traig
 */
public interface IEditModel {
    void setResults(List<List<String>> result);
    List<List<String>> getResults();
    void setStudent(Student student);
   Student getStudent();
   boolean addStudent(Student student);
   boolean addResult(int idstudent, List<List<String>> result);
   boolean updateStudent(int id, Student student);
   boolean updateResult(int oldId, int newId, List<List<String>> result);
   boolean removeStudent(int id);
   boolean removeResult(int id);
}
