import java.util.*;
public class SingleLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SingleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(T addFirst){
        Node<T> newNode = new Node<>(addFirst);
        newNode.next = head;
        head = newNode;

        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(T addLast){
        Node<T> newNode = new Node<>(addLast);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size ++;
    }

    public T removeFirst(){
        if (isEmpty()) throw new NoSuchElementException();
        T value = head.data;
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return value;
    }

    public T removeLast(){
        if (isEmpty()) throw new NoSuchElementException();

        if(size == 1) {
            T value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }

        Node<T> current = head;
        while (current.next != head){
            current = current.next;
        }

        T value = tail.data;
        tail = current;
        tail.next = null;
        size--;
        return value;

    }

    public T getFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        return head.data;
    }

    public T getLast(){
        if(isEmpty()) throw new NoSuchElementException();
        return tail.data;
    }

    public boolean isEmpty(){
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void insert(int index, T insert){
        if(index <= 0){
            addFirst(insert);
            return;
        }

        if (index >= size) {
            addLast(insert);
            return;
        }

        Node <T> newNode = new Node<>(insert);
        Node<T> current = head;

        for(int i = 0; i < index - 1; i++){
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public boolean remove(int index) {
        if(index < 0 || index >= size) return false;
        
        if(index == 0){
            removeFirst();
            return true;
        }

        Node<T> current = head;
        for(int i = 0; i < index - 1; i++){
            current = current.next;
        }

        if (current.next == tail){
            tail = current;
        }

        current.next = current.next.next;
        size--;
        return true;
    }

    public int find(T find) {
        Node<T> current = head;
        int index = 0;

        while (current != null){
            if(current.data.equals(find)){
                return index;
            }
            current = current.next;
            index++;
        }
        return size;
    }
}
