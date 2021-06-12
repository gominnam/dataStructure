
public class LinkedList {
    int data;
    LinkedList next = null;

    LinkedList(int d){
        this.data = d;
    }

    void append(int d){
        LinkedList end = new LinkedList(d);
        LinkedList n = this;

        while(n.next != null){
            n = n.next;
        }

        n.next = end;
    }

    void delete(int d){
        LinkedList n = this;

        while(n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
            }
            else{
                n = n.next;
            }
        }
    }

    void retrieve(){
        LinkedList n = this;

        while(n.next != null){
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data);//마지막 값
    }
}

//Test Code
class singlyLinkedList{
    public static void main(String[] args){
        LinkedList ll = new LinkedList(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.delete(2);
        ll.delete(3);
        ll.retrieve();
    }
}
