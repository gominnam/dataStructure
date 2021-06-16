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

    //중복제거: 이중포인터로 구현 [ 공간-O(1), 시간-O(N^2) ]
    void removeDups(){
        Node n = header;
        while(n != null && n.next != null){
            Node r = n;
            while(r.next != null){
                if(n.data == r.next.data){
                    r.next = r.next.next;
                }
                else{
                    r = r.next;
                }
            }
            n = n.next;
        }
    }

    Node getFirst(){
        return header.next;
    }


}

//LinkedList Test Code
class LinkedListTest{
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        //LinkedList 기본 Test
        System.out.println("LinkedList Basic Action");//1->4
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.delete(2);
        ll.delete(3);
        ll.retrieve();

        //중복제거 Test
        System.out.println("LinkedList removeDups");//1->4->2->3
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(4);
        ll.removeDups();
        ll.retrieve();

        Reference r = new Reference();
        LinkedList.Node found = KthToLast(ll.getFirst(), 3, r);
        System.out.println(found.data);
    }

    //레퍼런스
    public static class Reference {
        public int count = 0;
    }

    //끝에서 k번째 값
    static LinkedList.Node KthToLast(LinkedList.Node n, int k, Reference r){
        if(n == null){
            return null;
        }

        LinkedList.Node found = KthToLast(n.next, k, r);
        r.count++;
        if(r.count == k)
            return n;

        return found;
    }
}

