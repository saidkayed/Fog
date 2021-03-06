/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.CarportException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tobbe
 */
public class DeleteOrder extends Command {

    public DeleteOrder() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {
        
         int orderid =  Integer.parseInt(request.getParameter("orderid"));
        LogicFacade.deleteOrderById(orderid);
        
        return "/WEB-INF/" + "employeeorder";
    }
    
}
