import co.edu.upb.list.List;
import co.edu.upb.list.ListNode;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List n1 = new List();
        List n2 = new List();
        List res = new List();

        System.out.println("Ingrese el primer numero mayor a treinta digitos");
        String n1_str = scan.nextLine();


        System.out.println("Ingrese el segundo numero mayor a treinta digitos");
        String n2_str = scan.nextLine();

        System.out.println("Que operación quiere realizar con estos? (Escriba +,-,*,/)");


        String op = scan.nextLine();

        switch (op){
            case "+": {
                //se agregan así con el fin de tener primero unidades, luego decenas, centenas, etc.
                //ESTO SOLO SIRVE PARA SUMA RESTA MULTIPLICACION

                for (int i = n1_str.length()-1; i>=0; i--) {
                    n1.add(Character.getNumericValue(n1_str.charAt(i))); //agregar numero a la lista de atras hacia adelante
                }
                for (int i = n2_str.length()-1; i>=0; i--) {
                    n2.add(Character.getNumericValue(n2_str.charAt(i))); //agregar numero a la lista de atras hacia adelante
                }
                ListNode nodeRec;
                ListNode nodeRec1 = n1.head;
                ListNode nodeRec2 = n2.head;

                if (n1.getSize() >= n2.getSize()) {
                    nodeRec = nodeRec1;
                } else {
                    nodeRec = nodeRec2;
                }

                int lleva = 0;
                int digito1;
                int digito2;
                while (nodeRec != null) {

                    if (nodeRec1 == null) {
                        digito1 = 0;
                    } else {
                        digito1 = (int) n1.get(nodeRec1);
                    }

                    if (nodeRec2 == null) {
                        digito2 = 0;
                    } else {
                        digito2 = (int) n2.get(nodeRec2);
                    }

                    int sumActual = digito1 + digito2 + lleva;
                    lleva = 0;
                    if (sumActual >= 10) {
                        sumActual = sumActual - 10;
                        lleva++;
                    }
                    res.add(sumActual);

                    if (nodeRec1 == null) {
                        digito1 = 0;
                    } else {
                        nodeRec1 = nodeRec1.next;
                    }

                    if (nodeRec2 == null) {
                        digito2 = 0;
                    } else {
                        nodeRec2 = nodeRec2.next;
                    }
                    nodeRec = nodeRec.next;
                }
                if (lleva != 0) {
                    res.add(lleva);
                }

            }
                break;

            case "-": {
                //se agregan así con el fin de tener primero unidades, luego decenas, centenas, etc.
                //ESTO SOLO SIRVE PARA SUMA RESTA MULTIPLICACION

                for (int i = n1_str.length()-1; i>=0; i--) {
                    n1.add(Character.getNumericValue(n1_str.charAt(i))); //agregar numero a la lista de atras hacia adelante
                }
                for (int i = n2_str.length()-1; i>=0; i--) {
                    n2.add(Character.getNumericValue(n2_str.charAt(i))); //agregar numero a la lista de atras hacia adelante
                }
                ListNode nodeRec;
                ListNode nodeRec1 = n1.head;
                ListNode nodeRec2 = n2.head;
                if (n1.getSize() >= n2.getSize()) {
                    nodeRec = nodeRec1;
                } else {
                    nodeRec = nodeRec2;
                }

                
            }
                break;
            case "*":{
                //se agregan así con el fin de tener primero unidades, luego decenas, centenas, etc.
                //ESTO SOLO SIRVE PARA SUMA RESTA MULTIPLICACION

                for (int i = n1_str.length()-1; i>=0; i--) {
                    n1.add(Character.getNumericValue(n1_str.charAt(i))); //agregar numero a la lista de atras hacia adelante
                }
                for (int i = n2_str.length()-1; i>=0; i--) {
                    n2.add(Character.getNumericValue(n2_str.charAt(i))); //agregar numero a la lista de atras hacia adelante
                }
            }
                break;
            case "/": {
                //En este caso si se agregan en orden
                for (int i = 0; i < n1_str.length() - 1; i++) {
                    n1.add(Character.getNumericValue(n1_str.charAt(i))); //agregar numero a la lista de atras hacia adelante
                }
                for (int i = 0; i < n2_str.length() - 1; i++) {
                    n2.add(Character.getNumericValue(n2_str.charAt(i))); //agregar numero a la lista de atras hacia adelante
                }
            }
                break;
        }


    }
}
