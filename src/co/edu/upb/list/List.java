package co.edu.upb.list;

import java.util.Iterator;

public class List implements ListInterface {

    public ListNode head;
    public ListNode tail;
    public int size = 0;

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
        return size;
    }

    @Override
    public void clear() {
        head.next = null;
        head = null;
        size = 0;
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
                if(nodoVar.getObject() != object){
                    nodoVar = nodoVar.next;
                }
                else{
                    return nodoVar;
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
    public boolean insert(ListNode node, Object object) {
        //to do
        size += 1;
        return false;
    }

    @Override
    public boolean insert(Object object, Object nodoAtras) {
        //este metodo es para insertar un objeto en frente de otro
        //object es el objeto a agregar
        //nodoAtras es el nodo de referencia para insertar al frente del él.
        try {
            if(isEmpty()){
                System.out.println("No hay objetos en la lista");
                return false;
            }else{
                ListNode anterior = search(nodoAtras);
                if (anterior==null){
                    System.out.println("El objeto de referencia no se encuentra en la lista");
                    return false;
                }else {
                    ListNode nuevoNodo = new ListNode(object);

                    nuevoNodo.next = anterior.next;
                    anterior.next = nuevoNodo;

                    size += 1;
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
            size += 1;
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
            size += 1;
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
        //to do
        return false;
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
                size -= 1;
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
    public boolean contains(Object object) {
        //to do
        return false;
    }

    @Override
    public boolean isEquals(Object object) {
        //to do
        return false;
    }

    @Override
    public Iterator<ListNode> iterator() {
        //to do
        return null;
    }

    @Override
    public Object[] toArray() {
        //to do
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] object) {
        //to do
        return new Object[0];
    }

    @Override
    public Object getBeforeTo() {
        //to do
        return null;
    }

    @Override
    public Object getBeforeTo(ListNode node) {
        //to do
        return null;
    }

    @Override
    public Object getNextTo() {
        //to do
        return null;
    }

    @Override
    public Object getNextTo(ListNode node) {
        //to do
        return null;
    }

    @Override
    public List subList(ListNode from, ListNode to) {
        //to do
        return null;
    }

    @Override
    public List sortList() {
        //to do
        return null;
    }


}
