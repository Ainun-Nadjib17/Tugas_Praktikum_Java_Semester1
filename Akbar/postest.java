import java.util.Scanner;
public class postest {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] angka = new int[5];
        for(int i = 0; i < angka.length; i++){
            System.out.print("Masukan nilai ke-" + (i+1) + ":");
            angka[i] = scanner.nextInt();
        }
        int max = angka[0];
        int min = angka[0];

        for(int i = 1; i<angka.length; i++){
            if(angka[i]>max){
                max=angka[i];
            }
            if(angka[i]>min){
                min=angka[i];
            }
        }
        System.out.print("Data yang di input :" );
        for(int i=0; i<angka.length;i++){
            System.out.print("angka[i]" + (i <angka.length - 1?",":"\n"));
        }
        System.out.println("Nilai maksimum :" + max);
        System.out.println("Nilai minimum :" + min);
    }
}