/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;

/**
 *
 * @author Sercan
 */
public class RenderOrder {
    public static String empOrderToHtml() throws CarportException {

        String output = "<h2> No orders found in database</h2>";
        ArrayList<Order> order = LogicFacade.getAllOrders();

        if (!order.isEmpty()) {

            output = "<tbody>"
                    + "<tr>"
                    + "<th>Userid</th>"
                    + "<th>Orderid</th>"
                    + "<th>Phone</th>"
                    + "<th>Length</th>"
                    + "<th>Width</th>"
                    + "<th>Height</th>"
                    + "<th>Roof</th>"
                    + "<th>Shed</th>"
                    + "<th>Status</th>"
                    + "</tr>";

            for (Order orders : order) {
                int phone = LogicFacade.getPhoneByUserId(orders.getId());
                output += "<tr>"
                        + "<td>" + orders.getId() + "</td>"
                        + "<td>" + orders.getOrderid() + "</td>"
                        + "<td>" + phone + "</td>"
                        + "<td>" + orders.getLength() + "</td>"
                        + "<td>" + orders.getWidth() + "</td>"
                        + "<td>" + orders.getHeight() + "</td>"
                        + "<td>" + orders.getRoof() + "</td>"
                        + "<td>" + orders.getShed() + "</td>"
                        + "<td>" + orders.getStatus() + "</td>";

                if (orders.getStatus().equals("Pending")) {
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

    public static String empOrderToHtmlByEmail(User user) throws CarportException {

        String output = "<h2> No orders found in database</h2>";
        ArrayList<Order> order = LogicFacade.getAllOrdersByUser(user);

        if (!order.isEmpty()) {

            output = "<tbody>"
                    + "<tr>"
                    + "<th>Userid</th>"
                    + "<th>Orderid</th>"
                    + "<th>Phone</th>"
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
                        + "<td>" + user.getPhone() + "</td>"
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

    public static String userOrderToHtml(User user) throws CarportException {
        String output = "<h2> You have not made any orders</h2>";
        ArrayList<Order> order = LogicFacade.getAllOrdersByUser(user);

        if (!order.isEmpty()) {

            output = "<tbody>"
                    + "<tr>"
                    + "<th>Userid</th>"
                    + "<th>Orderid</th>"
                    + "<th>Phone</th>"
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
                        + "<td>" + user.getPhone() + "</td>"
                        + "<td>" + orders.getLength() + "</td>"
                        + "<td>" + orders.getWidth() + "</td>"
                        + "<td>" + orders.getHeight() + "</td>"
                        + "<td>" + orders.getRoof() + "</td>"
                        + "<td>" + orders.getShed() + "</td>"
                        + "<td>" + orders.getStatus() + "</td>";

                if (orders.getStatus().equals("Accepted")) {
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
