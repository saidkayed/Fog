/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.CarportException;
import FunctionLayer.Materials;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SA
 */
public class AddMaterials extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {

        String name = request.getParameter("name");
       
        int price = Integer.parseInt(request.getParameter("price"));
        
        String length = request.getParameter("length");
        
        String description = request.getParameter("description");
        
        Materials mat = new Materials(name, price, length, description);
        
        LogicFacade.addMaterial(mat);
    
        return "/WEB-INF/" + "employeeviewmaterials";
    }
}
