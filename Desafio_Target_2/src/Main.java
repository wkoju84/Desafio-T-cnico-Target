import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe um número: ");
        int numero = scan.nextInt();

        if (ehFibonacci(numero)){
            System.out.println("O número " + numero + " faz parte da sequência de Fibonacci.");
        }
        else {
            System.out.println("O número " + numero + " não faz parte da sequência de Fibonacci.");
        }

        scan.close();
    }

    //verifica se faz parte da sequência de Fibonacci
    public static boolean ehFibonacci(int numero){
        int a = 0;
        int b = 1;

        //gera a sequência até que b seja maior ou igual ao numero
        while (b < numero){
            int soma = a + b;
            a = b;
            b = soma;
        }

        return (b == numero || a == numero);
    }
}