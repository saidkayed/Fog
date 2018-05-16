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
    
        ArrayList<Materials> allMaterials = new ArrayList();
        int screws;
        double topScrews;
        
        
    public ArrayList<Materials> calculator(int orderid) throws LoginSampleException{
       
        Order order = LogicFacade.getOrderById(orderid);
        
        int width = order.getWidth();
        int length = order.getLength();
        int height = order.getHeight();
        String stringRoof = order.getRoof();
        String stringShed = order.getShed();
        
        plankeCalculator();
        int spær5Amount = spærCalculator(length);
        stolpeCalculator(length, height);
        roofCalculator(length, height, width, stringRoof, spær5Amount);
        shedCalculator(stringShed, height);
        
        //vores planker er 20*10*2 og 20*10*5
        return allMaterials;
    }
        
        private void plankeCalculator() throws LoginSampleException{
        //planker til carport omkreds(width og length kommer aldrig under 2)
        int plank5Amount = 4;
        screws = 16;
        
        Materials planke5 = LogicFacade.getMaterialByName("Planke(20x10x5)");
        double plankePris = planke5.getPrice()*plank5Amount;
        
        Materials finalPlanke = new Materials(planke5.getName(), planke5.getLength(), plank5Amount, "stk", planke5.getDescription(), plankePris);
        allMaterials.add(finalPlanke);
        }
        
        
        
        
        
        private int spærCalculator(int length) throws LoginSampleException{
        //spær, bruges kun 5 meters spærplanker
        int spær5Amount = spærAmountCalculator(length);
        screws += spær5Amount * 2;
        
        Materials spær = LogicFacade.getMaterialByName("Spaer(20x10x5)");
        double spærPris = spær.getPrice()*spær5Amount;
        
        Materials finalSpær = new Materials(spær.getName(), spær.getLength(), spær5Amount, "stk", spær.getDescription(), spærPris);
        allMaterials.add(finalSpær);
        return spær5Amount;
        }
        
        
        
        
        
        private void stolpeCalculator(int length, int height) throws LoginSampleException{
        //stolper, graves 80-90cm ned hvis højden er under 1,8m. 1m hvis over 1,8m
        double stolpeHeight = stolpeHeightCalculator(height) / 100.0;
        String stringStolpeHeight = String.valueOf(stolpeHeight);
        int stolpeAmount = stolpeAmountCalculator(length);
        screws += stolpeAmount *4;
        
        Materials stolpe = LogicFacade.getMaterialByName("Stolpe");
        double stolpePris = stolpe.getPrice()*stolpeAmount;
        
        Materials finalStolpe = new Materials("Stolpe", stringStolpeHeight + " meter", stolpeAmount, "stk", stolpe.getDescription(), stolpePris);
        allMaterials.add(finalStolpe);
        }
        
        
        
        
        
        private void roofCalculator(int length, int height, int width, String stringRoof, int spær5Amount) throws LoginSampleException{
        //roof, skældnes mellem fladt og rejsning. Hvis tag har rejsning udregnes planker til støtte samt tagareal
        //Planker af 2 meter bruges til højde support, planker af 5 meter bruges til støtte langs tag
        //Højde support og tag support ud fra hvert spær
        double roofArea;
        if (stringRoof.equals("fladt")){
        //roof fladt
        roofArea = ((length*width)/10000);
        topScrews = Math.ceil(roofArea) * 4;
        
        Materials roof = LogicFacade.getMaterialByName("Trapez Plade");
        double roofPrice = roof.getPrice()*roofArea;
        
        Materials finalRoof = new Materials("Trapez Plade", roof.getLength(), Math.ceil(roofArea), "stk", roof.getDescription(), Math.ceil(roofPrice));
        allMaterials.add(finalRoof);
        
        } else {   
        //planker til tag med rejsning,
        double angleToRaidans = Math.toRadians(20);
        
        double hypotenuse = (width/2) / Math.cos(angleToRaidans);
        double højdeKatete = (width/2) * Math.tan(angleToRaidans);
        
        double roofPlank5Amount;
        double roofPlank2Amount;
        
        if(højdeKatete > 200){
            roofPlank5Amount = spær5Amount;
            roofPlank5Amount += roofPlank5Amount*2;
            screws += roofPlank5Amount * 4;
            
            
        Materials roofPlank5 = LogicFacade.getMaterialByName("Tag planke(20x10x5)");
        double roofPlank5Price = roofPlank5.getPrice() * roofPlank5Amount;
        
        Materials finalRoofPlank5 = new Materials("Tag planke(20x10x5)", roofPlank5.getLength(), roofPlank5Amount, "stk", roofPlank5.getDescription(), Math.ceil(roofPlank5Price));
        allMaterials.add(finalRoofPlank5);
        
        } else {
            
            roofPlank2Amount = spær5Amount;
            roofPlank5Amount = roofPlank2Amount*2;
            screws += (roofPlank5Amount *4) + (roofPlank2Amount * 4);
            
        Materials roofPlank2 = LogicFacade.getMaterialByName("Tag planke(20x10x2)");
        double roofPlank2Price = roofPlank2.getPrice() * roofPlank2Amount;
        
        Materials finalRoofPlank2 = new Materials("Tag planke(20x10x2)", roofPlank2.getLength(), roofPlank2Amount, "stk", roofPlank2.getDescription(), Math.ceil(roofPlank2Price));
        allMaterials.add(finalRoofPlank2);
        
        Materials roofPlank5 = LogicFacade.getMaterialByName("Tag planke(20x10x5)");
        double roofPlank5Price = roofPlank5.getPrice() * roofPlank5Amount;
        
        Materials finalRoofPlank5 = new Materials("Tag planke(20x10x5)", roofPlank5.getLength(), roofPlank5Amount, "stk", roofPlank5.getDescription(), Math.ceil(roofPlank5Price));
        allMaterials.add(finalRoofPlank5);
        }

        //trapezplade til tag med rejsning
        roofArea = (((length*hypotenuse)*2)/10000);
        topScrews = Math.ceil(roofArea) * 4;
        
        Materials roof = LogicFacade.getMaterialByName("Trapez Plade");
        double roofPrice = roof.getPrice()*roofArea;
        
        Materials finalRoof = new Materials("Trapez Plade", roof.getLength(), Math.ceil(roofArea), "stk", roof.getDescription(), Math.ceil(roofPrice));
        allMaterials.add(finalRoof);
        
        }
        }
        
        
        
        
        private void shedCalculator(String stringShed, int height) throws LoginSampleException{
        //Skur planker udregnes og døren trækkes fra. Bruges planker af 2 meters længde.
        //skur dør = 210 høj 70 bred
        
        if(!stringShed.equals("withoutshed")){
            int skurPlank;
            int door = (210/20) * 70;
            if(stringShed.equals("withshed1x1")){
                skurPlank = (((height/20) *100*4) / 2) - door;
                screws += (skurPlank/100) *4;
                
                Materials skurPlanke = LogicFacade.getMaterialByName("Skur planke(20x10x2)");
                double skurPlankePris = skurPlanke.getPrice() * (skurPlank/200);
                
                Materials finalSkurPlanke = new Materials("Skur planke(20x10x2)", skurPlanke.getLength(), skurPlank/200, "stk", skurPlanke.getDescription(), skurPlankePris);
                allMaterials.add(finalSkurPlanke);
            } else {
                skurPlank = ((height/20) *200*4) - door;
                screws += (skurPlank/200) *4;
                
                Materials skurPlanke = LogicFacade.getMaterialByName("Skur planke(20x10x2)");
                double skurPlankePris = skurPlanke.getPrice() * (skurPlank/200);
                
                Materials finalSkurPlanke = new Materials("Skur planke(20x10x2)", skurPlanke.getLength(), skurPlank/200, "stk", skurPlanke.getDescription(), Math.ceil(skurPlankePris));
                allMaterials.add(finalSkurPlanke);
            }
            Materials shedDoor = LogicFacade.getMaterialByName("Skur doer");
            
            Materials finalShedDoor = new Materials("Skur doer", shedDoor.getLength(), 1, "stk", shedDoor.getDescription(), shedDoor.getPrice());
            allMaterials.add(finalShedDoor);
            
            
        }
        
        Materials sscrews = LogicFacade.getMaterialByName("Screws");
        double screwPrice = sscrews.getPrice() * screws;
        
        Materials finalScrews = new Materials("Screws", sscrews.getLength(), screws, "stk", sscrews.getDescription(), screwPrice);
        allMaterials.add(finalScrews);
        
        Materials ttopScrews = LogicFacade.getMaterialByName("Top Screws");
        double topScrewPrice = ttopScrews.getPrice() * topScrews;
        
        Materials finalTopScrews = new Materials("Top Screws", ttopScrews.getLength(), topScrews, "stk", ttopScrews.getDescription(), topScrewPrice);
        allMaterials.add(finalTopScrews);
        }
        
    
    
    private static int spærAmountCalculator(int length) throws LoginSampleException{
        int spærAmount;
        
        if(length%100 == 0){
            spærAmount = length/100; 
        } else {
            spærAmount = length/100 + 1;
        } return spærAmount;
    }
    
    private static int stolpeAmountCalculator(int length) throws LoginSampleException{
        int stolpeAmount;
        
        
        if(length%200 == 0){
            stolpeAmount = (length/200) *2;
        } else {
            stolpeAmount = (length/200 + 1 )*2;
        } return stolpeAmount;
    }
    private static int stolpeHeightCalculator(int height) throws LoginSampleException{
        int stolpeHeight;
        if (height-20 < 180){
            stolpeHeight = height-20+80;
        } else {
            stolpeHeight = height-20+100;
        } return stolpeHeight;
    }

}

