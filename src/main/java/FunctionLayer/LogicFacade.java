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

    public static void makeOrder(User user, int width, int length, int height, String roof, String shed) throws LoginSampleException {
        Date date = new Date();
        String finalDate = date.toString();

        String status = "pending";

        OrderMapper.createOrder(user, width, length, height, roof, shed, finalDate, status);
    }

    public static void addMaterial(Materials mat) throws LoginSampleException {
        MaterialsMapper.addMaterial(mat);
    }
    
    public static void deleteMaterialById(int materialid) throws LoginSampleException {
        MaterialsMapper.deleteMaterialById(materialid);
    }    

    public static ArrayList<Order> getAllOrders() throws LoginSampleException {
        return OrderMapper.getAllOrders();
    }
    
    public static Order getOrderById(int orderid) throws LoginSampleException {
        return OrderMapper.getOrderById(orderid);
    }

    public static ArrayList<Materials> getAllMaterials() throws LoginSampleException {
        return MaterialsMapper.getAllMaterials();
    }
    
    public static Materials getMaterialByName(String name) throws LoginSampleException {
        return MaterialsMapper.getMaterialByName(name);
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
