/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author traig
 */
public class Student {
    
    private int studentid;
    private String fullname;
    private String gender;
    private String address;
    private String className;
    private String birth;
   
    private List<Subject> listSubjects;
    public Student(int studentid, String fullname, String gender, String birth, 
            String address, String className ,List<Subject> listSubjects ) {
        this.studentid = studentid;
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
        this.className = className;
        this.birth = birth;
        this.listSubjects = listSubjects;
    }

    public List<Subject> getListSubjects() {
        return listSubjects;
    }

    public void setListSubjects(List<Subject> listSubjects) {
        this.listSubjects = listSubjects;
    }
    
    
    public Student(){}
    
    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

  

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

 

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

   

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    
    
    
    
    
}
