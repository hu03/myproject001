import java.util.LinkedList;

public class MyQueue<T> {

    private final LinkedList<T> link;
    public MyQueue() {
        link = new LinkedList<>();
    }

    public void enqueue(T element) {
        link.add(element);
    }

    public T dequeue() {
        T element = link.getFirst();
        link.removeFirst();
        return element;
    }

    public Boolean isEmpty() {
        return link.isEmpty();
    }

    public static void main(String[] args) {
        Integer[] arr = {3,2,5,8,6,4,7};
        MyQueue<Integer> queue = new MyQueue<>();
        for (Integer i : arr) {
            queue.enqueue(i);
        }
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
