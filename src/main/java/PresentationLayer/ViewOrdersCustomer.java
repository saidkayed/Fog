/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tobbe
 */
public class ViewOrdersCustomer extends Command {

    public ViewOrdersCustomer() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        ArrayList<Order> allOrdersCustomer = LogicFacade.getAllOrdersById(user);

        request.setAttribute("orderscustomer", allOrdersCustomer);

        return "/WEB-INF/" + "customerorder";
    }

}
