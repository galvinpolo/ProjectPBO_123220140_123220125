/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Kos.DAOKos;
import java.util.List;
import java.util.ArrayList;
import Model.Kos.*;
import connector.*;
import frame.kos;
import javax.swing.JOptionPane;
/**
 *
 * @author ACER
 */
public class controllerKos {
    kos frame;
    interfaceDAOKos impdatakos;
    List<ModelKos> dk;
    
    public controllerKos(kos frame){
    this.frame = frame;
    impdatakos = new DAOKos();
    dk = impdatakos.getAll();
    }
    public void isitabel (){
        dk = impdatakos.getAll();
        ModelTableKos mk = new ModelTableKos(dk);
        frame.getTabelkos().setModel(mk);
    }
    
    public void hapusData(int id) {
         impdatakos.delete(id);
        
        // Refresh tampilan tabel setelah penghapusan berhasil
        isitabel();
    }
 
    public void updateData(ModelKos k) {
        impdatakos.update(k);
        isitabel(); // Refresh the table data
}
    
}
