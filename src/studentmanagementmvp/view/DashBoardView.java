/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementmvp.view;

import java.util.List;
import studentmanagementmvp.presenter.DashBoardPresenter;

/**
 *
 * @author traig
 */
public interface DashBoardView {
    DashBoardPresenter getPresenter();
    void setPresenter(DashBoardPresenter presenter);
    void updateModelFromView();
    void updateViewFromModel();
    void showUsers(List<List<String>> Users);
    void open();
    void close();
    
}
