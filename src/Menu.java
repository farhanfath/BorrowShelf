import java.util.Scanner;

public class Menu {
    
    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    
    public static int menuUtama() {
        System.out.println("\t\tMenu Utama");
        System.out.println("-------------------------------------");
        System.out.println("1. Keanggotaan");
        System.out.println("2. Manajemen Buku");
        System.out.println("3. Peminjaman Buku");
        System.out.println("0. Keluar");
        System.out.println("-------------------------------------");
        System.out.print("Masukkan Pilihan : ");
        return sc.nextInt();
    }
    
    public static int menuKeanggotaan() {
        System.out.println("\t\tMenu Keanggotaan");
        System.out.println("-------------------------------------");
        System.out.println("1. Tambah Anggota");
        System.out.println("2. Hapus Anggota");
        System.out.println("3. Tampilkan Semua Anggota");
        System.out.println("0. Kembali Ke Menu Utama");
        System.out.println("-------------------------------------");
        System.out.print("Masukkan Pilihan : ");
        return sc.nextInt();
    }
    
    public static Anggota tambahAnggota() {
        System.out.print("Masukkan Id : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Masukkan Nama : ");
        String nama = sc.nextLine();
        System.out.print("Masukkan No Ktp : ");
        String ktp = sc.nextLine();
        System.out.print("Masukkan Alamat : ");
        String alamat = sc.nextLine();
        System.out.print("Masukkan Jenis Kelamin : ");
        String jeniskelamin = sc.nextLine();
        return new Anggota(id, nama, ktp, alamat, jeniskelamin);
    }
   
    public static int hapusAnggota() {
        System.out.print("Masukkan id Anggota yang ingin dihapus : ");
        int id = sc.nextInt();
        return id;
    }
    
    public static boolean konfirmasiHapusAnggota(Anggota anggota) {
        System.out.println(anggota.printInfoAnggota());
        sc.nextLine();
        System.out.print("Yakin ingin menghapus anggota ini (y / n) : ");
        String konfirmasi = sc.nextLine();
        return konfirmasi.equals("Y") || konfirmasi.equals("y");
    }
    
    public static int menuBuku() {
        System.out.println("\t\tMenu Manajemen Buku");
        System.out.println("-------------------------------------");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Edit Buku");
        System.out.println("3. Hapus Buku");
        System.out.println("4. Tampilkan Semua Buku");
        System.out.println("0. Kembali Ke Menu Utama");
        System.out.println("-------------------------------------");
        System.out.print("Masukkan Pilihan : ");
        return sc.nextInt();
    }
    
    public static Buku tambahBuku() {
        System.out.print("Masukkan Id Buku : ");
        int idBuku = sc.nextInt();
        sc.nextLine();
        System.out.print("Masukkan Judul Buku : ");
        String judulBuku = sc.nextLine();
        System.out.print("Masukkan Nama Penulis Buku : ");
        String penulisBuku = sc.nextLine();
        System.out.print("Masukkan Jumlah Stok Buku : ");
        int stokBuku = sc.nextInt();
        return new Buku(idBuku, penulisBuku, judulBuku, stokBuku);
    }
    
    public static int editBuku() {
        System.out.print("Masukkan id Buku yang ingin diedit : ");
        int id = sc.nextInt();
        return id;
    }
    
    public static boolean konfirmasiEditBuku(Buku buku) {
        System.out.println(buku.printInfo());
        sc.nextLine();
        System.out.print("Yakin ingin mengedit Buku ini (y / n) : ");
        String konfirmasi = sc.nextLine();
        return konfirmasi.equals("Y") || konfirmasi.equals("y");
    }
    
    public static Buku inputEditBuku() {
        System.out.print("Masukkan Id baru : ");
        int idBuku = sc.nextInt();
        sc.nextLine();
        System.out.print("Masukkan Judul baru : ");
        String judulBuku = sc.nextLine();
        System.out.print("Masukkan Nama Penulis baru : ");
        String penulisBuku = sc.nextLine();
        System.out.print("Masukkan Jumlah Stok baru : ");
        int stokBuku = sc.nextInt();
        return new Buku(idBuku, penulisBuku, judulBuku, stokBuku);
    }
    
    public static int hapusBuku() {
        System.out.print("Masukkan id Buku yang ingin dihapus : ");
        int id = sc.nextInt();
        return id;
    }
    
    public static boolean konfirmasiHapusBuku(Buku buku) {
        System.out.println(buku.printInfo());
        sc.nextLine();
        System.out.print("Yakin ingin menghapus Buku ini (y / n) : ");
        String konfirmasi = sc.nextLine();
        return konfirmasi.equals("Y") || konfirmasi.equals("y");
    }
    
    public static int menuPeminjaman() {
        System.out.println("\t\tMenu Peminjaman Buku");
        System.out.println("-------------------------------------");
        System.out.println("1. Pinjam Buku");
        System.out.println("2. Lihat Buku yang Dipinjam");
        System.out.println("0. Kembali Ke Menu Utama");
        System.out.println("-------------------------------------");
        System.out.print("Masukkan Pilihan : ");
        return sc.nextInt();
    }
    
    public static int inputBukuId() {
        System.out.print("Masukkan Id Buku yang ingin dipinjam : ");
        int id = sc.nextInt();
        return id;
    }
    
    public static int inputPeminjamId() {
        System.out.print("Masukkan Id Peminjam : ");
        int id = sc.nextInt();
        return id;
    }
}