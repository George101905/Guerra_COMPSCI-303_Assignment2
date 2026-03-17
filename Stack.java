import java.util.*;
public class Stack {
    private ArrayList<Integer> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public void push(int value) {
        list.add(value);
    }

    public int pop(){
        if (isEmpty()) throw new EmptyStackException();
        return list.remove(list.size() - 1);
    }

    public int peek(){
        if (isEmpty()) throw new EmptyStackException();
        return list.get(list.size() - 1);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public double average(){
        if (isEmpty()) throw new EmptyStackException();

        int sum = 0;
        for(int num : list) {
            sum += num;
        }
        return (double)sum/list.size();
    }
}
