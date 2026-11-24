public class Queue {

    private Paket[] data;
    private int depan;
    private int belakang;
    private int jumlah;
    private int kapasitas;

    // Constructor default
    public Queue() {
        kapasitas = 10;
        data = new Paket[kapasitas];
        depan = 0;
        belakang = -1;
        jumlah = 0;
    }

    // Menambahkan paket ke antrean
    public void enqueue(Paket paket) {
        if (isFull()) {
            System.out.println("Antrean sudah penuh!");
            return;
        }

        belakang = (belakang + 1) % kapasitas;
        data[belakang] = paket;
        jumlah++;

        System.out.println("Paket berhasil masuk antrean.");
    }

    // Mengeluarkan paket dari antrean
    public Paket dequeue() {
        if (isEmpty()) {
            System.out.println("Antrean masih kosong!");
            return null;
        }

        Paket paket = data[depan];
        data[depan] = null;
        depan = (depan + 1) % kapasitas;
        jumlah--;

        return paket;
    }

    // Melihat paket paling depan
    public Paket front() {
        if (isEmpty()) {
            return null;
        }

        return data[depan];
    }

    // Memeriksa apakah antrean kosong
    public boolean isEmpty() {
        return jumlah == 0;
    }

    // Memeriksa apakah antrean penuh
    public boolean isFull() {
        return jumlah == kapasitas;
    }

    // Menghitung jumlah paket
    public int size() {
        return jumlah;
    }

    // Menampilkan seluruh antrean
    public void tampilkanAntrean() {
        if (isEmpty()) {
            System.out.println("Antrean masih kosong.");
            return;
        }

        System.out.println("===== DAFTAR ANTREAN PAKET =====");

        for (int i = 0; i < jumlah; i++) {
            int posisi = (depan + i) % kapasitas;

            System.out.println((i + 1) + ". "
                    + data[posisi].getKodePaket()
                    + " - "
                    + data[posisi].getNamaBarang());
        }
    }
}