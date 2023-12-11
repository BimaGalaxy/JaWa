import java.util.ArrayList;
public class dataLaptop {
        public static ArrayList<Laptop> laptops = new ArrayList<>();

        public static void tambahLaptop(Laptop laptop) {
            laptops.add(laptop);
        }

        public static ArrayList<Laptop> semuaLaptop() {
            return laptops;
        }
    }
