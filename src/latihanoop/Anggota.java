package latihanoop;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author farha
 */

public class Anggota extends Person {
    
    public Anggota(int ID, String Nama, String KTP, String Alamat, String JenisKelamin) {
        super(ID, Nama, KTP, Alamat, JenisKelamin);
    }
    
    public String printInfoAnggota() {
        return
                "ID\t:" + getId()+ "\n" +
                "Nama\t:" + getNama()+ "\n" +
                "No.KTP\t:" + getKtp()+ "\n" +
                "ALamat\t:" + getAlamat()+ "\n" +
                "Jenis Kelamin\t:" + getJenisKelamin();
    }
    
}
