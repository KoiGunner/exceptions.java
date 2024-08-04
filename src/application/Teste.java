package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        var scanner = new Scanner(System.in);


        try {
            String[] vect = scanner.nextLine().split(" ");
            int position = scanner.nextInt();
            System.out.printf(vect[position]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.printf("O tamanho do vetor pedido não existe");
        } catch (InputMismatchException exception) {
            System.out.println("Favor digitar um número. Obrigado! ");
        }
        finally {
            System.out.println("Programa finalizado com sucesso!");
        }
        scanner.close();
    }
}
