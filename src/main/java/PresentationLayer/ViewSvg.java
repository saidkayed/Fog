/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tobbe
 */
public class ViewSvg extends Command {

    public ViewSvg() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        
        String stringWidth = request.getParameter("width");
        String stringLength = request.getParameter("length");
        
        if (!stringWidth.isEmpty() && !stringLength.isEmpty()){
        
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));

        if(width < 200 || length < 200){
            //throw new LoginSampleException("input must be at least 200");
                request.setAttribute("message", "Input must be at least 200");
                return "/WEB-INF/" + "customerchoice";
        }
        
        request.setAttribute("width", width);
        request.setAttribute("length", length);
        return "/WEB-INF/" + "viewsvg";
    }
        request.setAttribute("message", "Please fill out both input forms");
        return "/WEB-INF/" + "customerchoice";
            
        } 
    
}
