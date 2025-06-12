package lsp.project.training.borrowshelf

import lsp.project.training.borrowshelf.controller.Menu
import lsp.project.training.borrowshelf.data.Anggota
import lsp.project.training.borrowshelf.data.Buku
import lsp.project.training.borrowshelf.data.BukuDipinjam

fun main() {
  val memberTerdaftar = mutableListOf<Anggota>()
  val bukuTerdaftar = mutableListOf<Buku>()
  val bukuDipinjam = mutableListOf<BukuDipinjam>()

  while (true) {
    var pilihan = Menu.menuUtama()

    when(pilihan) {
      0 -> return
      1 -> {
        pilihan = Menu.menuKeanggotaan()
        when(pilihan) {
          0 -> continue
          1 -> {
            memberTerdaftar.add(Menu.tambahAnggota())
            println("-----------------------------------")
            println("Anggota Berhasil Ditambahkan!\n")
          }
          2 -> {
            val selectedId = Menu.hapusAnggota()
            val index = memberTerdaftar.indexOfFirst { it.id == selectedId }

            if (index != -1) {
              val konfirmasi = Menu.konfirmasiHapusAnggota(memberTerdaftar[index])
              if (konfirmasi) {
                memberTerdaftar.removeAt(index)
                println("Anggota Berhasil Dihapus")
              } else {
                println("Membatalkan")
              }
            } else {
              println("Id Tidak Ditemukan")
            }
            readlnOrNull()!!
          }
          3 -> {
            if (memberTerdaftar.isNotEmpty()) {
              memberTerdaftar.forEach {
                println(it.printInfoAnggota())
                readlnOrNull()!!
              }
            } else {
              println("Belum ada anggota yang dapat ditampilkan")
              readlnOrNull()!!
            }
          }
        }
      }
      2 -> {
        pilihan = Menu.menuBuku()
        when (pilihan) {
          0 -> continue
          1 -> {
            bukuTerdaftar.add(Menu.tambahBuku())
            println("-----------------------------------")
            println("Buku Berhasil Ditambahkan!\n")
          }
          2 -> {
            val selectedId = Menu.editBuku()
            val index = bukuTerdaftar.indexOfFirst { it.id == selectedId }

            if (index != -1) {
              val konfirmasi = Menu.konfirmasiEditBuku(bukuTerdaftar[index])
              if (konfirmasi) {
                val book = Menu.inputEditBuku()
                bukuTerdaftar[index].apply {
                  id = book.id
                  penulis = book.penulis
                  judul = book.judul
                  stok = book.stok
                }
                println("Buku Berhasil Di Edit")
              } else {
                println("Membatalkan")
              }
            } else {
              println("Id Buku tidak ditemukan")
            }
            readlnOrNull()!!
          }
          3 -> {
            val selectedId = Menu.hapusBuku()
            val index = bukuTerdaftar.indexOfFirst { it.id == selectedId }

            if (index != -1) {
              val konfirmasi = Menu.konfirmasiHapusBuku(bukuTerdaftar[index])
              if (konfirmasi) {
                bukuTerdaftar.removeAt(index)
                println("Buku Berhasil Dihapus")
              } else {
                println("Membatalkan")
              }
            } else {
              println("Id Tidak Ditemukan")
            }
            readlnOrNull()!!
          }
          4 -> {
            if (bukuTerdaftar.isNotEmpty()) {
              bukuTerdaftar.forEach {
                println(it.printInfo())
                readlnOrNull()!!
              }
            } else {
              println("Belum ada Buku yang dapat ditampilkan")
              readlnOrNull()!!
            }
          }
        }
      }
      3 -> {
        pilihan = Menu.menuPeminjaman()
        when (pilihan) {
          0 -> continue
          1 -> {
            val idBukuPinjam = Menu.inputBukuId()
            val idPeminjamBuku = Menu.inputPeminjamId()

            val bukuIndex = bukuTerdaftar.indexOfFirst { it.id == idBukuPinjam }
            val peminjamIndex = memberTerdaftar.indexOfFirst { it.id == idPeminjamBuku }

            if (bukuIndex != -1 && peminjamIndex != -1) {
              val buku = bukuTerdaftar[bukuIndex]
              val memberPinjam = memberTerdaftar[peminjamIndex]

              if (buku.cekStok()) {
                val existing = bukuDipinjam.find { it.id == buku.id }
                if (existing != null) {
                  existing.peminjam.add(memberPinjam)
                } else {
                  val bukuDipinjamBaru = BukuDipinjam(buku.id, buku.penulis, buku.judul, buku.stok)
                  bukuDipinjamBaru.peminjam.add(memberPinjam)
                  bukuDipinjam.add(bukuDipinjamBaru)
                }
                buku.decreasePinjam()
                println("buku ${buku.judul} Berhasil Dipinjam oleh: ${memberPinjam.nama}")
              } else {
                println("Buku tidak tersedia atau Stok Habis")
              }
            } else {
              println("Buku atau ID Anggota tidak ditemukan")
            }
            readlnOrNull()!!
          }
          2 -> {
            if (bukuDipinjam.isNotEmpty()) {
              val idBukuKembalikan = Menu.inputBukuId()
              val idPeminjamBuku = Menu.inputPeminjamId()

              val bukuIndex = bukuDipinjam.indexOfFirst { it.id == idBukuKembalikan }
              val peminjamIndex = memberTerdaftar.indexOfFirst { it.id == idPeminjamBuku }

              if (bukuIndex != -1 && peminjamIndex != -1) {
                val buku = bukuDipinjam[bukuIndex]
                val memberPinjam = memberTerdaftar[peminjamIndex]

                buku.peminjam.remove(memberPinjam)
                bukuDipinjam.remove(buku)

                val bukuAwal = bukuTerdaftar[bukuIndex]
                bukuAwal.increasePinjam()

                println("Buku ${buku.judul} Berhasil Dikembalikan oleh: ${memberPinjam.nama}")
              } else {
                println("Buku atau ID Anggota tidak ditemukan")
              }
            } else {
              println("Belum ada buku yang dipinjam.")
            }
            readlnOrNull()!!
          }
          3 -> {
            if (bukuDipinjam.isNotEmpty()) {
              bukuDipinjam.forEach {
                println(it.printInfo())
              }
            } else {
              println("Belum ada buku yang dipinjam.")
            }
            readlnOrNull()!!
          }
        }
      }
    }
  }
}