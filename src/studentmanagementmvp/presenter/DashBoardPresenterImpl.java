/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementmvp.presenter;

import java.util.List;
import studentmanagementmvp.model.DashBoardModel;
import studentmanagementmvp.model.DashBoardModelImpl;
import studentmanagementmvp.view.DashBoardViewImpl;

/**
 *
 * @author traig
 */
public class DashBoardPresenterImpl implements DashBoardPresenter{
    private DashBoardModel model;
    private DashBoardViewImpl view;
    private Runnable runnable;
    public DashBoardPresenterImpl(){}

    public DashBoardModel getModel() {
        return model;
    }

    public void setModel(DashBoardModelImpl model) {
        this.model = model;
    }

    public DashBoardViewImpl getView() {
        return view;
    }

    public void setView(DashBoardViewImpl view) {
        this.view = view;
    }
 
    public void setRun(Runnable runnable){
        this.runnable = runnable;
    }

    @Override
    public void setModel(DashBoardModel model) {
          this.model = model;
    }

    @Override
    public void setOnShow(Runnable onShow) {
        this.runnable = onShow;
    }

    @Override
    public void run() {
        view.setPresenter(this);
        view.updateViewFromModel();
        view.open();
    }

    @Override
    public void show() {
        
    }

    @Override
    public void loadUsers() {
        //this method is called from view when view's constructor is called.
        List<List<String>> listUsers = model.getStudent();
                System.out.println(listUsers.size());

        view.showUsers(listUsers);
    }
    
    
}
