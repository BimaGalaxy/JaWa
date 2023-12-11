import java.util.ArrayList;
import java.util.Scanner;

public class userInterface {
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        if (login()) {
            tampilkanMenu();
        } else {
            System.out.println("Login gagal. Aplikasi ditutup.");
        }
    }

    private static boolean login() {
        Pengguna pengguna = new Pengguna(); // Membuat objek Pengguna

        System.out.println("=== LOGIN ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Memeriksa autentikasi
        if (pengguna.autentikasi(username, password)) {
            return true; // Jika autentikasi berhasil
        } else {
            return false; // Jika autentikasi gagal
        }
    }

    public static void tampilkanMenu() {

        int pilihan;
        do {
            System.out.println("\n===== APLIKASI PENJUALAN LAPTOP =====");
            System.out.println("1. Data Laptop");
            System.out.println("2. Laporan Penjualan");
            System.out.println("3. Beli Laptop");
            System.out.println("0. Keluar");
            System.out.println("Pilih menu:");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline

            switch (pilihan) {
                case 1:
                    tampilkanDataLaptop();
                    break;
                case 2:
                    tampilkanDataPenjualan();
                    break;
                case 3:
                    beliLaptop();
                    break;
                case 0:
                    System.out.println("Keluar dari aplikasi. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan != 0);
    }

    private static void tampilkanDataLaptop() {
        System.out.println("\n===== DATA LAPTOP =====");

        ArrayList<Laptop> laptops = dataLaptop.semuaLaptop();

        if (laptops.isEmpty()) {
            System.out.println("Tidak ada data laptop.");
        } else {
            System.out.println("Daftar Laptop:");
            laptops.forEach(laptop -> System.out.println("Merk: " + laptop.getMerk() + " - Harga: Rp" + laptop.getHarga()));
        }
    }

    private static void tampilkanDataPenjualan() {
        ArrayList<Integer> jumlahPenjualan = Penjualan.semuaJumlahPenjualan();
        ArrayList<Integer> hargaLaptop = Penjualan.semuaHargaLaptop();
        ArrayList<Integer> totalPendapatan = Penjualan.semuaTotalPendapatan();
        ArrayList<String> merkLaptop = Penjualan.semuaMerkLaptop();

        if (jumlahPenjualan.isEmpty()) {
            System.out.println("Belum ada data penjualan.");
        } else {
            System.out.println("\n===== DATA PENJUALAN =====");
            System.out.println("No. | Merk Laptop | Jumlah | Harga Satuan | Total");
            System.out.println("---------------------------------");
            for (int i = 0; i < jumlahPenjualan.size(); i++) {
                System.out.println((i + 1) + ". | "+ merkLaptop.get(i) +"     | "+ jumlahPenjualan.get(i) + "      | Rp" + hargaLaptop.get(i) + "        | Rp" + totalPendapatan.get(i));
            }
        }
    }

    private static void beliLaptop() {
        System.out.println("Pilih laptop yang akan dibeli dari daftar:");
        ArrayList<Laptop> daftarLaptop = dataLaptop.semuaLaptop();
        if (daftarLaptop.isEmpty()) {
            System.out.println("Tidak ada laptop yang tersedia untuk dibeli.");
            return;
        }

        System.out.println("Daftar Laptop yang Tersedia:");
        for (int i = 0; i < daftarLaptop.size(); i++) {
            System.out.println((i + 1) + ". Merk: " + daftarLaptop.get(i).getMerk() + " - Harga: Rp" + daftarLaptop.get(i).getHarga());
        }

        System.out.println("Masukkan nomor laptop yang akan dibeli:");
        int nomorPilihan = scanner.nextInt();
        scanner.nextLine();

        if (nomorPilihan <= 0 || nomorPilihan > daftarLaptop.size()) {
            System.out.println("Nomor pilihan tidak valid.");
            return;
        }

        Laptop laptopDibeli = daftarLaptop.get(nomorPilihan - 1);
        Penjualan.tambahPenjualan(laptopDibeli.getMerk(), 1, laptopDibeli.getHarga()); // Menambahkan transaksi pembelian ke Penjualan
        System.out.println("Anda telah membeli laptop merk " + laptopDibeli.getMerk() + " seharga Rp" + laptopDibeli.getHarga() + ".");
    }

}
