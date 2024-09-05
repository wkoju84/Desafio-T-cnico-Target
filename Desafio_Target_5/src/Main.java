import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe a string a ser invertida: ");
        String stringNormal = scan.nextLine();

        String stringInvertida = "";

        //percorre a string de trás pra frente e faz inversão
        for (int i = stringNormal.length() - 1; i > 0; i--){
            stringInvertida += stringNormal.charAt(i);
        }

        System.out.println("String invertida: " + stringInvertida);

        scan.close();
    }
}