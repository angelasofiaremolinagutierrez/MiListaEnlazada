import co.edu.upb.list.List;
import co.edu.upb.list.ListNode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        List prueba = new List();
        prueba.add(9);
        prueba.add(7);
        prueba.add(3);
        prueba.add(5);

        //Probando el recorrido recursivo
        prueba.recorrer(prueba.head);

        //finalizado
    }
}
