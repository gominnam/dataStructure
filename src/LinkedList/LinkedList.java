package LinkedList;

public class LinkedList {
    Node header;

    static class Node{
        int data;
        Node next = null;
    }

    //생성자: 생성시 header 생성
    LinkedList(){
        header = new Node();
    }

    //추가
    void append(int d){
        Node end = new Node();
        end.data = d;
        Node n = header;

        while(n.next != null){
            n = n.next;
        }

        n.next = end;
    }

    //삭제
    void delete(int d){
        Node n = header;

        while(n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
            }
            else{
                n = n.next;
            }
        }
    }

    //값 회수: toString() 같은 기능
    void retrieve(){
        Node n = header.next;

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
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.delete(2);
        ll.delete(3);
        ll.retrieve();
    }
}
