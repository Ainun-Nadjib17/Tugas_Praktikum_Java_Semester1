public class LuasSimple {

    public static void main(String[] args) {

        int alas, tinggi;
        alas = 6;
        tinggi = 4;

        double luas = hitungLuasSegitiga(alas, tinggi);
        System.out.println("Luas segitiga = " + luas);

        gambarSegitiga(tinggi);

    }

    static double hitungLuasSegitiga(int alas, int tinggi) {
        double hasil;

        hasil = 0.5 * alas * tinggi;
        return hasil;
    }

    static void gambarSegitiga(int tinggi) {
        for (int baris = 1; baris <= tinggi; baris++) {
            for (int kolom = 1; kolom <= baris; kolom++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
