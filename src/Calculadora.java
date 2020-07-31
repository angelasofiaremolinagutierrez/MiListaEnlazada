import co.edu.upb.list.List;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List n1 = new List();
        List n2 = new List();
        List res = new List();

        System.out.println("Ingrese el primer numero mayor a treinta digitos");
        String n1_str = scan.nextLine();
        for (int i = n1_str.length()-1; i>=0; i--) {
            n1.add(Character.getNumericValue(n1_str.charAt(i))); //agregar numero a la lista de antras hacia adelante
        }

        System.out.println("Ingrese el segundo numero mayor a treinta digitos");
        String n2_str = scan.nextLine();
        for (int i = n2_str.length()-1; i>=0; i--) {
            n2.add(Character.getNumericValue(n2_str.charAt(i))); //agregar numero a la lista de antras hacia adelante
        }

        //se agregan así con el fin de tener primero unidades, luego decenas, centenas, etc.
        //ESTO SOLO SIRVE PARA SUMA RESTA MULTIPLICAION

        //PARA DIVISION SE NECESITA OTRO ORDEN

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
