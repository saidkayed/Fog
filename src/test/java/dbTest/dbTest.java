/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbTest;

import DBAccess.Connector;
import DBAccess.UserMapper;
import FunctionLayer.CarportException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                stmt.execute("Drop table if exists `fogdbtest`.`user`");
                
                stmt.execute("CREATE TABLE `fogdbtest`.`user` (\n"
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
        // Laver user og tester user
        User original = new User("bla", "hej", 123, "wizard");
        UserMapper.createUser(original);
        User retrieved = UserMapper.login("bla", "hej");
        assertEquals("wizard", retrieved.getRole());
    }
}
