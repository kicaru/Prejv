/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Data_Access_Object;

import MVC.model.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Noojar
 */
public class ConnectDBorder {
   private String driver = "com.mysql.jdbc.Driver";

    private String uri = "jdbc:mysql://localhost/projectint4102";

    private String user = "root";

    private String pass = "";

    private Connection connect = null;

    public ConnectDBorder() {
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
        
    public List<Order> ShowOrder(String id,String date) {
        List<Order> OrderList = new ArrayList<>();
         String sql = "SELECT * FROM order_products WHERE cid = ?AND add_date = ?";
         
        try {
              PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, date);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
               Order or=new Order();
               or.SetId(result.getInt("oid"));
               or.SetPid(result.getString("pid"));
               or.SetPname(result.getString("pname"));
               or.SetCid(result.getString("cid"));
               or.SetPrice((float)result.getFloat("price"));
               or.SetType(result.getString("type"));
               or.SetDate(result.getString("add_date"));
                
               OrderList.add(or);
            }
            connect.close();
        } catch (SQLException e) {
        }
        return OrderList;
    }
 
    
    
    public boolean delete(int id) {
        boolean result = false;
 
String sql = "DELETE FROM order_products WHERE oid = ?";
 
try {
 
PreparedStatement ps = connect.prepareStatement(sql);
 
ps.setInt(1, id);
 
ps.executeUpdate();
 
} catch (SQLException e) {
}
 return true;
}
    
     public boolean addorder(Order order) {
        boolean result = false;
        String sql = "INSERT INTO order_products(pid,pname,cid,price,type,add_date)" + "Value(?,?,?,?,?,?)";
       
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, order.GetPid());
            ps.setString(2, order.GetPname());
            ps.setString(3, order.GetCid());
            ps.setFloat(4, order.GetPrice());
            ps.setString(5, order.GetType());
            ps.setString(6, order.GetDate());
            int record = ps.executeUpdate();
            if (record >= 1) {

                result = true;

            } else {

                result = false;
            }
            connect.close();
        } catch (Exception e) {
        }
        return result;
    }
}
