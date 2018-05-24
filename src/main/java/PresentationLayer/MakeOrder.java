/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.CarportException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.Date;
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
        Date date = new Date();
        String finalDate = date.toString();
        
        String status = "Pending";
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        Order order = new Order(user.getId(), width, length ,height, roof, shed, finalDate, status);
        
        LogicFacade.createOrder(user, order);
        
        
        
        return "/WEB-INF/" + user.getRole() + "page";
    }
    
}
