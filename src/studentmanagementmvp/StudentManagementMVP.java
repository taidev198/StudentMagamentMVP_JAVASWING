/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementmvp;

import helper.ConnectDataHelper;
import studentmanagementmvp.model.DashBoardModel;
import studentmanagementmvp.model.DashBoardModelImpl;
import studentmanagementmvp.presenter.DashBoardPresenter;
import studentmanagementmvp.presenter.DashBoardPresenterImpl;
import studentmanagementmvp.view.DashBoardViewImpl;

/**
 *
 * @author traig
 */
public class StudentManagementMVP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       java.awt.EventQueue.invokeLater(new Runnable() {
           @Override
           public void run() {
                DashBoardModel dashBoardModel = new DashBoardModelImpl();
               DashBoardPresenter    boardPresenter = new DashBoardPresenterImpl();
               boardPresenter.setModel(dashBoardModel);
               DashBoardViewImpl dashBoardView = new DashBoardViewImpl();
               boardPresenter.setView(dashBoardView);
               boardPresenter.setOnShow(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("nguyen thanh tai");
                    }
                });
               boardPresenter.run();
               
           }
           });
       
       
    }
    
}
