package co.edu.upb.list;

public class ListNode {

    private Object object;
    public ListNode next;

    public ListNode(){
        this.object = null;
        this.next = null;
    }

    public ListNode(Object object){
        this.object = object;
        this.next = null;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "{" +
                "object=" + object +
                ", next=" + next +
                '}';
    }

    public boolean isEquals(ListNode nodo){ //si un nodo es igual a otro
        if(this.toString().equals(nodo.toString())){
            return true;
        }else{
            return false;
        }
    }
}
