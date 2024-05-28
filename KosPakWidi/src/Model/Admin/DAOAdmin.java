/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Admin;

import connector.connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ACER
 */
public class DAOAdmin implements interfaceDAOAdmin{
    @Override
    public List<ModelAdmin> getAll() {
        List<ModelAdmin> listAdmin = null;
            try {
            listAdmin = new ArrayList<>();
            
            Statement statement = connect.connection().createStatement();
            
            String query = "SELECT * FROM admin;";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
              
                ModelAdmin ad = new ModelAdmin();
                
                ad.setId(resultSet.getInt("id"));
                ad.setNama(resultSet.getString("nama"));
                ad.setEmail(resultSet.getString("email"));
                
    
                listAdmin.add(ad);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listAdmin;
    }
}
