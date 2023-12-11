import java.util.ArrayList;

public class Penjualan {
    private static ArrayList<Integer> jumlahPenjualan = new ArrayList<>();
    private static ArrayList<Integer> hargaLaptop = new ArrayList<>();
    private static ArrayList<Integer> totalPendapatan = new ArrayList<>();
    private static ArrayList<String> merkLaptop = new ArrayList<>(); // Menyimpan merk laptop yang terjual

    public static void tambahPenjualan(String merk, int jumlah, int hargaSatuan) {
        jumlahPenjualan.add(jumlah);
        hargaLaptop.add(hargaSatuan);
        totalPendapatan.add(jumlah * hargaSatuan);
        merkLaptop.add(merk);
    }

    public static ArrayList<Integer> semuaJumlahPenjualan() {
        return jumlahPenjualan;
    }

    public static ArrayList<Integer> semuaHargaLaptop() {
        return hargaLaptop;
    }

    public static ArrayList<Integer> semuaTotalPendapatan() {
        return totalPendapatan;
    }

    public static ArrayList<String> semuaMerkLaptop() {
        return merkLaptop;
    }
}
