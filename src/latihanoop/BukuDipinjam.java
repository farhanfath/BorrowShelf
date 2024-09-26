/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihanoop;

import java.util.ArrayList;

/**
 *
 * @author farha
 */
public class BukuDipinjam extends Buku {
    private ArrayList<Anggota> peminjam;
    
    public BukuDipinjam(int ID, String Penulis, String Judul, int Stok, ArrayList<Anggota> peminjam) {
        
        super(ID, Penulis, Judul, Stok);
        this.peminjam = peminjam;
    }

    /**
     * @return the peminjam
     */
    public ArrayList<Anggota> getPeminjam() {
        return peminjam;
    }

    /**
     * @param peminjam the peminjam to set
     */
    public void setPeminjam(ArrayList<Anggota> peminjam) {
        this.peminjam = peminjam;
    }
    
    @Override
    public String printInfo() {
        String str = "";
        for(int i = 0; i < peminjam.size(); i++) {
            str = str + peminjam.get(i).getNama() + ", ";
        }
        return super.printInfo() + "\n" +
                "Peminjam\t:"+ str;
    }
}
