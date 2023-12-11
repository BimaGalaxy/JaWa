public class Main {
    public static void main(String[] args) {

        // Menambah data laptop ke dalam DataLaptop
        dataLaptop.tambahLaptop(new Laptop("asus", 14000));
        dataLaptop.tambahLaptop(new Laptop("acer", 10000));
        dataLaptop.tambahLaptop(new Laptop("lenovo", 15000));

        userInterface.start();
    }
}
