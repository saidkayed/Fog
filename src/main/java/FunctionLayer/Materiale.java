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
public class Materiale {

    private int id;
    private String name;
    private int price;

    public Materiale(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static String empMaterialeToHtml() throws LoginSampleException {

        String output = "<h2> No orders found in database</h2>";
        ArrayList<Materiale> mat = LogicFacade.getAllMateriales();

        if (!mat.isEmpty()) {

            output = "<tbody>"
                    + "<tr>"
                    + "<th>Userid</th>"
                    + "<th>Orderid</th>"
                    + "<th>Length</th>"
                    + "<th>Width</th>"
                    + "<th>Height</th>"
                    + "<th>Status</th>"
                    + "</tr>";

            for (Material orders : order) {
                output += "<tr>"
                        + "<td>" + orders.getId() + "</td>"
                        + "<td>" + orders.getOrderid() + "</td>"
                        + "<td>" + orders.getLength() + "</td>"
                        + "<td>" + orders.getWidth() + "</td>"
                        + "<td>" + orders.getHeight() + "</td>"
                        + "<td>" + orders.getStatus() + "</td>";

                if (orders.getStatus().equals("pending")) {
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
                        + "</tr>"
                        + "</tbody>";
            }
        }
        return output;
    }
}
