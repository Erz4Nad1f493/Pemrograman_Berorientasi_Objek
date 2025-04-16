import java.util.ArrayList;
import java.util.Scanner;

class DimsumMentai {
    private int id; 
    private String namaProduk; 
    private String deskripsi; 
    private double harga; 
    private String penjual; 
    private String status; 

    public DimsumMentai(int id, String namaProduk, String deskripsi, double harga, String penjual) {
        this.id = id;
        this.namaProduk = namaProduk;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.penjual = penjual;
        this.status = "Tersedia";
    }

    public int getId() {
        return id;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getPenjual() {
        return penjual;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void display() {
        System.out.println("ID Produk  : " + id);
        System.out.println("Nama Produk: " + namaProduk);
        System.out.println("Deskripsi  : " + deskripsi);
        System.out.println("Harga      : Rp " + harga);
        System.out.println("Penjual    : " + penjual);
        System.out.println("Status     : " + status);
        System.out.println("-------------------------------");
    }
}

// Subclass dengan Overriding
class DimsumAyam extends DimsumMentai {
    public DimsumAyam(int id, String namaProduk, String deskripsi, double harga, String penjual) {
        super(id, namaProduk, deskripsi, harga, penjual);
    }

    @Override
    public void display() {
        System.out.println("Jenis Produk: Dimsum Ayam");
        super.display();
    }
}

class DimsumUdang extends DimsumMentai {
    public DimsumUdang(int id, String namaProduk, String deskripsi, double harga, String penjual) {
        super(id, namaProduk, deskripsi, harga, penjual);
    }

    @Override
    public void display() {
        System.out.println("Jenis Produk: Dimsum Udang");
        super.display();
    }
}

class DimsumSalmon extends DimsumMentai {
    public DimsumSalmon(int id, String namaProduk, String deskripsi, double harga, String penjual) {
        super(id, namaProduk, deskripsi, harga, penjual);
    }

    @Override
    public void display() {
        System.out.println("Jenis Produk: Dimsum Salmon");
        super.display();
    }
}

public class SistemPenjualanDimsumMentai {
    static ArrayList<DimsumMentai> daftarDimsum = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static int idProduk = 1;

    public static void main(String[] args) {
        tambahProduk("ayam", "Dimsum Ayam Original", "Dimsum ayam dengan saus khas", 12000, "Rizky");
        tambahProduk("udang", "Dimsum Udang Pedas", "Dimsum udang pedas manis", 15000, "Rina");

        int pilih;
        do {
            System.out.println("\n===== Sistem Penjualan Dimsum Mentai Berbasis Website =====");
            System.out.println("1. Tambah Produk Dimsum Mentai");
            System.out.println("2. Lihat Daftar Produk");
            System.out.println("3. Edit Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Beli Produk");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();
            input.nextLine(); 

            switch (pilih) {
                case 1:
                    tambahProduk();
                    break;
                case 2:
                    lihatProduk();
                    break;
                case 3:
                    editProduk();
                    break;
                case 4:
                    hapusProduk();
                    break;
                case 5:
                    beliProduk();
                    break;
                case 6:
                    System.out.println("Keluar dari sistem...");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia!");
            }
        } while (pilih != 6);
    }

    static void tambahProduk(String jenis, String nama, String deskripsi, double harga, String penjual) {
        DimsumMentai produkBaru;
        switch (jenis.toLowerCase()) {
            case "ayam":
                produkBaru = new DimsumAyam(idProduk++, nama, deskripsi, harga, penjual);
                break;
            case "udang":
                produkBaru = new DimsumUdang(idProduk++, nama, deskripsi, harga, penjual);
                break;
            case "salmon":
                produkBaru = new DimsumSalmon(idProduk++, nama, deskripsi, harga, penjual);
                break;
            default:
                produkBaru = new DimsumAyam(idProduk++, nama, deskripsi, harga, penjual);
                break;
        }
        daftarDimsum.add(produkBaru);
        System.out.println("Produk berhasil ditambahkan lewat method overloading!");
    }

    static void tambahProduk() {
        System.out.println("\n=== Tambah Produk Dimsum Mentai ===");
        System.out.println("Pilih jenis produk:");
        System.out.println("1. Dimsum Ayam");
        System.out.println("2. Dimsum Udang");
        System.out.println("3. Dimsum Salmon");
        System.out.print("Pilihan: ");
        int jenis = input.nextInt();
        input.nextLine();

        System.out.print("Nama Produk  : ");
        String nama = input.nextLine();
        System.out.print("Deskripsi    : ");
        String deskripsi = input.nextLine();
        System.out.print("Harga        : Rp ");
        double harga = input.nextDouble();
        input.nextLine(); 
        System.out.print("Nama Penjual : ");
        String penjual = input.nextLine();

        DimsumMentai produkBaru;
        switch (jenis) {
            case 1:
                produkBaru = new DimsumAyam(idProduk++, nama, deskripsi, harga, penjual);
                break;
            case 2:
                produkBaru = new DimsumUdang(idProduk++, nama, deskripsi, harga, penjual);
                break;
            case 3:
                produkBaru = new DimsumSalmon(idProduk++, nama, deskripsi, harga, penjual);
                break;
            default:
                System.out.println("Jenis tidak valid! Dimsum Ayam digunakan sebagai default.");
                produkBaru = new DimsumAyam(idProduk++, nama, deskripsi, harga, penjual);
                break;
        }

        daftarDimsum.add(produkBaru);
        System.out.println("Produk berhasil ditambahkan!");
    }

    static void lihatProduk() {
        System.out.println("\n=== Daftar Produk Dimsum Mentai ===");
        if (daftarDimsum.isEmpty()) {
            System.out.println("Belum ada produk yang terdaftar.");
        } else {
            for (DimsumMentai produk : daftarDimsum) {
                produk.display(); // Polymorphic call
            }
        }
    }

    static void editProduk() {
        lihatProduk();
        System.out.println("\n=== Edit Produk Dimsum Mentai ===");
        System.out.print("Masukkan ID Produk yang ingin diedit: ");
        int id = input.nextInt();
        input.nextLine(); 

        DimsumMentai produkDitemukan = null;
        for (DimsumMentai produk : daftarDimsum) {
            if (produk.getId() == id) {
                produkDitemukan = produk;
                break;
            }
        }

        if (produkDitemukan != null) {
            System.out.print("Nama Produk Baru (" + produkDitemukan.getNamaProduk() + "): ");
            String namaBaru = input.nextLine();
            System.out.print("Deskripsi Baru (" + produkDitemukan.getDeskripsi() + "): ");
            String deskripsiBaru = input.nextLine();
            System.out.print("Harga Baru (" + produkDitemukan.getHarga() + "): Rp ");
            double hargaBaru = input.nextDouble();
            input.nextLine();

            produkDitemukan.setNamaProduk(namaBaru);
            produkDitemukan.setDeskripsi(deskripsiBaru);
            produkDitemukan.setHarga(hargaBaru);

            System.out.println("Produk berhasil diperbarui!");
        } else {
            System.out.println("Produk dengan ID tersebut tidak ditemukan.");
        }
    }

    static void hapusProduk() {
        System.out.println("\n=== Hapus Produk Dimsum Mentai ===");
        System.out.print("Masukkan ID Produk yang ingin dihapus: ");
        int id = input.nextInt();
        input.nextLine(); 

        boolean dihapus = daftarDimsum.removeIf(produk -> produk.getId() == id);
        if (dihapus) {
            System.out.println("Produk berhasil dihapus!");
        } else {
            System.out.println("Produk dengan ID tersebut tidak ditemukan.");
        }
    }

    static void beliProduk() {
        System.out.println("\n=== Beli Produk Dimsum Mentai ===");
        System.out.print("Masukkan ID Produk yang ingin dibeli: ");
        int id = input.nextInt();
        input.nextLine(); 

        DimsumMentai produkDitemukan = null;
        for (DimsumMentai produk : daftarDimsum) {
            if (produk.getId() == id) {
                produkDitemukan = produk;
                break;
            }
        }

        if (produkDitemukan != null) {
            if (produkDitemukan.getStatus().equalsIgnoreCase("Terjual")) {
                System.out.println("Produk ini sudah terjual!");
                return;
            }

            System.out.print("Nama Pembeli: ");
            String pembeli = input.nextLine();

            produkDitemukan.setStatus("Terjual");

            System.out.println("Produk berhasil dibeli oleh " + pembeli + "!");
        } else {
            System.out.println("Produk dengan ID tersebut tidak ditemukan.");
        }
    }
}
