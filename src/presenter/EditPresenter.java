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
import view.EditView;
import view.IEditView;

/**
 *
 * @author traig
 */
public class EditPresenter implements IEditPresenter{
   
    IEditModel iEditModel;
    IEditView iEditView;
    IDashBoardPresenter dashBoardPresenter;
    
    IDashBoardPresenter boardPresenter;
    public EditPresenter(){
        
    }
    
    @Override
    public IEditView getView() {
        return iEditView;
    }

    @Override
    public void setView(IEditView iEditView) {
        this.iEditView = iEditView;
    }

    @Override
    public IEditModel getModel() {
        return  iEditModel;
    }

    @Override
    public void setModel(IEditModel iEditModel) {
        this.iEditModel = iEditModel;
    }

    @Override
    public Student loadStudent() {
       return  this.iEditModel.getStudent();
    }

    @Override
    public void updateStudent(int id, Student student) {
        if(iEditModel.updateStudent(id, student))
            iEditView.OnSuccess();
        else iEditView.OnFail();
    }

    @Override
    public void addStudent(Student student) {
        this.iEditModel.addStudent(student);
    }

    @Override
    public void open() {
        this.iEditView.setPresenter(this);
        this.iEditView.OnShow();
       
    }
    @Override
    public void showStudent(){
         this.iEditView.showStudent(loadStudent(), loadResults());
    }

    @Override
    public void close() {
           iEditView.OnClose();
    }

    @Override
    public void receivedData(Student student,List<List<String>> results, DashBoardPresenter dashBoardPresenter) {
       
        this.iEditModel.setStudent(student);
        this.iEditModel.setResults(results);
        this.dashBoardPresenter = dashBoardPresenter;
        if(this.dashBoardPresenter == null)
            System.out.println("null");
    }

    @Override
    public void sendData(Student student,List<List<String>> results, boolean isEditable) {
        this.dashBoardPresenter.receivedData(student, results, isEditable);
        
    }

    @Override
    public List<List<String>> loadResults() {
        return this.iEditModel.getResults();
    }

    @Override
    public void updateResult(int oldId, int newId, List<List<String>> result) {
          this.iEditModel.updateResult(oldId, newId, result);
    }

    @Override
    public void addResult(int idstudent, List<List<String>> result) {
           this.iEditModel.addResult(idstudent, result);
    }
    
    
}
