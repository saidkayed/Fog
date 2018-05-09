/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Materials;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SA
 */
public class AddMaterials extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String name = request.getParameter("name");
        String stringPrice = request.getParameter("price");
        
        if(name.isEmpty() || stringPrice.isEmpty()){
            String message = "Please fill out both forms when adding Materials";
            request.setAttribute("message", message);
            return "/WEB-INF/" + "addmaterial";
        } else {
        int price = Integer.parseInt(request.getParameter("price"));
        
        Materials mat = new Materials( name, price);
        
        LogicFacade.addMaterial(mat);
    }
        return "/WEB-INF/" + "employeviewmaterials";
    }
}
