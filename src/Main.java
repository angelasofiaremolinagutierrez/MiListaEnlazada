import co.edu.upb.list.List;
import co.edu.upb.list.ListNode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        List prueba = new List();
        prueba.add(1);
        prueba.add(2);
        prueba.add(3);
        prueba.add(5);

        System.out.println(printList(prueba));
        System.out.println('\n');
        System.out.println(prueba.insert(4,3));
        //System.out.println(prueba.remove(2));
        System.out.println('\n');
        System.out.println(printList(prueba));


        System.out.println("\n"+prueba.get(prueba.tail));

    }
    public static String printList(List lista){
        String str ="";
        ListNode nodoVar = lista.head;
        while (true){
            if(nodoVar.next != null){
                str += nodoVar.toString()+'\n';
                nodoVar = nodoVar.next;
            }
            else{
                str+=nodoVar.toString();
                break;
            }
        }
        return str;
    }
}
