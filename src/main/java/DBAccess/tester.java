/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.CarportCalculator;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Materials;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.text.DecimalFormat;
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
        
        double angleToRaidans = Math.toRadians(20);
        double width = 300;
        double højdeKatete = (width/2) * Math.tan(angleToRaidans);
                    
        
        System.out.println(højdeKatete);
        
        
        
        
    }
    
            
    
}
