
import java.util.Scanner;

public class SumaNumerosPrimos {


    public static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i * i <= num) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        int num1 = sc.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int num2 = sc.nextInt();

        if (esPrimo(num1) && esPrimo(num2)) {
            int suma = num1 + num2;
            System.out.println("Ambos números son primos.");
            System.out.println("La suma de los números primos es: " + suma);
        } else {
            System.out.println("Al menos uno de los números no es primo.");
        }


        Scanner sc2 = new Scanner(System.in);

        System.out.print("Ingrese un número límite: ");
        int limite = sc2.nextInt();

        int num3 = 0, num4 = 1, suma = 0;

        System.out.println("Números de Fibonacci menores que " + limite + ":");

        while (suma < limite) {
            System.out.print(suma + " ");
            num3 = num4;
            num3 = suma;
            suma = num3 + num4;
        }
    }
}