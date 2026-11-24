public class Paket {

    // Atribut paket
    private String kodePaket;
    private String namaBarang;
    private double berat;
    private String tujuan;
    private String status;

    // Constructor default
    public Paket() {
        this.kodePaket = "PKT-000";
        this.namaBarang = "Belum diisi";
        this.berat = 1.0;
        this.tujuan = "Belum ditentukan";
        this.status = "Menunggu";
    }

    // Constructor dengan parameter
    public Paket(String kodePaket, String namaBarang,
                 double berat, String tujuan, String status) {
        setKodePaket(kodePaket);
        setNamaBarang(namaBarang);
        setBerat(berat);
        setTujuan(tujuan);
        setStatus(status);
    }

    // Getter
    public String getKodePaket() {
        return kodePaket;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public double getBerat() {
        return berat;
    }

    public String getTujuan() {
        return tujuan;
    }

    public String getStatus() {
        return status;
    }

    // Setter dengan validasi
    public void setKodePaket(String kodePaket) {
        if (kodePaket == null || kodePaket.trim().isEmpty()) {
            throw new IllegalArgumentException("Kode paket tidak boleh kosong");
        }
        this.kodePaket = kodePaket;
    }

    public void setNamaBarang(String namaBarang) {
        if (namaBarang == null || namaBarang.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama barang tidak boleh kosong");
        }
        this.namaBarang = namaBarang;
    }

    public void setBerat(double berat) {
        if (berat <= 0) {
            throw new IllegalArgumentException("Berat harus lebih dari 0");
        }
        this.berat = berat;
    }

    public void setTujuan(String tujuan) {
        if (tujuan == null || tujuan.trim().isEmpty()) {
            throw new IllegalArgumentException("Tujuan tidak boleh kosong");
        }
        this.tujuan = tujuan;
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Status tidak boleh kosong");
        }
        this.status = status;
    }

    // Menghitung biaya pengiriman
    public double hitungOngkir(double tarifPerKg) {
        if (tarifPerKg <= 0) {
            throw new IllegalArgumentException("Tarif harus lebih dari 0");
        }
        return berat * tarifPerKg;
    }

    // Mengubah status paket secara berurutan
    public void ubahStatus(String statusBaru) {
        if (status.equals("Menunggu") && statusBaru.equals("Diproses")) {
            this.status = statusBaru;
        } else if (status.equals("Diproses") &&
                statusBaru.equals("Dalam perjalanan")) {
            this.status = statusBaru;
        } else if (status.equals("Dalam perjalanan") &&
                statusBaru.equals("Diterima")) {
            this.status = statusBaru;
        } else {
            System.out.println("Perubahan status tidak diperbolehkan!");
        }
    }

    // Menampilkan informasi paket
    public void tampilkanInfo() {
        System.out.println("Kode Paket : " + kodePaket);
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Berat      : " + berat + " kg");
        System.out.println("Tujuan     : " + tujuan);
        System.out.println("Status     : " + status);
    }
}