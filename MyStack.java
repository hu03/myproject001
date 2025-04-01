import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {

    private final List<T> array;


    public MyStack() {
        this.array = new ArrayList<>();
    }

    public void push(T element) {
        array.add(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T element = array.get(array.size() - 1);
        array.remove(element);
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array.get(array.size() - 1);
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        Integer[] arr = {2,5,89,36,7,4};
        for (Integer i : arr) {
            stack.push(i);
        }
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
