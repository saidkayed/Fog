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
<<<<<<< HEAD

        
        Materials planke = LogicFacade.getMaterialByName("Planke(10cm*20cm) (meter pris)");
        
        System.out.println(planke.getPrice());        
        
       
=======
        Materials skurPlanke = LogicFacade.getMaterialByName("Skur planke(20x10x2)");
                System.out.println(skurPlanke.getPrice());
            
>>>>>>> 601390a46030f0f477a94b0e5499af4730667eed
    }
    
            
    
}
