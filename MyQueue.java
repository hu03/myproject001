import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyQueue<T> {

    private final LinkedList<T> link;

    public MyQueue() {
        link = new LinkedList<>();
    }

    // 入队
    public void enqueue(T element) {
        link.addLast(element);
    }

    // 出队
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("队列为空，无法出队");
        }
        return link.removeFirst();
    }

    // 查看队首元素
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("队列为空，无法查看队首元素");
        }
        return link.getFirst();
    }

    // 判断是否为空
    public boolean isEmpty() {
        return link.isEmpty();
    }

    // 获取队列长度
    public int size() {
        return link.size();
    }

    // 打印队列内容
    @Override
    public String toString() {
        return link.toString();
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 2, 5, 8, 6, 4, 7};
        MyQueue<Integer> queue = new MyQueue<>();

        System.out.println("入队:");
        for (Integer i : arr) {
            queue.enqueue(i);
            System.out.println("队列: " + queue);
        }

        System.out.println("\n出队:");
        while (!queue.isEmpty()) {
            System.out.println("出队元素: " + queue.dequeue());
            System.out.println("当前队列: " + queue);
        }
    }
}
