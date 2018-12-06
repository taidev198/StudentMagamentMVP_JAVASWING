/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementmvp;

import database.ConnectDataHelper;
import model.DashBoardModel;
import presenter.DashBoardPresenter;
import view.DashBoardView;
import presenter.IDashBoardPresenter;
import model.IDashBoardModel;

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
                IDashBoardModel dashBoardModel = new DashBoardModel();
               IDashBoardPresenter    boardPresenter = new DashBoardPresenter();
               boardPresenter.setModel(dashBoardModel);
               DashBoardView dashBoardView = new DashBoardView();
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
