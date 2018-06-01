/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

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

    public Order(int id, int width, int length, int height, String roof, String shed, String date, String status) {
        //this.orderid = orderid;
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
}
