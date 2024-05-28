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
import frame.Tambahkos;
/**
 *
 * @author ACER
 */
public class ControllerTambahKos {
    Tambahkos frame;
    interfaceDAOKos impdatakos;
    List<ModelKos> dk;
    
    public ControllerTambahKos(Tambahkos frame){
    this.frame = frame;
    impdatakos = new DAOKos();
    dk = impdatakos.getAll();
    }
    public void insert(){
     ModelKos dk = new ModelKos();
     dk.setNama(frame.getNama().getText());
     dk.setAlamat(frame.getAlamat().getText());
     dk.setTelp(frame.getNo_tlp().getText());
     dk.setBulan(Integer.parseInt(frame.getBulan().getText()));
     dk.setBiaya(dk.hitungBiaya());
     impdatakos.insert(dk);
     
    }
}
