/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.CarportException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tobbe
 */
public class OrderMapper {

    public static void createOrder(User user, Order order) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `order` (id, width, length, height, roof, shed, date, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, user.getId());
            ps.setInt(2, order.getWidth());
            ps.setInt(3, order.getLength());
            ps.setInt(4, order.getHeight());
            ps.setString(5, order.getRoof());
            ps.setString(6, order.getShed());
            ps.setString(7, order.getDate());
            ps.setString(8, order.getStatus());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setOrderid(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public static ArrayList<Order> getAllOrders() throws CarportException {
        ArrayList<Order> allOrders = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "Select * from `order`";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int orderid = rs.getInt("orderid");
                int id = rs.getInt("id");
                int width = rs.getInt("width");
                int length = rs.getInt("length");
                int height = rs.getInt("height");
                String roof = rs.getString("roof");
                String shed = rs.getString("shed");
                String date = rs.getString("date");
                String status = rs.getString("status");
                
                
                Order order = new Order(id, width, length, height, roof, shed, date, status);
                order.setOrderid(orderid);
                allOrders.add(order);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
        return allOrders;
    }

    public static ArrayList<Order> getAllOrdersByUser(User user) throws CarportException {
        ArrayList<Order> allOrders = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "Select * from `order` where id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, user.getId());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int orderid = rs.getInt("orderid");
                int width = rs.getInt("width");
                int length = rs.getInt("length");
                int height = rs.getInt("height");
                String roof = rs.getString("roof");
                String shed = rs.getString("shed");
                String date = rs.getString("date");
                String status = rs.getString("status");

                Order order = new Order(user.getId(), width, length, height, roof, shed, date, status);
                order.setOrderid(orderid);
                
                allOrders.add(order);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
        return allOrders;
    }
    
    public static Order getOrderById(int orderid) throws CarportException{
        Order order = null;
        try{
            Connection con = Connector.connection();
            String SQL = "select * from `order` where orderid = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setInt(1, orderid);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                int width = rs.getInt("width");
                int length = rs.getInt("length");
                int height = rs.getInt("height");
                String roof = rs.getString("roof");
                String shed = rs.getString("shed");
                String date = rs.getString("date");
                String status = rs.getString("status");
                
                order = new Order(id, width, length, height, roof, shed, date, status);
                order.setOrderid(orderid);
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
    }
        return order;
    }

    public static void sendOrderById(int orderid) throws CarportException {
        Order output = null;

        try {
            Connection con = Connector.connection();
            String SQL = "Update `order` set status = ? where orderid = ?";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, "Accepted");
            st.setInt(2, orderid);
            st.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public static void deleteOrderById(int orderid) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "Delete from `order` where orderid = ?";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, orderid);
            st.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }

    }
}
