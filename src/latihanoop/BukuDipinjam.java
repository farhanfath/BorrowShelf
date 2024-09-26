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
    
    public BukuDipinjam(int ID, String Penulis, String Judul, int Stok) {
        super(ID, Penulis, Judul, Stok);
        this.peminjam = new ArrayList<>(); // Inisialisasi daftar peminjam
    }

    public ArrayList<Anggota> getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(ArrayList<Anggota> peminjam) {
        this.peminjam = peminjam;
    }
    
    @Override
    public String printInfo() {
        String str = "";
        for (Anggota anggota : peminjam) {
            str += anggota.getNama() + ", ";
        }
        return "ID Buku\t:" + getID() + "\n" + 
                "Judul Buku\t:" + getJudul() + "\n" +
                "Penulis\t:" + getPenulis() + "\n" +
                "Peminjam\t: " + str + "\n";
    }
}
