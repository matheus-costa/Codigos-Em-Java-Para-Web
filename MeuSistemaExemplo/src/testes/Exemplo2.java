
package testes;

import java.util.Scanner;

public class Exemplo2 {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro n�mero: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Digite o segundo n�mero: ");
        double numero2 = scanner.nextDouble();

        double soma = numero1 + numero2;

        System.out.println("A soma dos n�meros �: " + soma);

        scanner.close(); // Fechar o Scanner no final para liberar os recursos
    }
}
 
