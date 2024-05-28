/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Kos;

import java.util.List;
/**
 *
 * @author ACER
 */
public interface interfaceDAOKos {
    public void insert(ModelKos k);
    public void update(ModelKos k);
    public void delete(int id);
    
    public List<ModelKos>getAll();

    public boolean hapusData(String id);
}
