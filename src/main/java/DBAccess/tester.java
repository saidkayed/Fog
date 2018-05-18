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


        
        User user = UserMapper.login("123", "123");
        
        System.out.println(user.getRole());
        
        
        
        

    }
    
            
    
}
