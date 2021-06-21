package Stack;


//스택 자료구조를 사용하여 정렬하기
public class StackSort {
    public static void main(String[] args){
        Stack<Integer> s1 = new Stack<Integer>();
        s1.push(1);
        s1.push(3);
        s1.push(5);
        sort(s1);
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
    }

    private  static void sort(Stack<Integer> s1){
        Stack<Integer> s2 = new Stack<Integer>();
        while(!s1.isEmpty()){
            int tmp = s1.pop();
            while(!s2.isEmpty() && s2.peek() > tmp){
                s1.push(s2.pop());
            }
            s2.push(tmp);
        }

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

}
