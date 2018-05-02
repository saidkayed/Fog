/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tobbe
 */
public class OrderMapper {

    public static void createOrder(User user, int width, int length, String date, String status) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `order` (id, width, length, date, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, user.getId());
            ps.setInt(2, width);
            ps.setInt(3, length);
            ps.setString(4, date);
            ps.setString(5, status);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<Order> getAllOrders() throws LoginSampleException {
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
                String date = rs.getString("date");
                String status = rs.getString("status");

                Order order = new Order(orderid, id, width, length, date, status);

                allOrders.add(order);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return allOrders;
    }

    public static ArrayList<Order> getAllOrdersById(User user) throws LoginSampleException {
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
                String date = rs.getString("date");
                String status = rs.getString("status");

                Order order = new Order(orderid, user.getId(), width, length, date, status);

                allOrders.add(order);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return allOrders;
    }

    public static void sendOrderById(int orderid) throws LoginSampleException {
        Order output = null;

        try {
            Connection con = Connector.connection();
            String SQL = "Update `order` set status = ? where orderid = ?";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, "Accepted");
            st.setInt(2, orderid);
            st.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void deleteOrderById(int orderid) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "Delete from `order` where orderid = ?";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, orderid);
            st.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

    }
}
