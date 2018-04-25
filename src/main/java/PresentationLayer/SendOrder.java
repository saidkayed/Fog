/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tobbe
 */
public class SendOrder extends Command {

    public SendOrder() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        
        int orderid =  Integer.parseInt(request.getParameter("orderid"));
        
        LogicFacade.sendOrderById(orderid);
        return "/WEB-INF/" + "employeeorder";
    }
    
}
