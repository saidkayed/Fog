package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("logout", new Logout());
        commands.put("makeorder", new MakeOrder());
        commands.put("orderpage", new OrderPage());
        commands.put("viewsvg", new ViewSvg());
        commands.put("viewordersemp", new ViewOrdersEmp());
        commands.put("vieworderscustomer", new ViewOrdersCustomer());
        commands.put("sendorder", new SendOrder());
        commands.put("deleteorder", new DeleteOrder());
        commands.put("home", new Home());
        commands.put("search", new EmpSearch());

    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException;

}
