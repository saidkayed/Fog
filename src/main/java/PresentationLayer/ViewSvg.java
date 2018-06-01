/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.CarportException;
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
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {
      
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        int height = Integer.parseInt(request.getParameter("height"));
        String roof = request.getParameter("roof");
        String shed = request.getParameter("shed");
        
        

        request.setAttribute("height", height);
        request.setAttribute("width", width);
        request.setAttribute("length", length);
        request.setAttribute("roof", roof);
        if(!shed.equals("without")){
        request.setAttribute("shed", shed);
        }
        return "/WEB-INF/" + "viewsvg";
        
        }
}

