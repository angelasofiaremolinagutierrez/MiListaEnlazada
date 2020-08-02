package co.edu.upb.list;

import java.util.*;

public class List implements ListInterface, Iterable<ListNode> {

    public ListNode head;
    public ListNode tail;

    private ListNode inode;
    private int size = 0;

    public List() {
        this.head = null;
        this.tail = null;
    }

    public List(Object object) {
        add(object);
    }

    @Override
    public boolean isEmpty(){
        if(head == null){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        head.next = null;
        head = null;
        this.size = 0;
    }

    @Override
    public Object getHead() {
        return this.head;
    }

    @Override
    public Object getTail() {
        return this.tail;
    }

    @Override
    public Object get(ListNode node) {

        ListNode actual = this.head;

        while (true){
            if(actual.next != null){
                if(actual.toString().equals(node.toString())){
                    return actual.getObject();
                }
                else{
                    actual = actual.next;
                }
            }else{//si va en el ultimo
                if(actual.toString().equals(node.toString())){
                    return actual.getObject();
                }else{
                    System.out.println("Ese objeto no se encuentra en la lista");
                    return null;
                }
            }
        }
    }

    @Override
    public ListNode search(Object object){
        ListNode nodoVar = this.head;
        while (true){
            if(nodoVar.next != null){
                if(nodoVar.getObject().equals(object)){
                    return nodoVar;
                }
                else{
                    nodoVar = nodoVar.next;
                }
            }else{//si va en el ultimo
                if(nodoVar.getObject().equals(object)){
                    return nodoVar;
                }else{
                    System.out.println("Ese objeto no se encuentra en la lista");
                    return null;
                }
            }
        }
    }

    @Override
    public boolean add (Object object){
        return this.insertTail(object);
    }

    @Override
    public boolean insert(ListNode nodoAtras, Object object) {
        try {
            if(isEmpty()){
                System.out.println("No hay objetos en la lista");
                return false;
            }else{

                ListNode nuevoNodo = new ListNode(object);
                nuevoNodo.next = nodoAtras.next;
                nodoAtras.next = nuevoNodo;

                this.size += 1;
                return true;

            }
        }catch (NullPointerException e){
            System.out.println("Algo está nulo al remover: " + e);
            return false;
        }catch (Exception e){
            System.out.println("Hubo un error al eliminar el elemento");
            return false;
        }
    }

    @Override
    public boolean insert(Object object, Object objetoAtras) {
        //este metodo es para insertar un objeto en frente de otro
        //object es el objeto a agregar
        //nodoAtras es el nodo de referencia para insertar al frente del él.
        try {
            if(isEmpty()){
                System.out.println("No hay objetos en la lista");
                return false;
            }else{
                ListNode anterior = search(objetoAtras);
                if (anterior==null){
                    System.out.println("El objeto de referencia no se encuentra en la lista");
                    return false;
                }else {
                    ListNode nuevoNodo = new ListNode(object);

                    nuevoNodo.next = anterior.next;
                    anterior.next = nuevoNodo;

                    this.size += 1;
                    return true;
                }
            }
        }catch (NullPointerException e){
            System.out.println("Algo está nulo al remover: " + e);
            return false;
        }catch (Exception e){
            System.out.println("Hubo un error al eliminar el elemento");
            return false;
        }
    }

    @Override
    public boolean insertHead(Object object) {

        ListNode newHead = new ListNode(object);
        try {
            if(isEmpty()){
                this.head = newHead;
                this.tail = head;
            }else{
                newHead.next = this.head;
                head = newHead;
            }
            this.size += 1;
            return true;
        }catch (Exception e){
            System.out.println("Hubo un error al insertar por la cabeza el elemento");
            return false;
        }
    }

    @Override
    public boolean insertTail(Object object) {
        try {
            if(isEmpty()){
                this.head = new ListNode(object);
                this.tail = head;
            }else{
                tail.next = new ListNode(object);
                tail = tail.next;
            }
            this.size += 1;
            return true;
        }catch (NullPointerException e){
            System.out.println("Algo está nulo al agregar: " + e);
            return false;
        }catch (Exception e){
            System.out.println("Hubo un error al agregar el elemento");
            return false;
        }
    }

    @Override
    public boolean set(ListNode node, Object object) {
        try {
            ListNode actual = this.head;
            while (actual.next  != null){
                if((actual.toString().equals(node.toString()))){
                    actual.setObject(object);
                    break;
                }
                else{
                    actual = actual.next;
                }
            }
            return true;
        }catch (Exception e){
            System.out.println("Hubo un error al cambiar el elemento");
            return false;
        }
    }

    @Override
    public boolean remove(ListNode node) {
        try {
            if(isEmpty()){
                System.out.println("No hay nada que eliminar");
                return false;
            }else{
                ListNode actual = this.head;
                ListNode anterior = null;
                while (actual.next  != null){
                    if(!(actual.toString().equals(node.toString()))){
                        anterior = actual;
                        actual = actual.next;
                    }
                    else{
                        break;
                    }
                }

                if(anterior==null){
                    head = actual.next;
                    actual = null;
                }else{
                    anterior.next = actual.next;
                    actual = null;
                }
                this.size -= 1;
                return true;
            }
        }catch (NullPointerException e){
            System.out.println("Algo está nulo al remover: " + e);
            return false;
        }catch (Exception e){
            System.out.println("Hubo un error al eliminar el elemento");
            return false;
        }
    }

    //extensión

    @Override
    public boolean contains(Object object) {
        if(search(object)!=null){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public Iterator<ListNode> iterator() {
        inode = head;
        Iterator<ListNode> i = new Iterator<ListNode>() {
            @Override
            public boolean hasNext() {
                return inode.next != null ? true : false;
            }

            @Override
            public ListNode next() {
                if (hasNext()) {
                    ListNode tmp = inode;
                    inode = inode.next;
                    return tmp;
                } else {
                    return null;
                }
            }
        };
        return i;
    }

    //Nota: el is equals lo encontrará en ListNode.java

    @Override
    public Object[] toArray() {
        Object[] array =  new Object[this.getSize()];
        ListNode nodo = this.head;
        for (int i = 0; i <this.getSize() ; i++) {
            array[i] = nodo;
            nodo = nodo.next;
        }
        return array;
    }

    @Override
    public Object[] toArray(Object[] array) {
        ListNode nodo = this.head;
        for (int i = 0; i <this.getSize() ; i++) {
            array[i] = nodo;
            nodo = nodo.next;
        }
        return array;
    }

    @Override
    public Object getBeforeTo() {
        //suponiendo que el metodo es obtener el anterior a todo
        return this.getHead();
    }

    @Override
    public Object getBeforeTo(ListNode node) {
        ListNode actual = this.head;
        ListNode anterior = null;

        while (true){
            if(actual.next  != null){
                if(actual.toString().equals(node.toString())){
                    if(anterior==null){
                        return null;
                    }else{
                        return anterior.getObject();
                    }
                }
                else{
                    anterior = actual;
                    actual = actual.next;
                }
            }else{
                if(actual.toString().equals(node.toString())){
                    return anterior.getObject();
                }else{
                    break;
                }
            }

        }
        return null;
    }

    @Override
    public Object getNextTo() {
        //suponiendo que el metodo es obtener el siguiente a todo
        return this.getTail();
    }

    @Override
    public Object getNextTo(ListNode node) {
        ListNode actual = this.head;
        while (actual.next  != null){
            if((actual.toString().equals(node.toString()))){
                return actual.next.getObject();
            }
            else{
                actual = actual.next;
            }
        }

        return null;
    }

    @Override
    public List subList(ListNode from, ListNode to) {
        List lista = new List();
        ListNode n = head;
        while (n.next != null){
            if(n.equals(from)){
                lista.add(n.getObject());
                while (true){
                    n=n.next;
                    if (!n.equals(null)){
                        if(n.equals(to)){
                            lista.add(n.getObject());
                            return lista;
                        }else{
                            lista.add(n.getObject());
                        }
                    }else{
                        System.out.println("El nodo final que ingresó no existe en la lista");
                        return null;
                    }
                }

            }else{
                n = n.next;
            }
        }
        System.out.println("El nodo inicial que ingresó no existe en la lista");
        return null;


    }

    @Override
    public List sortList() {

        Object[] listaAOrdenar = this.toArray();

        //todo fix!!
        /*
        Arrays.sort(listaAOrdenar,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode t1, ListNode t2) {
                return ((t1.getObject().toString()).compareTo(t2.getObject().toString()));
                }
            }
        });
*/

        List listaOrdenada = new List();

        ListNode n = head;
        while (true){
            if (!n.next.equals(null)){
                listaOrdenada.add(n.getObject());
                n = n.next;
            }else{
                listaOrdenada.add(n.getObject());
                break;
            }
        }
        return listaOrdenada;
    }

    //1. metodo para recorrer de forma recursiva

    public void recorrer(ListNode node){
        if (node.next == null){
            System.out.println(node.toString());
        }else {
            System.out.println(node.toString());
            recorrer(node.next);
        }
    }

    public void printList(){
        String str ="";
        if(isEmpty()){
            System.out.println("La lista está vacía");
        }else{
            ListNode nodoVar = head;
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

            System.out.println(str);
        }

    }

    public String listAsString(){
        String str ="";

        ListNode nodoVar = head;
        while (true){
            if(nodoVar != null){
                str += nodoVar.getObject().toString();
                nodoVar = nodoVar.next;
            }
            else{
                break;
            }
        }

        return (str);
    }
}
