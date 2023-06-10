
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentMD {
    
    public String id;
    public String name;
    public String dob ;
    public String department ;
    private Connection con;
    private Statement stm;
    public List<String> idlList;
    
    public boolean CheckDB(){
        if (this.idlList.contains(id)){
            return false;
        }
        return true;
    }
    
    public StudentMD() {
        this.idlList = new ArrayList<>();
        this.Connect();
    }
    
    public String AddStudent(){
        try {
            stm.executeUpdate("INSERT INTO `st`.`tb` (`id`, `name`, `dob`, `department`) VALUES ('" + this.id +"', '" + this.name +"', '" + this.dob +"', '" + this.department +"')");
        
        } catch (Exception e) {
            return e.toString();
        }
        return "done";
    }
    
    private void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/st", "root", "1234");
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM st.tb");
            while (rs.next()){
                this.idlList.add(rs.getString("id"));
            }
        } catch (Exception e) {
        }
    }
    
}
