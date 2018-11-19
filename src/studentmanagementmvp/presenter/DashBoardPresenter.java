/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementmvp.presenter;

import studentmanagementmvp.model.DashBoardModel;
import studentmanagementmvp.view.DashBoardViewImpl;

/**
 *
 * @author traig
 */
public interface DashBoardPresenter {
    
    DashBoardModel getModel();
    void setModel(DashBoardModel model);
    DashBoardViewImpl getView();
    void setView(DashBoardViewImpl view);
    void setOnShow(Runnable onShow);
    void loadUsers();
    void run();
    void show();
}
