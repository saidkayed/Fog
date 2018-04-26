/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sidad
 */
public class Home extends Command {

    public Home() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
          HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return "/WEB-INF/" + user.getRole() + "page";
    }
    
}
