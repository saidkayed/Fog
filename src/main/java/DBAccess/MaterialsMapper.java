/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Materials;
import FunctionLayer.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sidad
 */
public class MaterialsMapper {

    public static void createMateriale(int id, String name, int price) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `order` (id, name, price) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, price);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

    }

    public static ArrayList<Materials> getAllMateriales() throws LoginSampleException {
        ArrayList<Materials> allMaterials = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "Select * from materials";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");

                Materials mat = new Materials(id, name, price);

                allMaterials.add(mat);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return allMaterials;
    }

    public static void deleteMateriale() {

    }

    public static void editMateriale() {

    }

}
