/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tobbe
 */
public class EmpSearch extends Command {

    public EmpSearch() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
    String search = request.getParameter("search");
    
    User searchUser = LogicFacade.getUserByEmail(search);
    
    request.setAttribute("searchUser", searchUser);
    
    return "/WEB-INF/" + "employeeorder";
    }
    
}
