/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Data_Access_Object;

import MVC.model.product;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Noojar
 */
public class ConnectDB {

    private String driver = "com.mysql.jdbc.Driver";

    private String uri = "jdbc:mysql://localhost/projectint4102";

    private String user = "root";

    private String pass = "";

    private Connection connect = null;

    public ConnectDB() {
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

    public List<product> fildALL() {
        List<product> ProductList = new ArrayList<>();
        String sql = "SELECT * FROM products where id";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                product p = new product();
                p.SetID(result.getString("id"));
                p.Setname(result.getNString("name"));
                p.SetPrice((int) result.getFloat("price"));
                p.SetDescription(result.getString("detail"));
                p.Setadd_date(result.getString("add_date"));
                p.SetType(result.getString("type"));
                p.SetImage(result.getBytes("image"));
                System.out.println("++ID++ "+result.getString("id"));
                ProductList.add(p);
            }
            connect.close();
        } catch (Exception e) {
        }
        return ProductList;
    }

    public boolean addproduct(product product) {
        boolean result = false;
        String sql = "INSERT INTO products(name,price,detail,add_date,image,type)" + "Value(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, product.GetName());
            ps.setFloat(2, product.GetPrice());
            ps.setString(3, product.GetDescription());
            ps.setString(4, product.GetAdd_date());
            ps.setBytes(5, product.GetImage());
            ps.setString(6, product.GetType());
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

    
    
    public boolean edit(product product) {

        boolean result = false;

        String sql = "UPDATE products SET name = ?, price = ?,detail=?,add_date=?,image=?,type=?"
                + " WHERE id = ?";

        try {

            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(7, product.GetID());
            ps.setString(1, product.GetName());
            ps.setFloat(2, product.GetPrice());
            ps.setString(3, product.GetDescription());
            ps.setString(4, product.GetAdd_date());
            ps.setBytes(5, product.GetImage());
            ps.setString(6, product.GetType());

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
    
    public boolean editNoimg(product product) {

        boolean result = false;

        String sql = "UPDATE products SET name = ?, price = ?,detail=?,add_date=?,type=?"
                + " WHERE id = ?";

        try {

            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(6, product.GetID());
            ps.setString(1, product.GetName());
            ps.setFloat(2, product.GetPrice());
            ps.setString(3, product.GetDescription());
            ps.setString(4, product.GetAdd_date());
            ps.setString(5, product.GetType());

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
    
    public boolean delete(int id) {
        boolean result = false;
 
String sql = "DELETE FROM products WHERE id = ?";
 
try {
 
PreparedStatement ps = connect.prepareStatement(sql);
 
ps.setInt(1, id);
 
ps.executeUpdate();
 
} catch (Exception e) {
 
e.printStackTrace();
 
}
 return true;
}

    
    public List<product> ShowALL(String type) {
        List<product> ProductList = new ArrayList<>();
        String sql = "SELECT * FROM products where type=?";
        
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, type);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                product p = new product();
               p.SetID(result.getString("id"));
                p.Setname(result.getNString("name"));
                p.SetPrice((int) result.getFloat("price"));
                p.SetDescription(result.getString("detail"));
                p.Setadd_date(result.getString("add_date"));
                p.SetType(result.getString("type"));
                p.SetImage(result.getBytes("image"));
                //System.out.println("++ID++ "+result.getString("id"));
                ProductList.add(p);
            }
            connect.close();
        } catch (Exception e) {
        }
        return ProductList;
    }
    
}
