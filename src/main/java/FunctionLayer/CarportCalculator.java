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
        
        //vores planker er 20*10*2 og 20*10*5
        int spær5Amount;
        

        //planker til carport omkreds(width og length kommer aldrig under 2)
        int plank5Amount = 4;
        
        Materials planke5 = LogicFacade.getMaterialByName("Planke(20x10x5)");
        double plankePris = planke5.getPrice()*plank5Amount;
        
        Materials finalPlanke = new Materials(planke5.getName(), planke5.getLength(), plank5Amount, "stk", planke5.getDescription(), plankePris);
        allMaterials.add(finalPlanke);
        
        
        //spær
        spær5Amount = spærCalculator(length);
        
        Materials spær = LogicFacade.getMaterialByName("Spaer(20x10x5)");
        double spærPris = spær.getPrice()*spær5Amount;
        
        Materials finalSpær = new Materials(spær.getName(), spær.getLength(), spær5Amount, "stk", spær.getDescription(), spærPris);
        allMaterials.add(finalSpær);
        
        
        //stolper
        double stolpeHeight = stolpeHeightCalculator(height);
        int stolpeAmount = stolpeCalculator(length);
        
        Materials stolpe = LogicFacade.getMaterialByName("Stolpe");
        double stolpePris = stolpe.getPrice()*stolpeAmount;
        
        Materials finalStolpe = new Materials("Stolpe", stolpe.getLength(), stolpeAmount, "stk", stolpe.getDescription(), stolpePris);
        allMaterials.add(finalStolpe);
        
        
        //roof
        double roofArea;
        if (stringRoof.equals("fladt")){
        //roof fladt
        roofArea = ((length*width)/10000);
        
        Materials roof = LogicFacade.getMaterialByName("Trapez Plade");
        double roofPrice = roof.getPrice()*roofArea;
        
        Materials finalRoof = new Materials("Trapez Plade", roof.getLength(), Math.ceil(roofArea), "stk", roof.getDescription(), Math.ceil(roofPrice));
        allMaterials.add(finalRoof);
        
        } else {   
        //planker til tag med rejsning
        double hypotenuse = (width/2) / Math.cos(20);
        double højdeKatete = (width/2) * Math.tan(20);
        
        double roofPlank2Amount = højdeKatete * spær5Amount;
        double roofPlank5Amount = roofPlank2Amount *2;

        //trapezplade til tag med rejsning
        roofArea = (((length*hypotenuse)*2)/10000);
        
        Materials roof = LogicFacade.getMaterialByName("Trapez Plade");
        double roofPrice = roof.getPrice()*roofArea;
        
        Materials finalRoof = new Materials("Trapez Plade", roof.getLength(), Math.ceil(roofArea), "stk", roof.getDescription(), Math.ceil(roofPrice));
        allMaterials.add(finalRoof);
        
        }
        
        //shed
        //shed door = 210 høj 70 bred
        if(!stringShed.equals("withoutshed")){
            int skurPlank;
            int door = (210/20) * 70;
            if(stringShed.equals("withshed1x1")){
                skurPlank = (((height/20) *100*4) / 2) - door;
                
                Materials skurPlanke = LogicFacade.getMaterialByName("Skur planke(20x10x2)");
                double skurPlankePris = skurPlanke.getPrice() * (skurPlank/200);
                
                Materials finalSkurPlanke = new Materials("Skur planke(20x10x2)", skurPlanke.getLength(), skurPlank/200, "stk", skurPlanke.getDescription(), skurPlankePris);
                allMaterials.add(finalSkurPlanke);
            } else {
                skurPlank = ((height/20) *200*4) - door;
                
                Materials skurPlanke = LogicFacade.getMaterialByName("Skur planke(20x10x2)");
                double skurPlankePris = skurPlanke.getPrice() * (skurPlank/200);
                
                Materials finalSkurPlanke = new Materials("Skur planke(20x10x2)", skurPlanke.getLength(), skurPlank/200, "stk", skurPlanke.getDescription(), Math.ceil(skurPlankePris));
                allMaterials.add(finalSkurPlanke);
            }
            Materials shedDoor = LogicFacade.getMaterialByName("Skur doer");
            double shedDoorPrice = shedDoor.getPrice();
            
            Materials finalShedDoor = new Materials("Skur doer", shedDoor.getLength(), 1, "stk", shedDoor.getDescription(), shedDoor.getPrice());
            allMaterials.add(finalShedDoor);
            
            
        }

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
            stolpeAmount = (length/200) *2;
        } else {
            stolpeAmount = (length/200 + 1 )*2;
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

