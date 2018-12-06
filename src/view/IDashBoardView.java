/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Student;
import java.util.List;
import java.util.Map;
import presenter.IDashBoardPresenter;

/**
 *
 * @author traig
 */
public interface IDashBoardView {
    IDashBoardPresenter getPresenter();
    void setPresenter(IDashBoardPresenter presenter);
    void updateStudent(Student student, int row);
    void updateResult(List<List<String>> results, int row);
    void showUsers(List<List<String>> Users, Map<Integer, List<List<String>>> results);
     void OnSuccess();
    void OnFail();
    void open();
    void close();
    
}
