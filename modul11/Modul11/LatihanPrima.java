public class LatihanPrima {
    public static void main(String[] args) {
        int angka = 10;
        boolean hasil = isPrima(angka);

        if (hasil) {
            System.out.println(angka + " adalah bilangan prima.");
        } else {
            System.out.println(angka + " bukan bilangan prima.");
        }
    }

    // Method dengan return value: true jika n bilangan prima, false jika tidak
    public static boolean isPrima(int n) {
        // Bilangan prima terkecil adalah 2
        if (n <= 1) {
            return false;
        }

        // Cukup cek pembagi sampai akar dari n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // ketemu pembagi lain, berarti bukan prima
            }
        }

        return true;
    }
}
