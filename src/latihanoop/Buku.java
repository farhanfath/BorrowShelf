/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihanoop;

/**
 *
 * @author farha
 */
public class Buku {
    
    private int ID;
    private String Penulis;
    private String Judul;
    private int Stok;
    
    public Buku(int ID, String Penulis, String Judul, int Stok) {
        this.ID = ID;
        this.Penulis = Penulis;
        this.Judul = Judul;
        this.Stok = Stok;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the Penulis
     */
    public String getPenulis() {
        return Penulis;
    }

    /**
     * @param Penulis the Penulis to set
     */
    public void setPenulis(String Penulis) {
        this.Penulis = Penulis;
    }

    /**
     * @return the Judul
     */
    public String getJudul() {
        return Judul;
    }

    /**
     * @param Judul the Judul to set
     */
    public void setJudul(String Judul) {
        this.Judul = Judul;
    }

    /**
     * @return the Stok
     */
    public int getStok() {
        return Stok;
    }

    /**
     * @param Stok the Stok to set
     */
    public void setStok(int Stok) {
        this.Stok = Stok;
    }
    
    public boolean cekStok() {
        return Stok > 0;
    }
    
    public void decreaseDipinjam() {
        Stok--;
    }
    
    public void increaseDipinjam() {
        Stok++;
    }
    
    public String printInfo() {
        return "ID Buku\t:" + ID + "\n" +
                "Judul\t:" + Judul + "\n" +
                "Penulis\t:" + Penulis + "\n" +
                "Tersedia\t:" + Stok + "\n";
    }
}
