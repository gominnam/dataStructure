package Stack;
import java.util.Stack;

class MyQueue<T>{
    Stack<T> stackNewest, stackOldest;
    MyQueue(){
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    public int size(){
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value){
        stackNewest.push(value);
    }
    private void shiftStacks(){
        if(stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek(){
        shiftStacks();
        return stackOldest.peek();
    }

    public T remove(){
        shiftStacks();
        return stackOldest.pop();
    }
}

//2개의 stack으로 queue 구현하기
public class StackMakeQueue {
    public static void main(String[] args){
        MyQueue<Integer> q = new MyQueue<Integer>();
        q.add(1);
        q.add(3);
        q.add(5);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
