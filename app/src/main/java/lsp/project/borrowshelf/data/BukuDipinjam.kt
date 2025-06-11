package lsp.project.borrowshelf.data

class BukuDipinjam(
  id: Int,
  penulis: String,
  judul: String,
  stok: Int
) : Buku(id, penulis, judul, stok) {

  var peminjam: ArrayList<Anggota> = ArrayList()

  override fun printInfo(): String {
    val str = peminjam.joinToString(", ") { it.nama }
    return """
            ID Buku	    : $id
            Judul Buku	: $judul
            Penulis	    : $penulis
            Peminjam	  : $str
        """.trimIndent()
  }
}
