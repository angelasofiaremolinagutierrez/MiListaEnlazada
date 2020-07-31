import co.edu.upb.list.List;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List n1 = new List();
        List n2 = new List();

        System.out.println("Ingrese el primer numero mayor a treinta digitos");
        String n1_str = scan.nextLine();
        for (int i = 0; i < n1_str.length() ; i++) {
            n1.add((int)n1_str.charAt(i));
        }

        System.out.println("Ingrese el segundo numero mayor a treinta digitos");
        String n2_str = scan.nextLine();
        for (int i = 0; i < n2_str.length() ; i++) {
            n2.add((int)n2_str.charAt(i));
        }

        System.out.println("Que operación quiere realizar con estos? (Escriba +,-,*,/)");

        String g = scan.nextLine();
        switch (g){
            case "+":
                break;
            case "-":
                break;
            case "*":
                break;
            case "/":
                break;
        }


    }
}
