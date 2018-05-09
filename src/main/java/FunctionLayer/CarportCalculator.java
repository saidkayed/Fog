/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;

/**
 *
 * @author tobbe
 */
public class CarportCalculator {
    
    public ArrayList<Materials> calculator(int orderid) throws LoginSampleException{
        ArrayList<Materials> allMaterials = new ArrayList();
        Order order = LogicFacade.getOrderById(orderid);
        
        int width = order.getWidth();
        int length = order.getLength();
        int height = order.getHeight();
        String roof = order.getRoof();
        String shed = order.getShed();
               
        
        
        return allMaterials;
    }
}
