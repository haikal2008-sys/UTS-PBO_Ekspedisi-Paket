public class Pengirim {

    // Atribut pengirim
    private String idPengirim;
    private String namaPengirim;
    private String noTelepon;
    private String alamat;

    // Constructor default
    public Pengirim() {
        this.idPengirim = "PG-000";
        this.namaPengirim = "Belum diisi";
        this.noTelepon = "Belum diisi";
        this.alamat = "Belum diisi";
    }

    // Constructor dengan parameter
    public Pengirim(String idPengirim, String namaPengirim,
                    String noTelepon, String alamat) {
        setIdPengirim(idPengirim);
        setNamaPengirim(namaPengirim);
        setNoTelepon(noTelepon);
        setAlamat(alamat);
    }

    // Getter
    public String getIdPengirim() {
        return idPengirim;
    }

    public String getNamaPengirim() {
        return namaPengirim;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    // Setter
    public void setIdPengirim(String idPengirim) {
        if (idPengirim == null || idPengirim.trim().isEmpty()) {
            throw new IllegalArgumentException("ID pengirim tidak boleh kosong");
        }
        this.idPengirim = idPengirim;
    }

    public void setNamaPengirim(String namaPengirim) {
        if (namaPengirim == null || namaPengirim.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        this.namaPengirim = namaPengirim;
    }

    public void setNoTelepon(String noTelepon) {
        if (noTelepon == null || noTelepon.trim().isEmpty()) {
            throw new IllegalArgumentException("Nomor telepon tidak boleh kosong");
        }
        this.noTelepon = noTelepon;
    }

    public void setAlamat(String alamat) {
        if (alamat == null || alamat.trim().isEmpty()) {
            throw new IllegalArgumentException("Alamat tidak boleh kosong");
        }
        this.alamat = alamat;
    }

    // Mengubah nama pengirim
    public void ubahNama(String namaBaru) {
        setNamaPengirim(namaBaru);
    }

    // Mengubah alamat pengirim
    public void ubahAlamat(String alamatBaru) {
        setAlamat(alamatBaru);
    }

    // Menampilkan informasi pengirim
    public void tampilkanInfo() {
        System.out.println("ID Pengirim : " + idPengirim);
        System.out.println("Nama        : " + namaPengirim);
        System.out.println("No. Telepon : " + noTelepon);
        System.out.println("Alamat      : " + alamat);
    }
}