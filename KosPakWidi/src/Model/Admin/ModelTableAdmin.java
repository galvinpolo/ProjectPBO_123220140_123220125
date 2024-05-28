/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Admin;

import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ACER
 */
public class ModelTableAdmin extends AbstractTableModel{
    List<ModelAdmin> daftarAdmin;
    
    String kolom[] = {"ID","Nama","Email"};
    
    public ModelTableAdmin(List<ModelAdmin> daftarAdmin){
        this.daftarAdmin = daftarAdmin;
    }

    @Override
    public int getRowCount() {
        return daftarAdmin.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return daftarAdmin.get(rowIndex).getId();
            case 1:
                return daftarAdmin.get(rowIndex).getNama();
            case 2:
                return daftarAdmin.get(rowIndex).getEmail();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return kolom[columnIndex];
    }

    public void removeRow(int selectedRow) {
         // Hapus baris dari daftar hewan berdasarkan indeks baris yang dipilih
    daftarAdmin.remove(selectedRow);
    
    // Memberi tahu tabel bahwa baris telah dihapus
    fireTableRowsDeleted(selectedRow, selectedRow);
    }
}
