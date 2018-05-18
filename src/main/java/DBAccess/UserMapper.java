package DBAccess;

import FunctionLayer.CarportException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * The purpose of UserMapper is to...
 *
 * @author kasper
 */
public class UserMapper {

    public static void createUser(User user) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (email, password, phone, role) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getPhone());
            ps.setString(4, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, phone, role FROM user "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                int phone = rs.getInt("phone");
                User user = new User(email, password, phone, role);
                user.setId(id);
                return user;
            } else {
                throw new CarportException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public static User getUserById(int id) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "select * from user where id=?";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int phone = rs.getInt("phone");

                User user = new User(email, password, phone, role);
                user.setId(id);
                return user;

            } else {
                throw new CarportException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException(ex.getMessage());
        }

    }

    public static User getUserByEmail(String email) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "select * from user where email=?";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                String password = rs.getString("password");
                int id = rs.getInt("id");
                int phone = rs.getInt("phone");

                User user = new User(email, password, phone, role);
                user.setId(id);
                return user;

            } else {
                throw new CarportException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public static ArrayList<User> getAllUsers() throws CarportException {
        ArrayList<User> allUsers = new ArrayList();

        try {
            Connection con = Connector.connection();
            String SQL = "select * from user";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                int id = rs.getInt("id");
                int phone = rs.getInt("phone");

                User user = new User(email, password, phone, role);
                user.setId(id);

                allUsers.add(user);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException(ex.getMessage());
        }
        return allUsers;
    }

    public static int getPhoneByUserId(int id) throws CarportException {
        int phone = 0;

        try {
            Connection con = Connector.connection();
            String SQL = "select phone from user where id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                phone = rs.getInt("phone");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException(ex.getMessage());
        }
        return phone;
    }
}
