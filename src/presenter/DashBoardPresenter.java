/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import model.Student;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DashBoardModel;
import model.EditModel;
import model.IEditModel;
import view.DashBoardView;
import view.EditView;
import view.IEditView;
import model.IDashBoardModel;

/**
 *
 * @author traig
 */
public class DashBoardPresenter implements IDashBoardPresenter{
    private IDashBoardModel model;
    private DashBoardView view;
    private Runnable runnable;
    private Student student;
    private int row;
    public DashBoardPresenter(){}

    public IDashBoardModel getModel() {
        return model;
    }

    public void setModel(DashBoardModel model) {
        this.model = model;
    }

    public DashBoardView getView() {
        return view;
    }

    public void setView(DashBoardView view) {
        this.view = view;
    }
 
    public void setRun(Runnable runnable){
        this.runnable = runnable;
    }

    @Override
    public void setModel(IDashBoardModel model) {
          this.model = model;
    }

    @Override
    public void setOnShow(Runnable onShow) {
        this.runnable = onShow;
    }

    @Override
    public void run() {
        view.setPresenter(this);
        view.open();
    }

    @Override
    public void loadStudents() {
        //this method is called from view when view's constructor is called.
        List<List<String>> listUsers = model.getStudent();
                System.out.println(listUsers.size());
        Map<Integer, List<List<String>>> result = model.getResult();
        view.showUsers(listUsers, result);
    }

    @Override
    public void removeStudent(int id) {
          if(this.model.removeStudent(id))
              OnSuccess();
          else OnFail();
    }

    @Override
    public void OnSuccess() {
          view.OnSuccess();
    }

    @Override
    public void OnFail() {
       view.OnFail();
    }

    @Override
    public void editStudent(Student student, List<List<String>> results , int row) {
          //call to editview
          IEditModel iEditModel = new EditModel();
        IEditPresenter iEditPresenter = new EditPresenter();
        iEditPresenter.setModel(iEditModel);
        IEditView editView = new EditView(true);
        iEditPresenter.setView(editView);
        this.row = row;
         iEditPresenter.receivedData(student,results, this);
        iEditPresenter.open();
         iEditPresenter.showStudent();
    }

    @Override
    public void receivedData(Student student,List<List<String>> results, boolean isEditable) {
        //received Data from editview
            this.student = student;
            if(!isEditable)
            view.addRow(student, results);
            
            else{
                view.updateStudent(student, row);
                view.updateResult(results, row);
            }
            
    }

    @Override
    public void addStudent() {
            //call to editview
          IEditModel iEditModel = new EditModel();
        IEditPresenter iEditPresenter = new EditPresenter();
        iEditPresenter.setModel(iEditModel);
        IEditView editView = new EditView(false);
        iEditPresenter.setView(editView);
         iEditPresenter.receivedData(null, null, this);
        iEditPresenter.open();
    }

    @Override
    public void removeResults(int id) {
        this.model.removeResults(id);
        this.model.removeResults(id);
    }

}
