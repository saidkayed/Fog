/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.CarportException;
import FunctionLayer.LogicFacade;
import FunctionLayer.User;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tobbe
 */
public class SystemTest extends Command {

    public SystemTest() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException, IOException {
        User user = LogicFacade.login("SystemTester", "SystemTester");
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "/WEB-INF/" + "customerchoice";
    }
    
}
