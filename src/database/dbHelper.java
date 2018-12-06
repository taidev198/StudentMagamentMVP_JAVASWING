/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import model.Student;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author traig
 */
public class dbHelper {
    public static dbHelper instance= null;
    private dbHelper(){
    
    }
   
    public static dbHelper  getInstance(){
        if(instance ==null)
            instance = new dbHelper();
        return instance;
    }
    
    public static boolean update(int id, Student student){

        String query = "update student SET idstudent = ?, fullname = ?, gender = ?, birth = ?,address= ?, class = ? "
                + "where idstudent = ?";
        try(PreparedStatement statement = ConnectDataHelper.getInstance().connectDB().prepareStatement(query)) {
            statement.execute("use data");
             statement.setInt(1, (student.getStudentid()));
            statement.setString(2, student.getFullname());
            statement.setString(3, student.getGender());
            statement.setString(4, student.getBirth());
            statement.setString(5, student.getAddress());
            statement.setString(6, student.getClassName());
             statement.setInt(7, id);
            statement.executeUpdate();
            System.out.println("updated");
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
     public static boolean updateResults(int oldId, int newId, List<List<String>> results){

        String query = "update result SET idstudent = ?, idsubject = ?, point = ? "
                + "where idstudent = ? and idsubject =?";
        try(PreparedStatement statement = ConnectDataHelper.getInstance().connectDB().prepareStatement(query)) {
            statement.execute("use data");
             statement.setInt(1, newId);
             for(int i=1;i <7; i++){
                  statement.setInt(2, i);
                  statement.setFloat(3, Float.valueOf(results.get(1).get(i-1)));
                  statement.setInt(4, oldId);
                  statement.setInt(5, i);
                statement.executeUpdate();
                 System.out.println("updating result");
             }
            
            System.out.println("updated");
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static List<List<String>> getStudent(){
        List<List<String>> ans = new ArrayList<>();
        String query = "select * from student";
         try(Statement statement = ConnectDataHelper.getInstance().connectDB().createStatement()) {
            statement.execute("use data");
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()){
                List<String> studentInfor = new ArrayList<>();
                studentInfor.add(String.valueOf((resultSet.getInt("idstudent"))));
                studentInfor.add(resultSet.getString("fullname"));
                studentInfor.add(resultSet.getString("gender"));
                studentInfor.add(resultSet.getString("birth"));
                studentInfor.add((resultSet.getString("address")));
                studentInfor.add((resultSet.getString("class")));
                ans.add(studentInfor);
            }
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return ans;
    }
    
    public static Map<Integer, List<List<String>>> getResult(){
        Map<Integer, List<List<String>>> ans = new HashMap<>();
        String query = "SELECT idstudent, subjectname, point FROM result join subject on subject.idsubject = result.idsubject;";
         try(Statement statement = ConnectDataHelper.getInstance().connectDB().createStatement()) {
            statement.execute("use data");
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String idstudent = String.valueOf((resultSet.getInt("idstudent")));
                String subjectname = resultSet.getString("subjectname");
                String point = resultSet.getString("point");
                List<List<String>> value = new ArrayList<>();
                List<String> subjectnameList = new ArrayList<>();
                List<String> pointList = new ArrayList<>();
                if(!ans.containsKey(Integer.valueOf(idstudent))){
                    subjectnameList.add(subjectname);
                    pointList.add(point);
                    value.add(subjectnameList);
                    value.add(pointList);
                    ans.put(Integer.valueOf(idstudent), value);
                    
                }else{
                    value = ans.get(Integer.valueOf(idstudent));
                     List<List<String>> temp = new ArrayList<>(value);
                     temp.get(0).add(subjectname);
                    temp.get(1).add(point);
                    ans.replace(Integer.valueOf(idstudent), value, temp);
                }
            }
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println("ans:"+ans);
        return ans;
        
    }
    
    
    public static boolean addStudent(int studentid, String fullname, String gender, String birth,
            String address, String className){
        System.out.println(birth);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String query = "insert into student(idstudent, fullname, gender, birth, address, class) values(?, ? ,? ,? ,? ,?)";
         try(PreparedStatement statement = ConnectDataHelper.getInstance().connectDB().prepareStatement(query)) {
            statement.execute("use data");
            statement.setInt(1, studentid);
            statement.setString(2, fullname);
            statement.setString(3, gender);
            statement.setDate(4, java.sql.Date.valueOf(birth) );
            statement.setString(5, address);
            statement.setString(6, className);
            statement.executeUpdate();
             System.out.println("updated");
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
        
    }
    
    public static boolean addResults(int studentid, List<List<String>> results){
        String query = "insert into result(idstudent, idsubject, point) values(?, ? ,?)";
        System.out.println("result" + results.size());
         try(PreparedStatement statement = ConnectDataHelper.getInstance().connectDB().prepareStatement(query)) {
            statement.execute("use data");
            statement.setInt(1, studentid);
               for(int i =0; i< 6; i++){
                   statement.setInt(2, i+1);
                   statement.setFloat(3, Float.valueOf(results.get(1).get(i)));
                    statement.executeUpdate();
                    System.out.println("add result");
               }
             
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
        
    }
    
    public static boolean removeStudent(int id){
         String query = "delete from student where idstudent = " + id;
        try(PreparedStatement statement = ConnectDataHelper.getInstance().connectDB().prepareStatement(query)) {
            statement.execute("use data");
          statement.executeUpdate();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
     public static boolean removeResults(int id){
         String query = "delete from result where idstudent = " + id;
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
