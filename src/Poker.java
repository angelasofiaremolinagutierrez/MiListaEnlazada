import co.edu.upb.list.List;
import co.edu.upb.list.ListNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Poker {

    public static void main(String[] args) {
        List baraja = new List();
        List palos = new List();
        palos.add("♥"); //corazones
        palos.add("♦"); //diamantes
        palos.add("♠"); //picas
        palos.add("♣"); //treboles

        ListNode p = palos.head;
        for (int j = 0; j < 4; j++) {
            String palo = (String) palos.get(p);
            baraja.add("A"+palo);
            for (int i = 2; i <11; i++) {
                baraja.add(String.valueOf(i)+palo);
            }
            baraja.add("J"+palo);
            baraja.add("Q"+palo);
            baraja.add("K"+palo);

            p = p.next;
        }
        System.out.println("Aquí está la baraja inicial ordenada:");
        baraja.printList();

        System.out.println("¿Qué desea realizar a continuación?");
        System.out.println("1. Revolver la baraja");
        System.out.println("2. Ordenar por un palo");

        Scanner scan = new Scanner(System.in);

        int op = Integer.parseInt(scan.nextLine());
        switch (op){
            case 1:{
                
            }
            break;
            case 2:{
                System.out.println("Por cual palo desea ordenar?");

            }
            break;
        }
    }
}
