/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import connector.connect;
/**
 *
 * @author ACER
 */
public class controlleredit {
    public static void update(String id, String nama, String alamat, String no_telp, int bulan, int biaya) {
        // Query SQL untuk melakukan pembaruan data
        String sql = "UPDATE nama_tabel SET nama=?, alamat=?, no_telp=?, bulan=?, biaya=? WHERE id=?";
        
        try (
            // Menggunakan try-with-resources agar sumber daya tertutup secara otomatis
            Connection con = connect.connection(); // Mendapatkan koneksi menggunakan metode connection dari connect.java
            PreparedStatement stmt = con.prepareStatement(sql);
        ) {
            // Mengatur nilai parameter pada statement SQL
            stmt.setString(1, nama);
            stmt.setString(2, alamat);
            stmt.setString(3, no_telp);
            stmt.setInt(4, bulan);
            stmt.setInt(5, biaya);
            stmt.setString(6, id);
            
            // Menjalankan kueri pembaruan
            int rowsAffected = stmt.executeUpdate();
            
            // Memeriksa apakah pembaruan berhasil
            if (rowsAffected > 0) {
                System.out.println("Data berhasil diperbarui");
            } else {
                System.out.println("Gagal memperbarui data");
            }
        } catch (SQLException ex) {
            // Menangani eksepsi yang mungkin terjadi saat menjalankan kueri SQL
            ex.printStackTrace();
        }
    }
}
