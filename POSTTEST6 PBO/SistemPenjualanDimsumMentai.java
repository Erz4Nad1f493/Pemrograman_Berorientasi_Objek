import java.util.ArrayList;
import java.util.Scanner;

interface Promo {
    double hitungDiskon(); 
    void tampilkanPromo(); 
}


class Util {
    public static int totalProduk = 0;

    public static void tampilkanTotalProduk() {
        System.out.println("Total Produk Saat Ini: " + totalProduk);
    }
}


abstract class DimsumMentai {
    private int id;
    private String namaProduk;
    private String deskripsi;
    protected final double harga; 
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

    public String getPenjual() {
        return penjual;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract String getJenisProduk();

    public void display() {
        System.out.println("Jenis Produk: " + getJenisProduk());
        System.out.println("ID Produk  : " + id);
        System.out.println("Nama Produk: " + namaProduk);
        System.out.println("Deskripsi  : " + deskripsi);
        System.out.println("Harga      : Rp " + harga);
        System.out.println("Penjual    : " + penjual);
        System.out.println("Status     : " + status);
        System.out.println("-------------------------------");
    }
}

class DimsumAyam extends DimsumMentai {
    public DimsumAyam(int id, String namaProduk, String deskripsi, double harga, String penjual) {
        super(id, namaProduk, deskripsi, harga, penjual);
    }

    @Override
    public String getJenisProduk() {
        return "Dimsum Ayam";
    }
}

class DimsumUdang extends DimsumMentai {
    public DimsumUdang(int id, String namaProduk, String deskripsi, double harga, String penjual) {
        super(id, namaProduk, deskripsi, harga, penjual);
    }

    @Override
    public String getJenisProduk() {
        return "Dimsum Udang";
    }
}

final class DimsumSalmon extends DimsumMentai implements Promo {
    public DimsumSalmon(int id, String namaProduk, String deskripsi, double harga, String penjual) {
        super(id, namaProduk, deskripsi, harga, penjual);
    }

    @Override
    public String getJenisProduk() {
        return "Dimsum Salmon";
    }

    @Override
    public final void display() {
        super.display();
        tampilkanPromo(); 
    }

    @Override
    public double hitungDiskon() {
        return getHarga() * 0.1; 
    }

    @Override
    public void tampilkanPromo() {
        System.out.println("Promo Diskon: Rp " + hitungDiskon());
        System.out.println("-------------------------------");
    }
}


public class SistemPenjualanDimsumMentai {
    static ArrayList<DimsumMentai> daftarDimsum = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static int idProduk = 1;

    public static void main(String[] args) {
        tambahProduk("ayam", "Dimsum Ayam Original", "Dimsum ayam dengan saus khas", 12000, "Rizky");
        tambahProduk("udang", "Dimsum Udang Pedas", "Dimsum udang pedas manis", 15000, "Rina");

        int pilih = 0;
        do {
            System.out.println("\n===== Sistem Penjualan Dimsum Mentai Berbasis Website =====");
            System.out.println("1. Tambah Produk Dimsum Mentai");
            System.out.println("2. Lihat Daftar Produk");
            System.out.println("3. Edit Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Beli Produk");
            System.out.println("6. Keluar");

            try {
                System.out.print("Pilih menu: ");
                pilih = input.nextInt();
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Input tidak valid! Harus berupa angka.");
                input.nextLine();
                continue;
            }

            switch (pilih) {
                case 1 -> tambahProduk();
                case 2 -> lihatProduk();
                case 3 -> editProduk();
                case 4 -> hapusProduk();
                case 5 -> beliProduk();
                case 6 -> System.out.println("Keluar dari sistem...");
                default -> System.out.println("Pilihan tidak tersedia!");
            }
        } while (pilih != 6);
    }

    static void tambahProduk(String jenis, String nama, String deskripsi, double harga, String penjual) {
        DimsumMentai produkBaru;
        switch (jenis.toLowerCase()) {
            case "ayam" -> produkBaru = new DimsumAyam(idProduk++, nama, deskripsi, harga, penjual);
            case "udang" -> produkBaru = new DimsumUdang(idProduk++, nama, deskripsi, harga, penjual);
            case "salmon" -> produkBaru = new DimsumSalmon(idProduk++, nama, deskripsi, harga, penjual);
            default -> produkBaru = new DimsumAyam(idProduk++, nama, deskripsi, harga, penjual);
        }

        daftarDimsum.add(produkBaru);
        Util.totalProduk++;
        System.out.println("Produk berhasil ditambahkan lewat method overloading!");
        Util.tampilkanTotalProduk();
    }

    static void tambahProduk() {
        System.out.println("\n=== Tambah Produk Dimsum Mentai ===");
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
            case 1 -> produkBaru = new DimsumAyam(idProduk++, nama, deskripsi, harga, penjual);
            case 2 -> produkBaru = new DimsumUdang(idProduk++, nama, deskripsi, harga, penjual);
            case 3 -> produkBaru = new DimsumSalmon(idProduk++, nama, deskripsi, harga, penjual);
            default -> {
                System.out.println("Jenis tidak valid! Dimsum Ayam digunakan sebagai default.");
                produkBaru = new DimsumAyam(idProduk++, nama, deskripsi, harga, penjual);
            }
        }

        daftarDimsum.add(produkBaru);
        Util.totalProduk++;
        System.out.println("Produk berhasil ditambahkan!");
        Util.tampilkanTotalProduk();
    }

    static void lihatProduk() {
        System.out.println("\n=== Daftar Produk Dimsum Mentai ===");
        if (daftarDimsum.isEmpty()) {
            System.out.println("Belum ada produk yang terdaftar.");
        } else {
            for (DimsumMentai produk : daftarDimsum) {
                produk.display();
            }
        }
    }

    static void editProduk() {
        lihatProduk();
        System.out.println("\n=== Edit Produk Dimsum Mentai ===");

        try {
            System.out.print("Masukkan ID Produk yang ingin diedit: ");
            int id = input.nextInt();
            input.nextLine();

            DimsumMentai produk = cariProdukById(id);
            if (produk != null) {
                System.out.print("Nama Produk Baru (" + produk.getNamaProduk() + "): ");
                String namaBaru = input.nextLine();
                System.out.print("Deskripsi Baru (" + produk.getDeskripsi() + "): ");
                String deskripsiBaru = input.nextLine();

                produk.setNamaProduk(namaBaru);
                produk.setDeskripsi(deskripsiBaru);
                System.out.println("Produk berhasil diperbarui!");
            } else {
                System.out.println("Produk dengan ID tersebut tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat mengedit produk.");
            input.nextLine();
        }
    }

    static void hapusProduk() {
        System.out.println("\n=== Hapus Produk Dimsum Mentai ===");

        try {
            System.out.print("Masukkan ID Produk yang ingin dihapus: ");
            int id = input.nextInt();
            input.nextLine();

            boolean dihapus = daftarDimsum.removeIf(produk -> produk.getId() == id);
            if (dihapus) {
                Util.totalProduk--;
                System.out.println("Produk berhasil dihapus!");
                Util.tampilkanTotalProduk();
            } else {
                System.out.println("Produk dengan ID tersebut tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid saat menghapus produk.");
            input.nextLine();
        }
    }

    static void beliProduk() {
        System.out.println("\n=== Beli Produk Dimsum Mentai ===");

        try {
            System.out.print("Masukkan ID Produk yang ingin dibeli: ");
            int id = input.nextInt();
            input.nextLine();

            DimsumMentai produk = cariProdukById(id);
            if (produk != null) {
                if (produk.getStatus().equalsIgnoreCase("Terjual")) {
                    System.out.println("Produk ini sudah terjual!");
                    return;
                }

                System.out.print("Nama Pembeli: ");
                String pembeli = input.nextLine();

                produk.setStatus("Terjual");
                System.out.println("Produk berhasil dibeli oleh " + pembeli + "!");
            } else {
                System.out.println("Produk dengan ID tersebut tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat membeli produk.");
            input.nextLine();
        }
    }

    static DimsumMentai cariProdukById(int id) {
        for (DimsumMentai produk : daftarDimsum) {
            if (produk.getId() == id) {
                return produk;
            }
        }
        return null;
    }
}
