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
    private double dprice;
    private double amount;
    private String length;
    private String unit;
    private String description;

    public Materials(String name, int price, String length, String description) {
        this.name = name;
        this.price = price;
        this.length = length;
        this.description = description;
    }
    
    public Materials(String name, double amount, double dprice){
        this.name = name;
        this.amount = amount;
        this.dprice = dprice;
    }
    public Materials(String name, String length, double amount, String unit, String description, double dprice){
     this.name = name;   
     this.length = length;
     this.amount = amount;
     this.unit = unit;
     this.description = description;
     this.dprice = dprice;
        
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

    public int getMaterialid() {
        return materialid;
    }

    public void setMaterialid(int materialid) {
        this.materialid = materialid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDprice() {
        return dprice;
    }

    public void setDprice(double dprice) {
        this.dprice = dprice;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    

    public static String empMaterialeToHtml() throws LoginSampleException {

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

    public static String materialToProductListHtml(ArrayList<Materials> materials) throws LoginSampleException {
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
    public static int materialTotalPrice(ArrayList<Materials> materials) throws LoginSampleException{
        int totalprice = 0;
        
        if(!materials.isEmpty()){
            for (Materials mats : materials) {
                totalprice += mats.getDprice();
            }
        } return totalprice;
    }
}
