/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.CarportCalculator;

import FunctionLayer.LogicFacade;
import FunctionLayer.CarportException;
import FunctionLayer.Materials;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tobbe
 */
public class tester {

    /**
     * @param args the command line arguments
     * @throws FunctionLayer.CarportException
     */
    public static void main(String[] args) throws CarportException, IOException {
/*
        LogicFacade.createUser("ja", "hej", 123);

        User user = LogicFacade.getUserByEmail("ja");

        Order bla = new Order(1, 2, 3, 4, "rejsning", "withoutshed", "date", "pending");

        LogicFacade.createOrder(user, bla);

        Order order = LogicFacade.getOrderById(bla.getId());

        System.out.println(order.getStatus());
        
        ArrayList<Materials> allMats = new ArrayList();
        
        CarportCalculator car = new CarportCalculator();
        
        allMats = car.calculator(order.getId());
        
        System.out.println(allMats.toString());

*/

ArrayList<Order> orders = LogicFacade.getAllOrders();

        System.out.println(orders.toString());
    }

}
