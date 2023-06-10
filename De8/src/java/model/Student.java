
package model;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Student implements Serializable {

    @Column(name = "id")
    public List<String> id;
    @Column(name = "name")
    public List<String> name;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    public List<Date> dob;
    @Column(name = "department")
    public List<String> department;
    @Column(name = "approved")
    public List<Integer> approved;
    String errString;
    private Connection conn;
    private Statement stm;
    
    public void Approve(String id){
        try {
            stm.executeUpdate("UPDATE `student` SET `approved` = '1' WHERE (`id` = '" + id + "')");
        } catch (Exception e) {
        }
    }
    
    public void Delete(String id){
        try {
            stm.executeUpdate("DELETE FROM `db`.`student` WHERE (`id` = '" + id + "')");
        } catch (Exception e) {
        }
    }
    private void Connect(){
        String url = "jdbc:mysql://localhost:3306/db";
        String username = "root";
        String password = "88888888";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, username, password);
            this.stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM student");
            for (int i = 0; rs.next(); i++){
                if (rs.getInt("approved") == 0){
                    this.id.add(rs.getString("id"));
                    this.name.add(rs.getString("name"));
                    this.dob.add(rs.getDate("dob"));
                    this.department.add(rs.getString("department"));
                    this.approved.add(rs.getInt("approved"));
                }
            }
        } catch (Exception e) {
        }
    }

    public Student() {
        this.id = new ArrayList<>();
        this.name = new ArrayList<>();
        this.dob = new ArrayList<>();
        this.department = new ArrayList<>();
        this.approved = new ArrayList<>();
        Connect();
    }
    
    
}
