package FunctionLayer;

import DBAccess.MaterialsMapper;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * The purpose of LogicFacade is to...
 *
 * @author tobbe
 */
public class LogicFacade {

    //UserMapper
    public static User login(String email, String password) throws CarportException, IOException {
    return UserMapper.login (email, password);
}

    /**
     * Takes the 3 parameters og creates a User object which is added to the database
     * @param email
     * @param password
     * @param phone
     * @return User
     * @throws CarportException
     */
    public static User createUser(String email, String password, int phone) throws CarportException {
        User user = new User(email, password, phone, "customer");
        UserMapper.createUser(user);
        return user;
    }

    /**
     * Returns a User object with the email parameter from the database
     * @param email
     * @return User
     * @throws CarportException
     */
    public static User getUserByEmail(String email) throws CarportException {
        return UserMapper.getUserByEmail(email);
    }

    /**
     * Returns an int phone with the id parameter from the database
     * @param id
     * @return int 
     * @throws CarportException
     */
    public static int getPhoneByUserId(int id) throws CarportException {
        return UserMapper.getPhoneByUserId(id);
    }

    /**
     * Returns a User object with the id from the database
     * @param id
     * @return User
     * @throws CarportException
     */
    public static User getUserById(int id) throws CarportException {
        return UserMapper.getUserById(id);
    }

    //OrderMapper

    /**
     * Adds an order to the database
     * @param user
     * @param order
     * @throws CarportException
     */
    public static void createOrder(User user, Order order) throws CarportException {
        OrderMapper.createOrder(user, order);
    }

    /**
     * Returns an arraylist containing Order objects from the database
     * @return ArrayList
     * @throws CarportException
     */
    public static ArrayList<Order> getAllOrders() throws CarportException {
        return OrderMapper.getAllOrders();
    }

    /**
     * Returns an Order from the database with the orderid
     * @param orderid
     * @return Order
     * @throws CarportException
     */
    public static Order getOrderById(int orderid) throws CarportException {
        return OrderMapper.getOrderById(orderid);
    }

    /**
     * Returns an arraylist containing Order objects made by the user from the database
     * @param user
     * @return ArrayList
     * @throws CarportException
     */
    public static ArrayList<Order> getAllOrdersByUser(User user) throws CarportException {
        return OrderMapper.getAllOrdersByUser(user);
    }

    /**
     * Updates the status of the Order with the orderid from pending to accepted
     * @param orderid
     * @throws CarportException
     */
    public static void sendOrderById(int orderid) throws CarportException {
        OrderMapper.sendOrderById(orderid);
    }

    /**
     * Deletes the Order form the database with the orderid parameter
     * @param orderid
     * @throws CarportException
     */
    public static void deleteOrderById(int orderid) throws CarportException {
        OrderMapper.deleteOrderById(orderid);
    }

    //MaterialMapper

    /**
     * Adds a Materials to the database
     * @param mat
     * @throws CarportException
     */
    public static void addMaterial(Materials mat) throws CarportException {
        MaterialsMapper.addMaterial(mat);
    }

    /**
     * Deletes a Materials from the database with the materialid
     * @param materialid
     * @throws CarportException
     */
    public static void deleteMaterialById(int materialid) throws CarportException {
        MaterialsMapper.deleteMaterialById(materialid);
    }

    /**
     * Returns an arraylist containing all Materials from the database
     * @return ArrayList
     * @throws CarportException
     */
    public static ArrayList<Materials> getAllMaterials() throws CarportException {
        return MaterialsMapper.getAllMaterials();
    }

    /**
     * Returns a Materials object with the parameter name
     * @param name
     * @return Materials
     * @throws CarportException
     */
    public static Materials getMaterialByName(String name) throws CarportException {
        return MaterialsMapper.getMaterialByName(name);
    }

}
