/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import model.Student;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import view.DashBoardView;
import model.IDashBoardModel;

/**
 *
 * @author traig
 */
public interface IDashBoardPresenter {
    
    IDashBoardModel getModel();
    void setModel(IDashBoardModel model);
    DashBoardView getView();
    void editStudent(Student student, List<List<String>> results , int row);
    void receivedData(Student student,List<List<String>> results, boolean isEditable);
    void addStudent();
    void setView(DashBoardView view);
    void setOnShow(Runnable onShow);
    void OnSuccess();
    void OnFail();
    void removeStudent(int id);
    void removeResults(int id);
    void loadStudents();
    void run();
}
