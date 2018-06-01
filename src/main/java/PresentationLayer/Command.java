package PresentationLayer;

import FunctionLayer.CarportException;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        
        
        //Login/Registration
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("logout", new Logout());
        commands.put("search", new EmpSearch());
        commands.put("systemtest", new SystemTest());
        
        //Order
        commands.put("makeorder", new MakeOrder());
        commands.put("orderpage", new OrderPage());
        commands.put("viewsvg", new ViewSvg());
        commands.put("sendorder", new SendOrder());
        commands.put("deleteorder", new DeleteOrder());
        commands.put("viewordersemp", new ViewOrdersEmp());
        commands.put("vieworderscustomer", new ViewOrdersCustomer());
        
        //Material
        commands.put("viewmaterials", new ViewMaterials());
        commands.put("deletematerial", new DeleteMaterial());
        commands.put("addmaterials", new AddMaterials());
        commands.put("productlist", new ProductList());
          
        //Navigation
        commands.put("home", new Home());
        commands.put("backtocustomerchoice", new BackToCustomerChoice());
        commands.put("backtoemployeviewmaterials", new BackToEmployeeViewMaterials());
        commands.put("addmaterialnavigation", new AddMaterialNavigation());
        commands.put("backtoindex", new BackToIndex());
   

    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws CarportException, IOException;

}
