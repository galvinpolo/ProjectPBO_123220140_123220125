/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Kos;

import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ACER
 */
public class ModelTableKos extends AbstractTableModel{
    
    List<ModelKos> daftarKos;
    
    String kolom[] = {"ID","Nama","Alamat","No Telp","Bulan","Biaya"};
    
    public ModelTableKos(List<ModelKos> daftarKos){
        this.daftarKos = daftarKos;
    }

    @Override
    public int getRowCount() {
        return daftarKos.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return daftarKos.get(rowIndex).getId();
            case 1:
                return daftarKos.get(rowIndex).getNama();
            case 2:
                return daftarKos.get(rowIndex).getAlamat();
            case 3:
                return daftarKos.get(rowIndex).getTelp();
            case 4:
                return daftarKos.get(rowIndex).getBulan();
            case 5:
                return daftarKos.get(rowIndex).getBiaya();
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
    daftarKos.remove(selectedRow);
    
    // Memberi tahu tabel bahwa baris telah dihapus
    fireTableRowsDeleted(selectedRow, selectedRow);
    }

}
