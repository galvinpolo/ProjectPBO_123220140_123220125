/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.util.List;
import java.util.ArrayList;
import Model.Admin.*;
import connector.*;
import frame.admin;
import javax.swing.JOptionPane;
/**
 *
 * @author ACER
 */
public class ControllerAdmin {
    admin frame;
    interfaceDAOAdmin impdataadmin;
    List<ModelAdmin> da;
    
    public ControllerAdmin(admin frame){
    this.frame = frame;
    impdataadmin = new DAOAdmin();
    da = impdataadmin.getAll();
    }
    public void isitabel (){
        da = impdataadmin.getAll();
        ModelTableAdmin ma = new ModelTableAdmin(da);
        frame.getTabelAdmin().setModel(ma);
    }
}
