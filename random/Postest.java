import java.util.Scanner;

public class Postest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan hari pemutaran film: ");
        String hari = scanner.nextLine().trim();

        System.out.print("Masukkan jenis kursi (Regular/VIP/Premium): ");
        String kursi = scanner.nextLine().trim();

        boolean akhirPekan = hari.equalsIgnoreCase("Sabtu") || hari.equalsIgnoreCase("Minggu");

        int harga;

        switch (kursi.toLowerCase()) {
            case "regular":
                harga = 50000;
                if (akhirPekan) {
                    harga += 10000;
                }
                break;
            case "vip":
                harga = 100000;
                if (akhirPekan) {
                    harga += 20000;
                }
                break;
            case "premium":
                harga = 150000;
                if (akhirPekan) {
                    harga += 30000;
                }
                break;
            default:
                System.out.println("Jenis kursi tidak valid!");
                return;
        }

        System.out.println("Hari pemutaran : " + hari);
        System.out.println("Jenis kursi    : " + kursi);
        System.out.println("Harga total yang harus dibayar: Rp" + harga);

        scanner.close();
    }
}
