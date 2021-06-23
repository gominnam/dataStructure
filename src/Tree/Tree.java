package Tree;

class Node{
    int data;
    Node left;
    Node right;
}

public class Tree {
    public Node root;

    public void setRoot(Node node){
        this.root = node;
    }

    public Node getRoot(){
        return root;
    }

    public Node makeNode(Node left, int data, Node right){
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }

    public void inorder(Node node){
        if(node != null){
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }

    public void preorder(Node node){
        if(node != null){
            System.out.println(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(Node node){
        if(node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.data);
        }
    }
}

class Test{
    public static void main(String[] args){
        Tree t = new Tree();
        Node n4 = t.makeNode(null, 4, null);
        Node n5 = t.makeNode(null, 5, null);
        Node n2 = t.makeNode(n4, 2, n5);
        Node n3 = t.makeNode(null, 3, null);
        Node n1 = t.makeNode(n2, 1, n3);

        t.setRoot(n1);
        //t.inorder(t.getRoot());// 4 2 5 1 3
        //t.preorder(t.getRoot());// 1 2 4 5 3
        t.postorder(t.getRoot()); // 4 5 2 3 1
    }
}

/*
    #, Tree

//부모 - 자식 관계로 정의하고, 부모에서 자식으로 간선이 이어져 있는 유향 그래프이다.
//자료구조에서의 트리는 부모가 없는 루트 노드를 정의한다.

 */