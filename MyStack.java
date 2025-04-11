import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MyStack<T> {

    private final List<T> array;

    public MyStack() {
        this.array = new ArrayList<>();
    }

    // 入栈
    public void push(T element) {
        array.add(element);
    }

    // 出栈
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array.remove(array.size() - 1);
    }

    // 查看栈顶元素
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array.get(array.size() - 1);
    }

    // 判断是否为空
    public boolean isEmpty() {
        return array.isEmpty();
    }

    // 获取栈的大小
    public int size() {
        return array.size();
    }

    // 打印栈内容
    @Override
    public String toString() {
        return array.toString();
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        Integer[] arr = {2, 5, 89, 36, 7, 4};

        System.out.println("入栈:");
        for (Integer i : arr) {
            stack.push(i);
            System.out.println("栈状态: " + stack);
        }

        System.out.println("\n弹出元素:");
        while (!stack.isEmpty()) {
            System.out.println("弹出: " + stack.pop());
            System.out.println("当前栈: " + stack);
        }

        // 再次 peek 测试异常处理
        try {
            System.out.println(stack.peek());
        } catch (EmptyStackException e) {
            System.out.println("错误: " + e.getMessage());
        }
    }
}
