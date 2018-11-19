/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementmvp.model;

import database.Student;
import java.util.List;

/**
 *
 * @author traig
 */
public interface DashBoardModel {
    List<List<String>> getStudent();
    void addStudent(Student student);
    void deleteStudent(int studentId);
    void updateStudent(Student student);
}
