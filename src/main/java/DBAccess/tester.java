/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.ArrayList;

/**
 *
 * @author tobbe
 */
public class tester {

    /**
     * @param args the command line arguments
     * @throws FunctionLayer.LoginSampleException
     */
    public static void main(String[] args) throws LoginSampleException {
       
        LogicFacade lf = new LogicFacade();
       User user = new User("test", "test", "customer");
        lf.makeOrder(user, 200, 200, 200);
        
       
    }
    
}
