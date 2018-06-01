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
public class RenderMaterials {

    public static String empMaterialeToHtml() throws CarportException {
        
        String output = "<h2> No materials found in database</h2>";
        ArrayList<Materials> mat = LogicFacade.getAllMaterials();

        if (!mat.isEmpty()) {

            output = "<tbody>"
                    + "<tr>"
                    + "<th>materialid</th>"
                    + "<th>Name</th>"
                    + "<th>Length</th>"
                    + "<th>Price</th>"
                    + "</tr>";

            for (Materials mats : mat) {
                output += "<tr>"
                        + "<td>" + mats.getId() + "</td>"
                        + "<td>" + mats.getName() + "</td>"
                        + "<td>" + mats.getLength() + "</td>"
                        + "<td>" + mats.getPrice() + "</td>"
                        + "<td><form name=\"deletematerial\" action=\"FrontController\" method=\"POST\">"
                        + "<input type=\"hidden\" name=\"command\" value=\"deletematerial\">"
                        + "<input type=\"hidden\" name=\"materialid\" value=\"" + mats.getId() + "\">"
                        + "<input type=\"submit\" value=\"Delete Material\">"
                        + "</form></td>"
                        + "</tr>"
                        + "</tbody>";
            }
        }
        return output;
    }

    public static String materialToProductListHtml(ArrayList<Materials> materials) throws CarportException {
        //public Materials(String name, double length, double amount, String unit, String description, double dprice){

        String output = "<h2> Something went wrong </h2>";

        if (!materials.isEmpty()) {
            output = "<tbody>"
                    + "<tr>"
                    + "<th>Name</th>"
                    + "<th>Length</th>"
                    + "<th>Amount</th>"
                    + "<th>Unit</th>"
                    + "<th>Description</th>"
                    + "<th>Price</th>"
                    + "</tr>";

            for (Materials mats : materials) {
                output += "<tr>"
                        + "<td>" + mats.getName() + "</td>"
                        + "<td>" + mats.getLength() + "</td>"
                        + "<td>" + mats.getAmount() + "</td>"
                        + "<td>" + mats.getUnit() + "</td>"
                        + "<td>" + mats.getDescription() + "</td>"
                        + "<td>" + mats.getDprice() + "</td>";
            }
            output += "</tr>"
                    + "</tbody>";
        }
        return output;

    }

    public static int materialTotalPrice(ArrayList<Materials> materials) throws CarportException {
        int totalprice = 0;

        if (!materials.isEmpty()) {
            for (Materials mats : materials) {
                totalprice += mats.getDprice();
            }
        }
        return totalprice;
    }

}
