public class KantorEkspedisi {

    private String kodeKantor;
    private String namaKantor;
    private String alamatKantor;
    private double tarifPerKg;

    // Constructor default
    public KantorEkspedisi() {
        this.kodeKantor = "KTR001";
        this.namaKantor = "Kantor Ekspedisi";
        this.alamatKantor = "Kendari";
        this.tarifPerKg = 10000;
    }

    // Constructor berparameter
    public KantorEkspedisi(String kodeKantor, String namaKantor,
                           String alamatKantor, double tarifPerKg) {
        this.kodeKantor = kodeKantor;
        this.namaKantor = namaKantor;
        this.alamatKantor = alamatKantor;
        setTarifPerKg(tarifPerKg);
    }

    // Getter
    public String getKodeKantor() {
        return kodeKantor;
    }

    public String getNamaKantor() {
        return namaKantor;
    }

    public String getAlamatKantor() {
        return alamatKantor;
    }

    public double getTarifPerKg() {
        return tarifPerKg;
    }

    // Setter
    public void setKodeKantor(String kodeKantor) {
        if (kodeKantor == null || kodeKantor.equals("")) {
            throw new IllegalArgumentException("Kode kantor tidak boleh kosong");
        }
        this.kodeKantor = kodeKantor;
    }

    public void setNamaKantor(String namaKantor) {
        if (namaKantor == null || namaKantor.equals("")) {
            throw new IllegalArgumentException("Nama kantor tidak boleh kosong");
        }
        this.namaKantor = namaKantor;
    }

    public void setAlamatKantor(String alamatKantor) {
        if (alamatKantor == null || alamatKantor.equals("")) {
            throw new IllegalArgumentException("Alamat tidak boleh kosong");
        }
        this.alamatKantor = alamatKantor;
    }

    public void setTarifPerKg(double tarifPerKg) {
        if (tarifPerKg <= 0) {
            throw new IllegalArgumentException("Tarif harus lebih dari 0");
        }
        this.tarifPerKg = tarifPerKg;
    }

    // Mengubah tarif
    public void ubahTarif(double tarifBaru) {
        setTarifPerKg(tarifBaru);
    }

    // Menghitung biaya pengiriman
    public double hitungTarif(double berat) {
        if (berat <= 0) {
            throw new IllegalArgumentException("Berat harus lebih dari 0");
        }

        return berat * tarifPerKg;
    }

    // Menampilkan informasi kantor
    public void tampilkanInfo() {
        System.out.println("Kode Kantor : " + kodeKantor);
        System.out.println("Nama Kantor : " + namaKantor);
        System.out.println("Alamat      : " + alamatKantor);
        System.out.println("Tarif/Kg    : Rp" + tarifPerKg);
    }
}