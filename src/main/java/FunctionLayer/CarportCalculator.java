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
    
    public static ArrayList<Materials> calculator(int orderid) throws LoginSampleException{
        ArrayList<Materials> allMaterials = new ArrayList();
        Order order = LogicFacade.getOrderById(orderid);
        
        int width = order.getWidth();
        int length = order.getLength();
        int height = order.getHeight();
        String stringRoof = order.getRoof();
        String stringShed = order.getShed();
        
        //vores planker er 20*10*x
        
        //carport omkreds
        double plankLength = (width*2)+(length*2);
        
        //spær
        double spærLength = width-20;
        double spærAmount = spærCalculator(length);
        plankLength += (spærLength*spærAmount);
        
        //stolper
        double stolpeHeight = stolpeHeightCalculator(height);
        double stolpeAmount = stolpeCalculator(length);
        double stolpeLength = stolpeAmount*stolpeHeight;
        
        //roof
        double roofArea = length*width;
        
        
        //Material definition planke
        //Omkreds' planker
        Materials planke = LogicFacade.getMaterialByName("Planke(10cm*20cm) (meter pris)");
        double plankePris = planke.getPrice()*(plankLength/100);
        
        Materials finalPlanke = new Materials("Planke(10cm*20cm) (meter pris)", plankLength/100, plankePris);
        allMaterials.add(finalPlanke);
        
        //Spær
        Materials spær = LogicFacade.getMaterialByName("Spaer(10cm*20cm) (stk)");
        double spærPris = spær.getPrice()*spærAmount;
        
        Materials finalSpær = new Materials("Spaer(10cm*20cm) (stk)", spærAmount, spærPris);
        allMaterials.add(finalSpær);
        
        //Stolpe
        Materials stolpe = LogicFacade.getMaterialByName("Stolpe (10cm*10cm) (stk)");
        double stolpePris = stolpe.getPrice()*stolpeAmount;
        
        Materials finalStolpe = new Materials("Stolpe (10cm*10cm) (stk)", stolpeAmount, stolpePris);
        allMaterials.add(finalStolpe);
        
        //Roof
        Materials roof = LogicFacade.getMaterialByName("Trapez Plade (fladt tag) (pr m2)");
        double roofPrice = roof.getPrice()*(roofArea/10000);
        
        Materials finalRoof = new Materials("Trapez Plade (fladt tag) (pr m2)", roofArea/10000, roofPrice);
        allMaterials.add(finalRoof);
        
        return allMaterials;
    }
    
    public static int spærCalculator(int length) throws LoginSampleException{
        int spærAmount;
        
        if(length%100 == 0){
            spærAmount = length/100; 
        } else {
            spærAmount = length/100 + 1;
        } return spærAmount;
    }
    
    public static int stolpeCalculator(int length) throws LoginSampleException{
        int stolpeAmount;
        
        if(length%200 == 0){
            stolpeAmount = length/200;
        } else {
            stolpeAmount = length/200 + 1;
        } return stolpeAmount;
    }
    public static int stolpeHeightCalculator(int height) throws LoginSampleException{
        int stolpeHeight;
        if (height-20 < 180){
            stolpeHeight = height-20+80;
        } else {
            stolpeHeight = height-20+100;
        } return stolpeHeight;
    }
}
