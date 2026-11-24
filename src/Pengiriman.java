public class Pengiriman {

    private String kodePengiriman;
    private String tanggalPengiriman;
    private double biayaPengiriman;
    private String statusPengiriman;

    private Paket paket;
    private KantorEkspedisi kantor;

    // Constructor default
    public Pengiriman() {
        this.kodePengiriman = "KRM001";
        this.tanggalPengiriman = "24-11-2026";
        this.biayaPengiriman = 0;
        this.statusPengiriman = "Menunggu";
        this.paket = null;
        this.kantor = null;
    }

    // Constructor berparameter
    public Pengiriman(String kodePengiriman, String tanggalPengiriman,
                      Paket paket, KantorEkspedisi kantor) {
        this.kodePengiriman = kodePengiriman;
        this.tanggalPengiriman = tanggalPengiriman;
        this.paket = paket;
        this.kantor = kantor;
        this.biayaPengiriman = 0;
        this.statusPengiriman = "Menunggu";
    }

    // Getter
    public String getKodePengiriman() {
        return kodePengiriman;
    }

    public String getTanggalPengiriman() {
        return tanggalPengiriman;
    }

    public double getBiayaPengiriman() {
        return biayaPengiriman;
    }

    public String getStatusPengiriman() {
        return statusPengiriman;
    }

    public Paket getPaket() {
        return paket;
    }

    public KantorEkspedisi getKantor() {
        return kantor;
    }

    // Setter
    public void setKodePengiriman(String kodePengiriman) {
        if (kodePengiriman == null || kodePengiriman.equals("")) {
            throw new IllegalArgumentException("Kode pengiriman tidak boleh kosong");
        }
        this.kodePengiriman = kodePengiriman;
    }

    public void setTanggalPengiriman(String tanggalPengiriman) {
        if (tanggalPengiriman == null || tanggalPengiriman.equals("")) {
            throw new IllegalArgumentException("Tanggal tidak boleh kosong");
        }
        this.tanggalPengiriman = tanggalPengiriman;
    }

    public void setPaket(Paket paket) {
        if (paket == null) {
            throw new IllegalArgumentException("Paket tidak boleh kosong");
        }
        this.paket = paket;
    }

    public void setKantor(KantorEkspedisi kantor) {
        if (kantor == null) {
            throw new IllegalArgumentException("Kantor tidak boleh kosong");
        }
        this.kantor = kantor;
    }

    // Membuat transaksi pengiriman
    public void buatTransaksi(Paket paket, KantorEkspedisi kantor) {
        setPaket(paket);
        setKantor(kantor);
        hitungBiaya();
    }

    // Menghitung biaya pengiriman
    public void hitungBiaya() {
        if (paket == null || kantor == null) {
            throw new IllegalArgumentException("Data paket dan kantor belum lengkap");
        }

        biayaPengiriman = kantor.hitungTarif(paket.getBerat());
    }

    // Mengubah status pengiriman
    public void ubahStatusPengiriman(String statusBaru) {
        if (statusPengiriman.equals("Menunggu")
                && statusBaru.equals("Diproses")) {
            statusPengiriman = statusBaru;
        } else if (statusPengiriman.equals("Diproses")
                && statusBaru.equals("Dalam perjalanan")) {
            statusPengiriman = statusBaru;
        } else if (statusPengiriman.equals("Dalam perjalanan")
                && statusBaru.equals("Diterima")) {
            statusPengiriman = statusBaru;
        } else {
            System.out.println("Perubahan status tidak sesuai urutan!");
        }
    }

    // Menampilkan resi
    public void tampilkanResi() {
        System.out.println("===== RESI PENGIRIMAN =====");
        System.out.println("Kode Pengiriman : " + kodePengiriman);
        System.out.println("Tanggal         : " + tanggalPengiriman);
        System.out.println("Status          : " + statusPengiriman);

        if (paket != null) {
            System.out.println("Nama Barang     : " + paket.getNamaBarang());
            System.out.println("Berat           : " + paket.getBerat() + " kg");
        }

        if (kantor != null) {
            System.out.println("Kantor          : " + kantor.getNamaKantor());
        }

        System.out.println("Biaya           : Rp" + biayaPengiriman);
        System.out.println("===========================");
    }
}