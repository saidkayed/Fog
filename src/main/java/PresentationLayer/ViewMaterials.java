/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.CarportException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sercan
 */
public class ViewMaterials extends Command {
    
    public ViewMaterials() {
    }
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {

        return "/WEB-INF/" + "employeeviewmaterials";
    }
}