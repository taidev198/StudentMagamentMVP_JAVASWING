/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import helper.ConnectDataHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author traig
 */
public class dbHelper {
    public static dbHelper instance= null;
    private dbHelper(){}
   
    public static dbHelper  getInstance(){
        if(instance ==null)
            instance = new dbHelper();
        return instance;
    }
    
    public static List<List<String>> getDB(){
        List<List<String>> ans = new ArrayList<>();
        String query = "select * from student";
         try(Statement statement = ConnectDataHelper.getInstance().connectDB().createStatement()) {
            statement.execute("use data");
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()){
                List<String> studentid = new ArrayList<>();
                studentid.add(String.valueOf((resultSet.getInt("studentid"))));
                studentid.add(resultSet.getString("firstname"));
                studentid.add(resultSet.getString("lastname"));
                studentid.add(resultSet.getString("address"));
                studentid.add(String.valueOf(resultSet.getInt("phone")));
                studentid.add(String.valueOf(resultSet.getInt("age")));
                studentid.add(String.valueOf(resultSet.getFloat("gpa")));
                ans.add(studentid);
                
            }
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        
        return ans;
        
    }
    
    public static boolean addStudent(String studentid, String firstname, String lastname, String address,
            String phone, String age, String gpa){
        String query = "insert student values(?, ? ,? ,? ,? ,? ,?)";
         try(PreparedStatement statement = ConnectDataHelper.getInstance().connectDB().prepareStatement(query)) {
            statement.execute("use data");
            statement.setInt(1, Integer.parseInt(studentid));
            statement.setString(2, firstname);
            statement.setString(3, lastname);
            statement.setString(4, address);
            statement.setInt(5, Integer.valueOf(phone));
            statement.setInt(6, Integer.valueOf(age));
            statement.setFloat(7, Float.valueOf(gpa));
            statement.executeUpdate();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
        
    }
    
    public static boolean removeStudent(int id){
         String query = "delete from student where studentid = " + id;
        try(PreparedStatement statement = ConnectDataHelper.getInstance().connectDB().prepareStatement(query)) {
            statement.execute("use data");
          statement.executeUpdate();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
