/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.CarportException;
import FunctionLayer.User;
import java.util.ArrayList;
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
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {
        String search = request.getParameter("search");
        ArrayList<User> allUsers = UserMapper.getAllUsers();
        ArrayList<String> allEmails = new ArrayList();

        for (int i = 0; i < allUsers.size(); i++) {
            allEmails.add(allUsers.get(i).getEmail());
        }

        if (allEmails.contains(search)) {

            User searchUser = LogicFacade.getUserByEmail(search);
            request.setAttribute("searchUser", searchUser);
        } else {
            request.setAttribute("message", "User not found");
        }

        return "/WEB-INF/" + "employeeorder";
    }
}
