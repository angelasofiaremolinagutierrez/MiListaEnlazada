import co.edu.upb.list.List;

import java.util.Scanner;

public class CalculadoraVectores {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List v1 = new List();
        List v2 = new List();

        System.out.println("Ingrese las coordenadas del primer vector");
        System.out.println("X:");
        v1.add(Integer.parseInt(scan.nextLine())); //coordenada x v1
        System.out.println("Y:");
        v1.add(Integer.parseInt(scan.nextLine())); //coordenada y v1

        System.out.println("Ingrese las coordenadas del segundo vector");
        System.out.println("X:");
        v2.add(Integer.parseInt(scan.nextLine())); //coordenada x v2
        System.out.println("Y:");
        v2.add(Integer.parseInt(scan.nextLine())); //coordenada y v2

        System.out.println("Que operación quiere realizar con estos?");
        System.out.println("Escriba '+' para suma de vectores o '.' para producto escalar de vectores");

        String op = scan.nextLine();

        switch (op) {
            case "+": {
                
            }
            break;
            case ".":{

            }
            break;
        }
    }
}
