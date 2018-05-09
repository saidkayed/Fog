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
public class Materials {

    private int materialid;
    private String name;
    private int price;

    public Materials(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return materialid;
    }

    public void setId(int materialid) {
        this.materialid = materialid;
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
        ArrayList<Materials> mat = LogicFacade.getAllMateriales();

        if (!mat.isEmpty()) {

            output = "<tbody>"
                    + "<tr>"
                    + "<th>materialid</th>"
                    + "<th>Name</th>"
                    + "<th>Price</th>"
                    + "</tr>";

            for (Materials mats : mat) {
                output += "<tr>"
                        + "<td>" + mats.getId() + "</td>"
                        + "<td>" + mats.getName() + "</td>"
                        + "<td>" + mats.getPrice() + "</td>"
                        +"</tr>"
                        +"</tbody>";
            }
        }
        return output;
    }
}