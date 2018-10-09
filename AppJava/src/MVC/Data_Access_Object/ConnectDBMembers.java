/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Data_Access_Object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import MVC.model.Members;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Noojar
 */
public class ConnectDBMembers {
    private String driver = "com.mysql.jdbc.Driver";

    private String uri = "jdbc:mysql://localhost/projectint4102";

    private String user = "root";

    private String pass = "";

    private Connection connect = null;

    public ConnectDBMembers() {
        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(uri, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No Success");
        }
    }

    public void close() {

        try {

            if (connect != null) {

                connect.close();

            }

        } catch (SQLException e) {
        }

    }
    
    public boolean Addmembers(Members Members) {
        boolean result = false;
        String sql = "INSERT INTO members(ID,Pwd,Fname,Lname,Brith_date,Email,Tel,Address,Sex)" + "Value(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, Members.GetID());
            ps.setString(2, Members.GetPwd());
            ps.setString(3, Members.GetFname());
            ps.setString(4, Members.GetLname());
            ps.setString(5, Members.GetBrith_date());
            ps.setString(6, Members.GetEmail());
            ps.setString(7, Members.GetTel());
            ps.setString(8, Members.GetAddress());
            ps.setString(9, Members.GetSex());
            int record = ps.executeUpdate();
            if (record >= 1) {
                result = true;
            } else {
                result = false;
            }
            connect.close();
        } catch (SQLException e) {
        }
        return result;
    }
    
    
    
    public List<Members> findlog_in(){
       List<Members> MembersList = new ArrayList<>();
       String sql = "SELECT ID,Pwd,type FROM members where MID ";
        try {
             PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Members mbs = new Members();
                mbs.SetId(result.getString("ID"));
                mbs.SetPwd(result.getString("Pwd"));
                mbs.SetType(result.getString("type"));
                MembersList.add(mbs);
            }
            connect.close();
        } catch (SQLException e) {
        }
       return MembersList;
    }
    
    
    
    public List<Members> fildALL() {
         List<Members> MemberList = new ArrayList<>();
        String sql = "SELECT * FROM members where MID";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Members p = new Members();
               p.SetId(result.getString("MID"));
               p.Setfname(result.getString("Fname"));
               p.Setlname(result.getString("Lname"));
               p.SetType(result.getString("type"));
                MemberList.add(p);
            }
            
            connect.close();
        } catch (Exception e) {
        }
        return MemberList;
    }
    
    
    
    
    
    public boolean edit(Members member){
         boolean result = false;

        String sql = "UPDATE members SET Lname = ?, Fname = ?, type =?"
                + " WHERE MID = ?";

        try {

            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(4, member.GetID());
           ps.setString(1, member.GetFname());
           ps.setString(2, member.GetLname());
           ps.setString(3, member.GetType());

            int record = ps.executeUpdate();

            if (record >= 1) {

                result = true;

            } else {

                result = false;

            }

            connect.close();

        } catch (SQLException e) {
        }

        return result;
    }
}
