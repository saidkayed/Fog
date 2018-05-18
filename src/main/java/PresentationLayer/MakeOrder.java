/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.CarportException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tobbe
 */
public class MakeOrder extends Command {

    public MakeOrder() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {
        
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        int height = Integer.parseInt(request.getParameter("height"));
        String roof = request.getParameter("roof");
        String shed = request.getParameter("shed");
                
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        LogicFacade.makeOrder(user, width, length, height, roof, shed);
        
        
        
        return "/WEB-INF/" + user.getRole() + "page";
    }
    
}
