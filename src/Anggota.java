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