/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;

/**
 *
 * @author tobbe
 */
public class Order {
    private int orderid;
    private int id;
    private int width;
    private int length;
    private String date;
    private String status;

    public Order(int orderid, int id, int width, int length, String date, String status) {
        this.orderid = orderid;
        this.id = id;
        this.width = width;
        this.length = length;
        this.date = date;
        this.status = status;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "orderid=" + orderid + ", id=" + id + ", width=" + width + ", length=" + length + ", date=" + date + ", status=" + status + '}';
    }
    
    
    public static String empOrderToHtml() throws LoginSampleException{
       
       String output = "<tbody>";
        ArrayList<Order> order = LogicFacade.getAllOrders();

        for (Order orders : order) {
            output += "<tr>"
                    + "<td>" + orders.getOrderid() + "</td>"
                    + "<td>" + orders.getLength() + "</td>"
                    + "<td>" + orders.getWidth() + "</td>"
                    + "<td>" + orders.getStatus() + "</td>";
                    
                    if(orders.getStatus().equals("pending")){
                    output += "<td><form name=\"sendorder\" action=\"FrontController\" method=\"POST\">"
                    + "<input type=\"hidden\" name=\"command\" value=\"sendorder\">"
                    + "<input type=\"hidden\" name=\"orderid\" value=\"" + orders.getOrderid() + "\">"
                    + "<input type=\"submit\" value=\"Send Order\">"
                    + "</form></td>";
                            }
                    output += "<td><form name=\"deleteorder\" action=\"FrontController\" method=\"POST\">"
                    + "<input type=\"hidden\" name=\"command\" value=\"deleteorder\">"
                    + "<input type=\"hidden\" name=\"orderid\" value=\"" + orders.getOrderid() + "\">"
                    + "<input type=\"submit\" value=\"Delete Order\">"
                    + "</form></td>"
                    + "</tr>";
    } 

    output += "</tbody>";

    
    
    if(order.isEmpty()) { output = "<h1> No orders found in database</h1>";
    }
    return output;
}
}
