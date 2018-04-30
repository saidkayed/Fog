package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.ArrayList;
import java.util.Date;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
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

    public static void makeOrder(User user, int width, int length) throws LoginSampleException {
        Date date = new Date();
        String finalDate = date.toString();

        String status = "pending";

        OrderMapper.createOrder(user, width, length, finalDate, status);
    }

    public static ArrayList<Order> getAllOrders() throws LoginSampleException {
        return OrderMapper.getAllOrders();
    }

    public static ArrayList<Order> getAllOrdersById(User user) throws LoginSampleException {
        return OrderMapper.getAllOrdersById(user);
    }
    public static void sendOrderById(int orderid) throws LoginSampleException{
        OrderMapper.sendOrderById(orderid);
    }
    public static void deleteOrderById(int orderid) throws LoginSampleException{
        OrderMapper.deleteOrderById(orderid);
    }
}
