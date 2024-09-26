/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihanoop;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author farha
 */
public class main {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        ArrayList<Anggota> memberTerdaftar = new ArrayList<Anggota>();
        ArrayList<Buku> bukuTerdaftar = new ArrayList<Buku>();
        ArrayList<BukuDipinjam> bukuDipinjam = new ArrayList<BukuDipinjam>();
        
        int pilihan;
        
        for (int i = 0; i >= 0; i++) {
            pilihan = Menu.menuUtama();
            
            if (pilihan == 0) {
                System.exit(0);
            } else if (pilihan == 1) {
                pilihan = Menu.menuKeanggotaan();
                if (pilihan == 0) {
                    continue;
                } else if (pilihan == 1) {
                    memberTerdaftar.add(Menu.tambahAnggota());
                    System.out.println("-----------------------------------");
                    System.out.println("Anggota Berhasil Ditambahkan!\n");
                    continue;
                } else if (pilihan == 2) {
                    int selectedId = Menu.hapusAnggota();
                    boolean adaId = false;
                    int index = 0;
                    for (int j = 0; j < memberTerdaftar.size(); j++) {
                        if (memberTerdaftar.get(j).getId() == selectedId) {
                            adaId = true;
                            index = j;
                        }
                    }
                    if (adaId) {
                        boolean konfirmasi = Menu.konfirmasiHapusAnggota(memberTerdaftar.get(index));
                        if (konfirmasi) {
                            memberTerdaftar.remove(index);
                            System.out.println("Anggota Berhasil Dihapus");
                            sc.nextLine();
                        } else {
                            System.out.println("Membatalkan");
                            sc.nextLine();
                        }
                    } else {
                        System.out.println("Id Tidak Ditemukan");
                        sc.nextLine();
                    }
                } else if (pilihan == 3) {
                    if (!memberTerdaftar.isEmpty()) {
                        for (int j = 0; j < memberTerdaftar.size(); j++) {
                            System.out.println(memberTerdaftar.get(j).printInfoAnggota());
                            sc.nextLine();
                        }
                    } else {
                        System.out.println("Belum ada anggota yang dapat ditampilkan");
                        sc.nextLine();
                    }
                }
            } else if (pilihan == 2) {
                pilihan = Menu.menuBuku();
                
                if (pilihan == 0) {
                    continue;
                } else if (pilihan == 1) {
                    bukuTerdaftar.add(Menu.tambahBuku());
                    System.out.println("-----------------------------------");
                    System.out.println("Buku Berhasil Ditambahkan!\n");
                    continue;
                } else if (pilihan == 2) {
                    int selectedId = Menu.editBuku();
                    
                    boolean adaId = false;
                    int index = 0;
                    for (int j = 0; j < bukuTerdaftar.size(); j++) {
                        if (bukuTerdaftar.get(j).getID() == selectedId) {
                            adaId = true;
                            index = j;
                        }
                    }
                    if (adaId) {
                        boolean konfirmasi = Menu.konfirmasiEditBuku(bukuTerdaftar.get(index));
                        if (konfirmasi) {
                            Buku book = Menu.inputEditBuku();
                            bukuTerdaftar.get(index).setID(book.getID());
                            bukuTerdaftar.get(index).setPenulis(book.getPenulis());
                            bukuTerdaftar.get(index).setJudul(book.getJudul());
                            bukuTerdaftar.get(index).setStok(book.getStok());
                            System.out.println("Buku Berhasil Di Edit");
                            sc.nextLine();
                        } else {
                            System.out.println("Membatalkan");
                        }
                    } else {
                        System.out.println("Id Buku tidak ditemukan");
                        sc.nextLine();
                    }
                } else if (pilihan == 3) {
                    int selectedId = Menu.hapusBuku();
                    boolean adaId = false;
                    int index = 0;
                    for (int j = 0; j < bukuTerdaftar.size(); j++) {
                        if (bukuTerdaftar.get(j).getID() == selectedId) {
                            adaId = true;
                            index = j;
                        }
                    }
                    if (adaId) {
                        boolean konfirmasi = Menu.konfirmasiHapusBuku(bukuTerdaftar.get(index));
                        if (konfirmasi) {
                            bukuTerdaftar.remove(index);
                            System.out.println("Buku Berhasil Dihapus");
                            sc.nextLine();
                        } else {
                            System.out.println("Membatalkan");
                            sc.nextLine();
                        }
                    } else {
                        System.out.println("Id Tidak Ditemukan");
                        sc.nextLine();
                    }
                } else if (pilihan == 4) {
                    if (!bukuTerdaftar.isEmpty()) {
                        for (int j = 0; j < bukuTerdaftar.size(); j++) {
                            System.out.println(bukuTerdaftar.get(j).printInfo());
                            sc.nextLine();
                        }
                    } else {
                        System.out.println("Belum ada Buku yang dapat ditampilkan");
                        sc.nextLine();
                    }
                }
            } else if (pilihan == 3) {
                pilihan = Menu.menuPeminjaman();
                
                
            }
        }
    }
}
