/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.CarportException;
import FunctionLayer.Materials;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sidad
 */
public class MaterialsMapper {

    public static void addMaterial(Materials mat) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `materials` (name, price, length, description) VALUES ( ?, ?, ? ,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, mat.getName());
            ps.setInt(2, mat.getPrice());
            ps.setString(3, mat.getLength());
            ps.setString(4, mat.getDescription());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            mat.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());

        }
    }

    public static ArrayList<Materials> getAllMaterials() throws CarportException {
        ArrayList<Materials> allMaterials = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "Select * from materials";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("materialid");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String length = rs.getString("length");
                String description = rs.getString("description");

                Materials mat = new Materials(name, price, length, description);

                mat.setId(id);

                allMaterials.add(mat);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
        return allMaterials;
    }

    public static void deleteMaterialById(int materialid) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "Delete from `materials` where materialid = ?";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, materialid);
            st.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }

    }

    public static void editMateriale() {

    }

    public static Materials getMaterialByName(String name) throws CarportException {
        Materials mat = null;
        try {
            Connection con = Connector.connection();
            String SQL = "select * from `materials` where name = ?";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("materialid");
                int price = rs.getInt("price");
                String length = rs.getString("length");
                String description = rs.getString("description");

                mat = new Materials(name, price, length, description);
                mat.setId(id);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());

        }
        return mat;
    }

}
