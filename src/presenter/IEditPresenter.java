/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import model.Student;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.IEditModel;
import view.IEditView;

/**
 *
 * @author traig
 */
public interface IEditPresenter {
    IEditView getView();
    void setView(IEditView iEditView);
    void receivedData(Student student,List<List<String>> results , DashBoardPresenter dashBoardPresenter);
    void sendData(Student student,List<List<String>> results, boolean isEditable);
    IEditModel getModel();
    void setModel(IEditModel iEditModel);
    void showStudent();
    Student loadStudent();
    List<List<String>> loadResults();
    void updateStudent(int id, Student student);
    void updateResult(int oldId, int newId, List<List<String>> result);
    void addStudent(Student student);
    void addResult(int idstudent, List<List<String>> result);
    void open();
    void close();
}
