import java.util.Scanner;

public class Main {

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void tampilkanFibonacci(int n) {
        if (n == 0) {
            return;
        }

        tampilkanFibonacci(n - 1);
        System.out.print(fibonacci(n) + " ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah bilangan: ");
        int jumlah = input.nextInt();

        if (jumlah <= 0) {
            System.out.println("Input harus lebih dari 0");
            return;
        }

        System.out.println("Deret Fibonacci:");
        tampilkanFibonacci(jumlah);

        input.close();
    }
}