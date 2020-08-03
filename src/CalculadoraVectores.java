import co.edu.upb.list.List;
import co.edu.upb.list.ListNode;

import java.util.Scanner;

public class CalculadoraVectores {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List v1 = new List();
        List v2 = new List();
        System.out.println("Ingrese la dimensión de sus vectores");
        int sizeV = Integer.parseInt(scan.nextLine());

        System.out.println("Ingrese las coordenadas del primer vector:");
        for (int i = 0; i <sizeV ; i++) {
            v1.add(Integer.parseInt(scan.nextLine()));
        }
        System.out.println("Tu vector 1:");
       v1.printList();

        System.out.println("Ingrese las coordenadas del segundo vector:");
        for (int i = 0; i <sizeV ; i++) {
            v2.add(Integer.parseInt(scan.nextLine()));
        }
        System.out.println("Tu vector 2:");
        v2.printList();

        System.out.println("Que operación quiere realizar con estos?");
        System.out.println("Escriba '+' para suma de vectores o '.' para producto escalar de vectores");

        String op = scan.nextLine();

        List res = new List();
        ListNode node1 = v1.head;
        ListNode node2 = v2.head;
        while(node1 != null){
            int dig1 = (int)v1.get(node1);
            int dig2 = (int)v2.get(node2);
            switch (op) {
                case "+": {
                    res.add(dig1+dig2);
                }
                break;
                case ".":{
                    res.add(dig1*dig2);
                }
                break;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        System.out.println("Vector resultante =");
        res.printList();
        //finalizado
    }
}
