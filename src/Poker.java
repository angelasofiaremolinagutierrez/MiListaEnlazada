import co.edu.upb.list.List;
import co.edu.upb.list.ListNode;
import java.util.Scanner;

public class Poker {

    public static void main(String[] args) {
        List baraja = new List();
        List palos = new List();
        palos.add("♥"); //corazones
        palos.add("♦"); //diamantes
        palos.add("♠"); //picas
        palos.add("♣"); //treboles
        //♥C ♦D ♠P ♣T

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

        boolean flag = true;
        while (flag){
            System.out.println("¿Qué desea realizar a continuación?");
            System.out.println("1. Revolver la baraja");
            System.out.println("2. Ordenar por un palo");
            System.out.println("3. Salir");

            Scanner scan = new Scanner(System.in);

            int op = Integer.parseInt(scan.nextLine());
            switch (op){
                case 1:{
                    System.out.println("Aquí está su baraja revuelta:");
                    baraja.shuffle().printList();
                }
                break;
                case 2:{
                    System.out.println("Por cual palo desea ordenar?");
                    System.out.println("Escriba 'C' para ♥, 'D' para ♦, 'P' para ♠, o 'T' para ♣:" );
                    String palo = scan.nextLine().toUpperCase();
                    List suit = new List();
                    ListNode nodeBar = baraja.head;
                    while (nodeBar != null){
                        if(palo.equals("C")){
                            if((baraja.get(nodeBar)).toString().contains("♥")){
                                suit.add(baraja.get(nodeBar));
                            }
                        }else if(palo.equals("D")){
                            if((baraja.get(nodeBar)).toString().contains("♦")){
                                suit.add(baraja.get(nodeBar));
                            }
                        }else if(palo.equals("P")){
                            if((baraja.get(nodeBar)).toString().contains("♠")){
                                suit.add(baraja.get(nodeBar));
                            }
                        }else if(palo.equals("T")){
                            if((baraja.get(nodeBar)).toString().contains("♣")){
                                suit.add(baraja.get(nodeBar));
                            }
                        }else{
                            System.out.println("Ese palo no existe, intente de nuevo");
                        }
                        nodeBar = nodeBar.next;
                    }

                    System.out.println("Aqui esta el palo ordenado");
                    suit.sortList().printList(); //todo to fix: este sort ordena por strings no el orden de la baraja
                }
                break;
                case 3:{
                    flag = false;
                    break;
                }
                default:{
                    System.out.println("Esa no es una opción intente de nuevo");
                    break;
                }
            }
        }


    }
}
