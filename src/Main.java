import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Paket[] daftarPaket = new Paket[100];
        Pengirim[] daftarPengirim = new Pengirim[100];
        Pengiriman[] daftarPengiriman = new Pengiriman[100];

        Queue antrean = new Queue();

        KantorEkspedisi kantor = new KantorEkspedisi(
                "KTR001",
                "Ekspedisi Kendari",
                "Kendari",
                10000
        );

        int jumlahPaket = 0;
        int jumlahPengirim = 0;
        int jumlahPengiriman = 0;

        int pilihan;

        do {
            System.out.println("\n===== SISTEM MANAJEMEN EKSPEDISI =====");
            System.out.println("1. Tambah Paket");
            System.out.println("2. Tampilkan Paket");
            System.out.println("3. Tambah Pengirim");
            System.out.println("4. Tampilkan Pengirim");
            System.out.println("5. Buat Pengiriman");
            System.out.println("6. Cari Paket");
            System.out.println("7. Operasi Antrean");
            System.out.println("8. Laporan Pengiriman");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            if (input.hasNextInt()) {
                pilihan = input.nextInt();
                input.nextLine();
            } else {
                System.out.println("Input harus berupa angka!");
                input.nextLine();
                pilihan = -1;
            }

            switch (pilihan) {

                case 1:
                    if (jumlahPaket >= daftarPaket.length) {
                        System.out.println("Penyimpanan paket penuh!");
                        break;
                    }

                    Paket p = new Paket();

                    System.out.print("Masukkan kode paket: ");
                    String kode = input.nextLine();

                    System.out.print("Masukkan nama barang: ");
                    String nama = input.nextLine();

                    System.out.print("Masukkan tujuan: ");
                    String tujuan = input.nextLine();

                    System.out.print("Masukkan berat barang (kg): ");
                    String inputBerat = input.nextLine();
                    double berat;

                    try {
                        berat = Double.parseDouble(inputBerat.replace(',', '.'));

                        if (berat <= 0) {
                            System.out.println("Berat harus lebih dari 0!");
                            break;
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Berat harus berupa angka!");
                        break;
                    }

                    try {
                        p.setKodePaket(kode);
                        p.setNamaBarang(nama);
                        p.setTujuan(tujuan);
                        p.setBerat(berat);

                        daftarPaket[jumlahPaket] = p;
                        jumlahPaket++;

                        System.out.println("Paket berhasil ditambahkan!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Gagal menambahkan paket: " + e.getMessage());
                    }
                    break;

                case 2:
                    if (jumlahPaket == 0) {
                        System.out.println("Belum ada data paket.");
                    } else {
                        System.out.println("\n===== DAFTAR DATA PAKET =====");

                        for (int i = 0; i < jumlahPaket; i++) {
                            System.out.println("\nPaket ke-" + (i + 1));
                            daftarPaket[i].tampilkanInfo();
                        }
                    }
                    break;

                case 3:
                    if (jumlahPengirim >= daftarPengirim.length) {
                        System.out.println("Data pengirim sudah penuh!");
                        break;
                    }

                    Pengirim pg = new Pengirim();

                    System.out.print("Masukkan ID pengirim: ");
                    String id = input.nextLine();

                    System.out.print("Masukkan nama pengirim: ");
                    String namaPengirim = input.nextLine();

                    System.out.print("Masukkan nomor telepon: ");
                    String telepon = input.nextLine();

                    System.out.print("Masukkan alamat pengirim: ");
                    String alamat = input.nextLine();

                    try {
                        pg.setIdPengirim(id);
                        pg.setNamaPengirim(namaPengirim);
                        pg.setNoTelepon(telepon);
                        pg.setAlamat(alamat);

                        daftarPengirim[jumlahPengirim] = pg;
                        jumlahPengirim++;

                        System.out.println("Data pengirim berhasil ditambahkan!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Gagal menambahkan pengirim: " + e.getMessage());
                    }
                    break;

                case 4:
                    if (jumlahPengirim == 0) {
                        System.out.println("Belum ada data pengirim.");
                    } else {
                        System.out.println("\n===== DAFTAR DATA PENGIRIM =====");

                        for (int i = 0; i < jumlahPengirim; i++) {
                            System.out.println("\nPengirim ke-" + (i + 1));
                            daftarPengirim[i].tampilkanInfo();
                        }
                    }
                    break;

                case 5:
                    if (jumlahPaket == 0 || jumlahPengirim == 0) {
                        System.out.println("Tambahkan paket dan pengirim terlebih dahulu!");
                        break;
                    }

                    if (jumlahPengiriman >= daftarPengiriman.length) {
                        System.out.println("Data pengiriman sudah penuh!");
                        break;
                    }

                    System.out.println("\n===== PILIH PAKET =====");
                    for (int i = 0; i < jumlahPaket; i++) {
                        System.out.println((i + 1) + ". "
                                + daftarPaket[i].getKodePaket()
                                + " - " + daftarPaket[i].getNamaBarang());
                    }

                    System.out.print("Pilih nomor paket: ");
                    int nomorPaket = input.nextInt();
                    input.nextLine();

                    System.out.println("\n===== PILIH PENGIRIM =====");
                    for (int i = 0; i < jumlahPengirim; i++) {
                        System.out.println((i + 1) + ". "
                                + daftarPengirim[i].getNamaPengirim());
                    }

                    System.out.print("Pilih nomor pengirim: ");
                    int nomorPengirim = input.nextInt();
                    input.nextLine();

                    if (nomorPaket < 1 || nomorPaket > jumlahPaket
                            || nomorPengirim < 1 || nomorPengirim > jumlahPengirim) {
                        System.out.println("Pilihan tidak valid!");
                        break;
                    }

                    System.out.print("Masukkan kode pengiriman: ");
                    String kodePengiriman = input.nextLine();

                    System.out.print("Masukkan tanggal pengiriman: ");
                    String tanggal = input.nextLine();

                    try {
                        Pengiriman kirim = new Pengiriman(
                                kodePengiriman,
                                tanggal,
                                daftarPaket[nomorPaket - 1],
                                kantor
                        );

                        kirim.hitungBiaya();

                        daftarPengiriman[jumlahPengiriman] = kirim;
                        jumlahPengiriman++;

                        System.out.println("Pengiriman berhasil dibuat!");
                        kirim.tampilkanResi();

                        System.out.println("\n===== UBAH STATUS PENGIRIMAN =====");
                        System.out.println("1. Diproses");
                        System.out.println("2. Dalam perjalanan");
                        System.out.println("3. Diterima");
                        System.out.println("0. Lewati");
                        System.out.print("Pilih status: ");

                        int status = input.nextInt();
                        input.nextLine();

                        if (status == 1) {
                            kirim.ubahStatusPengiriman("Diproses");
                        } else if (status == 2) {
                            kirim.ubahStatusPengiriman("Dalam perjalanan");
                        } else if (status == 3) {
                            kirim.ubahStatusPengiriman("Diterima");
                        } else {
                            System.out.println("Status tidak diubah.");
                        }

                        System.out.println("Status sekarang: "
                                + kirim.getStatusPengiriman());

                    } catch (IllegalArgumentException e) {
                        System.out.println("Gagal membuat pengiriman: " + e.getMessage());
                    }
                    break;

                case 6:
                    if (jumlahPaket == 0) {
                        System.out.println("Belum ada data paket.");
                        break;
                    }

                    System.out.print("Masukkan kode paket yang dicari: ");
                    String cariKode = input.nextLine();

                    boolean ditemukan = false;

                    for (int i = 0; i < jumlahPaket; i++) {
                        if (daftarPaket[i].getKodePaket().equals(cariKode)) {
                            System.out.println("\nPaket ditemukan!");
                            daftarPaket[i].tampilkanInfo();
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Paket dengan kode tersebut tidak ditemukan.");
                    }
                    break;

                case 7:
                    int pilihanAntrean;

                    do {
                        System.out.println("\n===== MENU ANTREAN PAKET =====");
                        System.out.println("1. Tambahkan Paket ke Antrean");
                        System.out.println("2. Keluarkan Paket dari Antrean");
                        System.out.println("3. Lihat Paket Terdepan");
                        System.out.println("4. Tampilkan Semua Antrean");
                        System.out.println("5. Lihat Jumlah Antrean");
                        System.out.println("0. Kembali");
                        System.out.print("Pilih: ");

                        if (input.hasNextInt()) {
                            pilihanAntrean = input.nextInt();
                            input.nextLine();
                        } else {
                            System.out.println("Input harus berupa angka!");
                            input.nextLine();
                            pilihanAntrean = -1;
                        }

                        switch (pilihanAntrean) {
                            case 1:
                                if (jumlahPaket == 0) {
                                    System.out.println("Belum ada paket.");
                                    break;
                                }

                                System.out.print("Masukkan kode paket: ");
                                String kodeAntrean = input.nextLine();

                                boolean ada = false;

                                for (int i = 0; i < jumlahPaket; i++) {
                                    if (daftarPaket[i].getKodePaket().equals(kodeAntrean)) {
                                        antrean.enqueue(daftarPaket[i]);
                                        ada = true;
                                        break;
                                    }
                                }

                                if (!ada) {
                                    System.out.println("Kode paket tidak ditemukan.");
                                }
                                break;

                            case 2:
                                Paket keluar = antrean.dequeue();

                                if (keluar != null) {
                                    System.out.println("Paket yang dikeluarkan: "
                                            + keluar.getKodePaket());
                                }
                                break;

                            case 3:
                                Paket terdepan = antrean.front();

                                if (terdepan == null) {
                                    System.out.println("Antrean masih kosong.");
                                } else {
                                    System.out.println("Paket terdepan: "
                                            + terdepan.getKodePaket());
                                }
                                break;

                            case 4:
                                antrean.tampilkanAntrean();
                                break;

                            case 5:
                                System.out.println("Jumlah paket dalam antrean: "
                                        + antrean.size());
                                break;

                            case 0:
                                System.out.println("Kembali ke menu utama.");
                                break;

                            default:
                                System.out.println("Pilihan tidak tersedia!");
                        }

                    } while (pilihanAntrean != 0);
                    break;

                case 8:
                    System.out.println("\n===== LAPORAN EKSPEDISI =====");
                    System.out.println("Nama Kantor       : " + kantor.getNamaKantor());
                    System.out.println("Jumlah Paket     : " + jumlahPaket);
                    System.out.println("Jumlah Pengirim   : " + jumlahPengirim);
                    System.out.println("Jumlah Pengiriman : " + jumlahPengiriman);
                    System.out.println("Sisa Antrean      : " + antrean.size());

                    double totalPendapatan = 0;

                    for (int i = 0; i < jumlahPengiriman; i++) {
                        totalPendapatan += daftarPengiriman[i].getBiayaPengiriman();
                    }

                    System.out.println("Total Pendapatan  : Rp" + totalPendapatan);

                    System.out.println("\n===== RINCIAN PENGIRIMAN =====");

                    if (jumlahPengiriman == 0) {
                        System.out.println("Belum ada transaksi pengiriman.");
                    } else {
                        for (int i = 0; i < jumlahPengiriman; i++) {
                            System.out.println("\nPengiriman ke-" + (i + 1));
                            daftarPengiriman[i].tampilkanResi();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia!");
            }

        } while (pilihan != 0);

        input.close();
    }
}