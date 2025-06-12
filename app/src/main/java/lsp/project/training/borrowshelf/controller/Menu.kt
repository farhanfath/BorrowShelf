package lsp.project.training.borrowshelf.controller

import lsp.project.training.borrowshelf.data.Anggota
import lsp.project.training.borrowshelf.data.Buku

object Menu {
  fun menuUtama(): Int {
    println("\t\tMenu Utama")
    println("-------------------------------------")
    println("1. Keanggotaan")
    println("2. Manajemen Buku")
    println("3. Peminjaman Buku")
    println("0. Keluar")
    return inputAngka("Masukkan Pilihan: ", 0..3)
  }

  fun menuKeanggotaan(): Int {
    println("\t\tMenu Keanggotaan")
    println("-------------------------------------")
    println("1. Tambah Anggota")
    println("2. Hapus Anggota")
    println("3. Tampilkan Semua Anggota")
    println("0. Kembali Ke Menu Utama")
    return inputAngka("Masukkan Pilihan: ", 0..3)
  }

  fun tambahAnggota(): Anggota {
    val id = inputAngka("Masukkan Id: ")
    val nama = inputText("Masukkan Nama: ")
    val ktp = inputText("Masukkan No Ktp: ")
    val alamat = inputText("Masukkan Alamat: ")
    val jeniskelamin = inputText("Masukkan Jenis Kelamin: ")
    return Anggota(id, nama, ktp, alamat, jeniskelamin)
  }

  fun hapusAnggota(): Int {
    return inputAngka("Masukkan id Anggota yang ingin dihapus: ")
  }

  fun konfirmasiHapusAnggota(anggota: Anggota): Boolean {
    println(anggota.printInfoAnggota())
    val input = inputText("Yakin ingin menghapus anggota ini (y / n): ")
    return input.equals("y", ignoreCase = true)
  }

  fun menuBuku(): Int {
    println("\t\tMenu Manajemen Buku")
    println("-------------------------------------")
    println("1. Tambah Buku")
    println("2. Edit Buku")
    println("3. Hapus Buku")
    println("4. Tampilkan Semua Buku")
    println("0. Kembali Ke Menu Utama")
    return inputAngka("Masukkan Pilihan: ", 0..4)
  }

  fun tambahBuku(): Buku {
    val id = inputAngka("Masukkan Id Buku: ")
    val judul = inputText("Masukkan Judul Buku: ")
    val penulis = inputText("Masukkan Nama Penulis Buku: ")
    val stok = inputAngka("Masukkan Jumlah Stok Buku: ")
    return Buku(id, penulis, judul, stok)
  }

  fun editBuku(): Int {
    return inputAngka("Masukkan id Buku yang ingin diedit: ")
  }

  fun konfirmasiEditBuku(buku: Buku): Boolean {
    println(buku.printInfo())
    val input = inputText("Yakin ingin mengedit Buku ini (y / n): ")
    return input.equals("y", ignoreCase = true)
  }

  fun inputEditBuku(): Buku {
    val id = inputAngka("Masukkan Id baru: ")
    val judul = inputText("Masukkan Judul baru: ")
    val penulis = inputText("Masukkan Nama Penulis baru: ")
    val stok = inputAngka("Masukkan Jumlah Stok baru: ")
    return Buku(id, penulis, judul, stok)
  }

  fun hapusBuku(): Int {
    return inputAngka("Masukkan id Buku yang ingin dihapus: ")
  }

  fun konfirmasiHapusBuku(buku: Buku): Boolean {
    println(buku.printInfo())
    val input = inputText("Yakin ingin menghapus Buku ini (y / n): ")
    return input.equals("y", ignoreCase = true)
  }

  fun menuPeminjaman(): Int {
    println("\t\tMenu Peminjaman Buku")
    println("-------------------------------------")
    println("1. Pinjam Buku")
    println("2. Kembalikan Buku")
    println("3. Lihat Buku yang Dipinjam")
    println("0. Kembali Ke Menu Utama")
    return inputAngka("Masukkan Pilihan: ", 0..3)
  }

  fun inputBukuId(): Int {
    return inputAngka("Masukkan Id Buku yang ingin dipinjam: ")
  }

  fun inputPeminjamId(): Int {
    return inputAngka("Masukkan Id Peminjam: ")
  }
}
