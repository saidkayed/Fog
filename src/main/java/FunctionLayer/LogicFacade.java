package FunctionLayer;

import DBAccess.MaterialsMapper;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.ArrayList;
import java.util.Date;

/**
 * The purpose of LogicFacade is to...
 *
 * @author tobbe
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static void makeOrder(User user, int width, int length, int height) throws LoginSampleException {
        Date date = new Date();
        String finalDate = date.toString();

        String status = "pending";

        OrderMapper.createOrder(user, width, length, height, finalDate, status);
    }

    public static void addMaterial(Materials mat) throws LoginSampleException {
        MaterialsMapper.addMaterial(mat);
    }

    public static ArrayList<Order> getAllOrders() throws LoginSampleException {
        return OrderMapper.getAllOrders();
    }

    public static ArrayList<Materials> getAllMateriales() throws LoginSampleException {
        return MaterialsMapper.getAllMateriales();
    }

    public static ArrayList<Order> getAllOrdersByUser(User user) throws LoginSampleException {
        return OrderMapper.getAllOrdersByUser(user);
    }

    public static void sendOrderById(int orderid) throws LoginSampleException {
        OrderMapper.sendOrderById(orderid);
    }

    public static void deleteOrderById(int orderid) throws LoginSampleException {
        OrderMapper.deleteOrderById(orderid);
    }

    public static User getUserByEmail(String email) throws LoginSampleException {
        return UserMapper.getUserByEmail(email);
    }
}
