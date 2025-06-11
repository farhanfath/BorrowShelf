package lsp.project.borrowshelf.data

open class Buku(
  var id: Int,
  var penulis: String,
  var judul: String,
  var stok: Int
) {
  open fun cekStok() : Boolean = stok > 0

  open fun decreasePinjam() {
    stok--
  }

  open fun increasePinjam() {
    stok++
  }

  open fun printInfo() : String {
    return """
      ID Buku  : $id
      Judul    : $judul
      Penulis  : $penulis
      Tersedia : $stok
    """.trimIndent()
  }
}
