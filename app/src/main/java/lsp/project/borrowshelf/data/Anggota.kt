package lsp.project.borrowshelf.data

class Anggota(
  id: Int,
  nama: String,
  ktp: String,
  alamat: String,
  jenisKelamin: String,
) : Person(
  id,
  nama,
  ktp,
  alamat,
  jenisKelamin
) {
  fun printInfoAnggota() : String {
    return "ID\t: $id \n" +
      "Nama\t: $nama \n" +
      "No.KTP\t: $ktp \n" +
      "Alamat\t: $alamat \n" +
      "Jenis Kelamin\t: $jenisKelamin"
  }
}