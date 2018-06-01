/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.CarportException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tobbe
 */
public class BackToIndex extends Command {

    public BackToIndex() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("user", null);
        return "index";
    }
    
}
