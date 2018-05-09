/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.CarportCalculator;
import static FunctionLayer.CarportCalculator.spærCalculator;
import static FunctionLayer.CarportCalculator.stolpeCalculator;
import static FunctionLayer.CarportCalculator.stolpeHeightCalculator;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Materials;
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

        
        Materials planke = LogicFacade.getMaterialByName("Planke(10cm*20cm) (meter pris)");
        
        System.out.println(planke.getPrice());
        //int plankePris = planke.getPrice()*(plankLength/100);
        
        
       
    }
    
}
