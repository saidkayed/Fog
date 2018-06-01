/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;


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
    /*
    public Materials(String name, double amount, double dprice){
        this.name = name;
        this.amount = amount;
        this.dprice = dprice;
    }
*/
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
}
