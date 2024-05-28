/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Kos;

import Model.Kos.ModelKos;
import Model.Kos.interfaceDAOKos;
import connector.connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ACER
 */

public class DAOKos implements interfaceDAOKos{
    @Override
    public void insert(ModelKos k){
        try{
            String query = "INSERT INTO anak_kos (nama, alamat, no_telp, bulan, biaya) VALUES (?,?,?,?,?);";
            ModelKos dk = new ModelKos();
            PreparedStatement statement;
            statement = connect.connection().prepareStatement(query);
            statement.setString(1, k.getNama());
            statement.setString(2, k.getAlamat());
            statement.setString(3, k.getTelp());
            statement.setInt(4, k.getBulan());            
            statement.setInt(5, k.hitungBiaya());
            
            statement.executeUpdate();
            
     
            
            statement.close();
        }catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
    }
    
    @Override
    public void update(ModelKos k) {
        try {
            String query = "UPDATE anak_kos SET nama=?, alamat=?, no_telp=?, bulan=?, biaya=? WHERE id=?;";
            
            PreparedStatement statement;
            statement = connect.connection().prepareStatement(query);
            statement.setString(1, k.getNama());
            statement.setString(2, k.getAlamat());
            statement.setString(3, k.getTelp());
            statement.setInt(4, k.getBulan());
            statement.setInt(5, k.hitungBiaya());
            statement.setInt(6, k.getId());
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }
    
    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM anak_kos WHERE id=?;";
            
            PreparedStatement statement;
            statement = connect.connection().prepareStatement(query);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }
    
    @Override
    public List<ModelKos> getAll() {
        List<ModelKos> listKos = null;
            try {
            listKos = new ArrayList<>();
            
            Statement statement = connect.connection().createStatement();
            
            String query = "SELECT * FROM anak_kos;";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
              
                ModelKos ko = new ModelKos();
                
                ko.setId(resultSet.getInt("id"));
                ko.setNama(resultSet.getString("nama"));
                ko.setAlamat(resultSet.getString("alamat"));
                ko.setTelp(resultSet.getString("no_telp"));
                ko.setBulan(resultSet.getInt("bulan"));
                ko.setBiaya(resultSet.getInt("biaya"));
    
                listKos.add(ko);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listKos;
    }
    
    @Override
    public boolean hapusData(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
