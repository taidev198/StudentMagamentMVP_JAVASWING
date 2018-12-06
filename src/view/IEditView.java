/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Student;
import java.util.List;
import presenter.IEditPresenter;

/**
 *
 * @author traig
 */
public interface IEditView {
    IEditPresenter getPresenter();
    void setPresenter(IEditPresenter iEditPresenter);
    void OnShow();
    void OnClose();
    void showStudent(Student student,List<List<String>> results);
    void add();
    void update();
    void OnSuccess();
    void OnFail();
}
