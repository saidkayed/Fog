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
    private int height;
    private String roof;
    private String shed;
    private String date;
    private String status;

    public Order(int orderid, int id, int width, int length, int height, String roof, String shed, String date, String status) {
        this.orderid = orderid;
        this.id = id;
        this.width = width;
        this.length = length;
        this.height = height;
        this.roof = roof;
        this.shed = shed;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public String getShed() {
        return shed;
    }

    public void setShed(String shed) {
        this.shed = shed;
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
        return "Order{" + "orderid=" + orderid + ", id=" + id + ", width=" + width + ", length=" + length + ", height=" + height + ", roof=" + roof + ", shed=" + shed + ", date=" + date + ", status=" + status + '}';
    }

    


    public static String empOrderToHtml() throws LoginSampleException {

        String output = "<h2> No orders found in database</h2>";
        ArrayList<Order> order = LogicFacade.getAllOrders();

            if (!order.isEmpty()) {

                output = "<tbody>"
                        + "<tr>"
                        + "<th>Userid</th>"
                        + "<th>Orderid</th>"
                        + "<th>Length</th>"
                        + "<th>Width</th>"
                        + "<th>Height</th>"
                        + "<th>Roof</th>"
                        + "<th>Shed</th>"
                        + "<th>Status</th>"
                        + "</tr>";
                
                for (Order orders : order) {
                output += "<tr>"
                
                        + "<td>" + orders.getId() + "</td>"
                        + "<td>" + orders.getOrderid() + "</td>"
                        + "<td>" + orders.getLength() + "</td>"
                        + "<td>" + orders.getWidth() + "</td>"
                        + "<td>" + orders.getHeight() + "</td>"
                        + "<td>" + orders.getRoof() + "</td>"
                        + "<td>" + orders.getShed() + "</td>"
                        + "<td>" + orders.getStatus() + "</td>";

                if (orders.getStatus().equals("pending")) {
                    output += "<td><form name=\"sendorder\" action=\"FrontController\" method=\"POST\">"
                            + "<input type=\"hidden\" name=\"command\" value=\"sendorder\">"
                            + "<input type=\"hidden\" name=\"orderid\" value=\"" + orders.getOrderid() + "\">"
                            + "<input type=\"submit\" value=\"Send Order\">"
                            + "</form></td>";
                           
                }
                
                 output += "<td><form name=\"productlist\" action=\"FrontController\" method=\"POST\">"
                            + "<input type=\"hidden\" name=\"command\" value=\"productlist\">"
                            + "<input type=\"hidden\" name=\"orderid\" value=\"" + orders.getOrderid() + "\">"
                            + "<input type=\"submit\" value=\"Show Productlist\">"
                            + "</form></td>"
                 
                        + "<td><form name=\"deleteorder\" action=\"FrontController\" method=\"POST\">"
                        + "<input type=\"hidden\" name=\"command\" value=\"deleteorder\">"
                        + "<input type=\"hidden\" name=\"orderid\" value=\"" + orders.getOrderid() + "\">"
                        + "<input type=\"submit\" value=\"Delete Order\">"
                        + "</form></td>"
                        + "</tr>"
                        + "</tbody>";
            }
        }
        return output;
    }
    
     public static String empOrderToHtmlByEmail(String email) throws LoginSampleException {

        String output = "<h2> No orders found in database</h2>";
        User user = LogicFacade.getUserByEmail(email);
        ArrayList<Order> order = LogicFacade.getAllOrdersByUser(user);

            if (!order.isEmpty()) {

                output = "<tbody>"
                        + "<tr>"
                        + "<th>Userid</th>"
                        + "<th>Orderid</th>"
                        + "<th>Length</th>"
                        + "<th>Width</th>"
                        + "<th>Height</th>"
                        + "<th>Roof</th>"
                        + "<th>Shed</th>"
                        + "<th>Status</th>"
                        + "</tr>";
                
                for (Order orders : order) {
                output += "<tr>"
                        + "<td>" + orders.getId() + "</td>"
                        + "<td>" + orders.getOrderid() + "</td>"
                        + "<td>" + orders.getLength() + "</td>"
                        + "<td>" + orders.getWidth() + "</td>"
                        + "<td>" + orders.getHeight() + "</td>"
                        + "<td>" + orders.getRoof() + "</td>"
                        + "<td>" + orders.getShed() + "</td>"
                        + "<td>" + orders.getStatus() + "</td>";

                if (orders.getStatus().equals("pending")) {
                    output += "<td><form name=\"sendorder\" action=\"FrontController\" method=\"POST\">"
                            + "<input type=\"hidden\" name=\"command\" value=\"sendorder\">"
                            + "<input type=\"hidden\" name=\"orderid\" value=\"" + orders.getOrderid() + "\">"
                            + "<input type=\"submit\" value=\"Send Order\">"
                            + "</form></td>";
                }
                output += "<td><form name=\"productlist\" action=\"FrontController\" method=\"POST\">"
                            + "<input type=\"hidden\" name=\"command\" value=\"productlist\">"
                            + "<input type=\"hidden\" name=\"orderid\" value=\"" + orders.getOrderid() + "\">"
                            + "<input type=\"submit\" value=\"Show Productlist\">"
                            + "</form></td>"
                        
                        + "<td><form name=\"deleteorder\" action=\"FrontController\" method=\"POST\">"
                        + "<input type=\"hidden\" name=\"command\" value=\"deleteorder\">"
                        + "<input type=\"hidden\" name=\"orderid\" value=\"" + orders.getOrderid() + "\">"
                        + "<input type=\"submit\" value=\"Delete Order\">"
                        + "</form></td>"
                        + "</tr>"
                        + "</tbody>";
            }
        }
        return output;
    }
    
    

    public static String userOrderToHtml(User user) throws LoginSampleException {
        String output = "<h2> You have not made any orders</h2>";
        ArrayList<Order> order = LogicFacade.getAllOrdersByUser(user);

        if (!order.isEmpty()) {

            output = "<tbody>"
                    + "<tr>"
                    + "<th>Userid</th>"
                    + "<th>Orderid</th>"
                    + "<th>Length</th>"
                    + "<th>Width</th>"
                    + "<th>Height</th>"
                    + "<th>Roof</th>"
                    + "<th>Shed</th>"
                    + "<th>Status</th>"
                    + "</tr>";

            for (Order orders : order) {
                output += "<tr>"
                        + "<td>" + orders.getId() + "</td>"
                        + "<td>" + orders.getOrderid() + "</td>"
                        + "<td>" + orders.getLength() + "</td>"
                        + "<td>" + orders.getWidth() + "</td>"
                        + "<td>" + orders.getHeight() + "</td>"
                        + "<td>" + orders.getRoof() + "</td>"
                        + "<td>" + orders.getShed() + "</td>"
                        + "<td>" + orders.getStatus() + "</td>";
                        

                if(orders.getStatus().equals("Accepted")){
                    output += "<td><form name=\"productlist\" action=\"FrontController\" method=\"POST\">"
                            + "<input type=\"hidden\" name=\"command\" value=\"productlist\">"
                            + "<input type=\"hidden\" name=\"orderid\" value=\"" + orders.getOrderid() + "\">"
                            + "<input type=\"submit\" value=\"Show Productlist\">"
                            + "</form></td>";
                }
                output += "</tr>";
            }
            output += "</tbody>";
        }
        return output;
    }
}
