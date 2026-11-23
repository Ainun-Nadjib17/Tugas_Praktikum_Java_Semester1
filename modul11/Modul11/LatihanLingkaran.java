public class LatihanLingkaran {
    public static void main(String[] args) {
        double jariJari = 7;

        double luas = hitungLuas(jariJari);
        double keliling = hitungKeliling(jariJari);

        System.out.println("Jari-jari lingkaran: " + jariJari);
        System.out.println("Luas lingkaran: " + luas);
        System.out.println("Keliling lingkaran: " + keliling);
    }

    // Luas lingkaran = pi * r * r
    public static double hitungLuas(double r) {
        return Math.PI * r * r;
    }

    // Keliling lingkaran = 2 * pi * r
    public static double hitungKeliling(double r) {
        return 2 * Math.PI * r;
    }
}
