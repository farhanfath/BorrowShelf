package lsp.project.borrowshelf.controller

fun inputAngka(prompt: String, range: IntRange? = null): Int {
  while (true) {
    print(prompt)
    val input = readlnOrNull()?.toIntOrNull()
    if (input != null && (range == null || input in range)) {
      return input
    }
    println("Input tidak valid. ${if (range != null) "Masukkan angka antara ${range.first} sampai ${range.last}." else ""}")
  }
}

fun inputText(prompt: String): String {
  while (true) {
    print(prompt)
    val input = readlnOrNull()
    if (!input.isNullOrBlank()) return input
    println("Input tidak boleh kosong.")
  }
}