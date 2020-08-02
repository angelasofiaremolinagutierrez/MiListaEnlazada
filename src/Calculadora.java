import co.edu.upb.list.List;
import co.edu.upb.list.ListNode;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List n1 = new List();
        List n2 = new List();
        List res;

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

                List inv = suma(n1,n2);
                String invStr = inv.listAsString();

                StringBuilder input = new StringBuilder();
                input.append(invStr);
                input = input.reverse();

                System.out.println(input);

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




            }
                break;

            case "*":{ //todo to fix!!
                //se agregan así con el fin de tener primero unidades, luego decenas, centenas, etc.
                //ESTO SOLO SIRVE PARA SUMA RESTA MULTIPLICACION

                for (int i = n1_str.length()-1; i>=0; i--) {
                    n1.add(Character.getNumericValue(n1_str.charAt(i))); //agregar numero a la lista de atras hacia adelante
                }
                for (int i = n2_str.length()-1; i>=0; i--) {
                    n2.add(Character.getNumericValue(n2_str.charAt(i))); //agregar numero a la lista de atras hacia adelante
                }

                ListNode nodeRec1 = n1.head; //abajo


                List sumaListas = new List();
                int digito1;
                int digito2;
                int cont = 0;
                while(nodeRec1 != null){
                    digito1 = (int) n1.get(nodeRec1);

                    int lleva = 0;
                    List temp = new List();
                    for (int i = 0; i <cont ; i++) {
                        temp.add(0);
                    }
                    ListNode nodeRec2 = n2.head; //arriba
                    while (nodeRec2 != null){
                        digito2 = (int) n2.get(nodeRec2);

                        int resTemp = (digito1*digito2)+lleva;
                        lleva = 0;
                        if (resTemp >= 10) {
                            String resStr = String.valueOf(resTemp);
                            lleva = Character.getNumericValue(resStr.charAt(0));
                            resTemp = Character.getNumericValue(resStr.charAt(1));
                        }
                        temp.add(resTemp);

                        nodeRec2 = nodeRec2.next;
                    }
                    cont++;
                    sumaListas = suma(sumaListas,temp);
                    nodeRec1 = nodeRec1.next;
                }

                String invStr = sumaListas.listAsString();

                StringBuilder input = new StringBuilder();
                input.append(invStr);
                input = input.reverse();

                System.out.println(input);

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

    public static List suma(List n1, List n2){ //n1 y n2 deben estar al reves!
        List res = new List();

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

        return res;
    }
}
