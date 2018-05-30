/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbTest;

import DBAccess.Connector;
import DBAccess.UserMapper;
import FunctionLayer.CarportCalculator;
import FunctionLayer.CarportException;
import FunctionLayer.Materials;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class dbTest {

    private static Connection testConnection;
    private static String USER = "tob";
    private static String USERPW = "1234";
    private static String DBNAME = "fogdbtest";
    private static String HOST = "159.65.126.99";

    @Before
    public void setUp() {
        try {
            if (testConnection == null) {
                String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
                Class.forName("com.mysql.jdbc.Driver");

                testConnection = DriverManager.getConnection(url, USER, USERPW);
                Connector.setConnection(testConnection);
            }

            //reset
            try (Statement stmt = testConnection.createStatement()) {
                stmt.execute("Drop table if exists `fogdbtest`.`order`");
                stmt.execute("Drop table if exists `fogdbtest`.`user`");
                stmt.execute("Drop table if exists `fogdbtest`.`materials`");

                stmt.execute("CREATE TABLE IF NOT EXISTS `fogdbtest`.`user` (\n"
                        + "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n"
                        + "  `email` VARCHAR(90) NOT NULL,\n"
                        + "  `password` VARCHAR(45) NOT NULL,\n"
                        + "  `phone` INT(11) NOT NULL,\n"
                        + "  `role` VARCHAR(45) NOT NULL DEFAULT 'customer',\n"
                        + "  PRIMARY KEY (`id`),\n"
                        + "  UNIQUE INDEX `email_UNIQUE` (`email` ASC))\n"
                        + "ENGINE = InnoDB\n"
                        + "AUTO_INCREMENT = 5\n"
                        + "DEFAULT CHARACTER SET = latin1;");

                stmt.execute("INSERT INTO `user` VALUES \n"
                        + "(1,'123','123',12341234,'customer'),\n"
                        + "(3,'456','456',23452345,'employee');");

                stmt.execute("CREATE TABLE IF NOT EXISTS `fogdbtest`.`materials` (\n"
                        + "  `materialid` INT(11) NOT NULL AUTO_INCREMENT,\n"
                        + "  `name` VARCHAR(45) NOT NULL,\n"
                        + "  `price` INT(11) NOT NULL,\n"
                        + "  `length` VARCHAR(45)NULL,\n"
                        + "  `description` VARCHAR(45)NULL,\n"
                        + "  PRIMARY KEY (`materialid`));");

                stmt.execute("INSERT INTO `materials` VALUES \n"
                        + "('1', 'Plank(20x10x5)', '20', '5 meters', 'Plank, 5 meters long used for frame'),\n"
                        + "('2', 'Rafter(20x10x5)', '20', '5 meters', 'Rafter is used to support'),\n"
                        + "('3', 'Pillar', '30', 'arbitrary', 'Pillar with arbitrary length'),\n"
                        + "('4', 'Trapezoidal plate', '30', 'm2', 'Trapezoidal plate used for roof price pr m2'),\n"
                        + "('5', 'Roof Plank(20x10x5)', '20', 'meter', 'Roof Plank used for roof support'),\n"
                        + "('6', 'Roof Plank(20x10x2)', '10', 'meter', 'Roof Plank used for roof support'),\n"
                        + "('7', 'Shed Plank(20x10x2)', '10', 'meter', 'Shed planks used for shed'),\n"
                        + "('8', 'Shed door', '1000', '210cm x 70cm', 'Shed door for the shed'),\n"
                        + "('9', 'Screws', '1', '5cm', 'Screws for the planks'),\n"
                        + "('10', 'Top Screws', '1', '5cm', 'Screws for roof plates');");

                stmt.execute("CREATE TABLE IF NOT EXISTS `fogdbtest`.`order` (\n"
                        + "  `orderid` INT(11) NOT NULL AUTO_INCREMENT,\n"
                        + "  `id` INT(11) NOT NULL,\n"
                        + "  `width` INT(11) NOT NULL,\n"
                        + "  `length` INT(11) NOT NULL,\n"
                        + "  `height` INT(11) NOT NULL,\n"
                        + "  `roof` VARCHAR(90) NOT NULL,\n"
                        + "  `shed` VARCHAR(90) NOT NULL,\n"
                        + "  `date` VARCHAR(90) NOT NULL,\n"
                        + "  `status` VARCHAR(45) NOT NULL,\n"
                        + "  PRIMARY KEY (`orderid`),\n"
                        + "  INDEX `id` (`id` ASC),\n"
                        + "  CONSTRAINT `order_ibfk_1`\n"
                        + "    FOREIGN KEY (`id`)\n"
                        + "    REFERENCES `fog`.`user` (`id`))\n"
                        + "ENGINE = InnoDB\n"
                        + "AUTO_INCREMENT = 7\n"
                        + "DEFAULT CHARACTER SET = latin1;");

                stmt.execute("INSERT INTO `order` VALUES\n"
                        + "('1', '1', '300', '500', '300', 'rejsning', 'withshed2x2', 'bla', 'pending');");

            }

        } catch (ClassNotFoundException | SQLException ex) {
            testConnection = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }

    }

    @Test
    public void testSetUpOK() {
        // Tjekker connectiom
        assertNotNull(testConnection);
    }

    @Test
    public void testLogin01() throws CarportException {
        // Tjekker login
        User user = UserMapper.login("123", "123");
        assertTrue(user != null);
    }

    @Test(expected = CarportException.class)
    public void testLogin02() throws CarportException {
        // Tjekker forkert login
        User user = UserMapper.login("123", "forkertpass");
    }

    @Test
    public void testLogin03() throws CarportException {
        // Tjekker rolle
        User user = UserMapper.login("123", "123");
        assertEquals("customer", user.getRole());
    }

    @Test
    public void testCreateUser01() throws CarportException {
        // Laver user og tester login
        User original = new User("bla", "hej", 123, "wizard");
        UserMapper.createUser(original);
        User retrieved = UserMapper.login("bla", "hej");
        assertEquals("wizard", retrieved.getRole());
    }
   
    @Test
    public void testCarportCalculator() throws CarportException {
        //Tester Calculator
        CarportCalculator car = new CarportCalculator();
        ArrayList<Materials> allMaterials;
        allMaterials = car.calculator(1);
        assertFalse(allMaterials.isEmpty());
        assertEquals(10, allMaterials.size());
        assertEquals(5, allMaterials.get(1).getAmount(), 0.0);
        assertEquals(16, allMaterials.get(5).getAmount(), 0.0);
    }
}
