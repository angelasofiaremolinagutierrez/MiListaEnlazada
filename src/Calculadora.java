import co.edu.upb.list.List;
import co.edu.upb.list.ListNode;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List n1 = new List();
        List n2 = new List();

        System.out.println("Ingrese el primer numero mayor a treinta digitos");
        String n1_str = scan.nextLine();


        System.out.println("Ingrese el segundo numero mayor a treinta digitos");
        String n2_str = scan.nextLine();

        System.out.println("Que operación quiere realizar con estos? (Escriba +,-,*,/)");


        String op = scan.nextLine();

        //se agregan así con el fin de tener primero unidades, luego decenas, centenas, etc.

        for (int i = n1_str.length()-1; i>=0; i--) {
            n1.add(Character.getNumericValue(n1_str.charAt(i))); //agregar numero a la lista de atras hacia adelante
        }
        for (int i = n2_str.length()-1; i>=0; i--) {
            n2.add(Character.getNumericValue(n2_str.charAt(i))); //agregar numero a la lista de atras hacia adelante
        }

        switch (op){
            case "+": {
                List inv = suma(n1,n2);
                System.out.println(inv.inverse().listAsString());
            }
                break;

            case "-": {
                List inv = resta(n1,n2);
                System.out.println(inv.inverse().listAsString());
                /*
                if(esMayor(n1,n2) == -1){
                    System.out.println("-"+input);
                }else {
                    System.out.println(input);
                }
                */
            }
                break;

            case "*":{
                List res = multiplicacion(n1,n2);
                System.out.println(res.inverse().listAsString());
            }
                break;
            case "/": { //todo
                List res = division(n1,n2);
                System.out.println(res.inverse().listAsString());
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

    public static List resta(List n1,List n2){
        List res = new List();

        List may = new List();
        List men = new List();

        int presta = 0;
        int digito1;
        int digito2;

        if(esMayor(n1,n2) == 1){
            may.head = n1.head;
            may.tail = n1.tail;
            men.head = n2.head;
            men.tail = n2.tail;
        }else if(esMayor(n1,n2) == 0) {
            res.add(0);
            return res;
        }else{
            may.head = n2.head;
            may.tail = n2.tail;
            men.head = n1.head;
            men.tail = n1.tail;
        }

        ListNode nMay = may.head;
        ListNode nMen = men.head;
        while (nMay != null) {

            digito1 =((int) may.get(nMay)) - presta;
            presta = 0;

            if (nMen == null) {
                digito2 = 0;
            } else {
                digito2 = (int) men.get(nMen);
            }

            int resActual;
            if (digito1<digito2){
                resActual = (digito1 + 10) - digito2 ;
                presta = 1;
            }else{
                resActual = digito1 - digito2 ;
            }
            res.add(resActual);

            nMay = nMay.next;

            if (nMen == null) {
                digito2 = 0;
            } else {
                nMen = nMen.next;
            }
        }
        while((int)res.tail.getObject() == 0){
            if(res.getSize() == 1){
                break;
            }
            res.remove(res.tail);
        }

        if(esMayor(n1,n2) != 1){
            res.set(res.tail,(int)(res.tail.getObject())*-1);
        }
        return res;
    }

    public static List multiplicacion(List n1,List n2){
        ListNode nodeRec2 = n2.head; //abajo

        List sumaListas = new List();
        int digito1;
        int digito2;
        int cont = 0;
        while(nodeRec2 != null){
            digito2 = (int) n2.get(nodeRec2);

            int lleva = 0;
            List temp = new List();
            for (int i = 0; i <cont ; i++) {
                temp.add(0);
            }
            ListNode nodeRec1 = n1.head; //arriba
            while (nodeRec1 != null){
                digito1 = (int) n1.get(nodeRec1);

                int resTemp = (digito1*digito2)+lleva;
                lleva = 0;
                if (resTemp >= 10) {
                    String resStr = String.valueOf(resTemp);
                    lleva = Character.getNumericValue(resStr.charAt(0));
                    resTemp = Character.getNumericValue(resStr.charAt(1));
                }
                temp.add(resTemp);

                nodeRec1 = nodeRec1.next;
            }
            if(lleva != 0){
                temp.add(lleva);
            }
            cont++;
            sumaListas = suma(sumaListas,temp);
            nodeRec2 = nodeRec2.next;
        }

        return sumaListas;
    }

    public static List division(List n1,List n2){
        List res = new List(0);
        if(esMayor(n1,n2)==1){
            List resta = resta(n1,n2);;
            while (true){
                if((((int)resta.get(resta.head))== 0) && (resta.getSize() == 1)){
                    break;
                }else{
                    if(((int)resta.get(resta.head))<0){
                        break;
                    }else{
                        resta = resta(resta,n2);
                        res = suma(res,new List(1));
                    }
                }
            }
            return res;
        }else if(esMayor(n1, n2)==0){ //si son iguales
            res = new List(1);
            return res;
        }else{
            return res;
        }
    }

    public static int esMayor(List n1,List n2){ //n1 es mayor que n2? = 1; //n2 es mayor que n1? = -1 // n1 es igual a n2 = 0
        if(n1.getSize()>n2.getSize()){//n1>n2
            return 1;
        }else if(n1.getSize()<n2.getSize()){//n2>n1
            return -1;
        }else{ //si son de igual tamaño, toca ver
            if(n1.toString().equals(n2.toString())){
                return 0;
            }else{
                ListNode h1 = n1.head;
                ListNode h2 = n2.head;
                while (h1 != null){
                    if(((int)h1.getObject())>((int)h2.getObject())){
                        return 1;
                    }else if(((int)h1.getObject())<((int)h2.getObject())){
                        return -1;
                    }else{
                        h1 = h1.next;
                        h2 = h2.next;
                    }
                }
                return 0;
            }
        }
    }
}
