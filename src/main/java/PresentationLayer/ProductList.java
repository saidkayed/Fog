/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.CarportCalculator;
import FunctionLayer.CarportException;
import FunctionLayer.Materials;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tobbe
 */
public class ProductList extends Command {

    public ProductList() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {
        CarportCalculator car = new CarportCalculator();
        int orderid = Integer.parseInt(request.getParameter("orderid"));
        ArrayList<Materials> materials = car.calculator(orderid);
        
        request.setAttribute("materials", materials);
        return "/WEB-INF/" + "productlist";
    }
    
}
