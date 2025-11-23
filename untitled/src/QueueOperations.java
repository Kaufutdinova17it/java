import java.util.*;

public class QueueOperations {
    public static <T> void printQueueReverse(Queue<T> queue) {
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста");
            return;
        }

        Stack<T> stack = new Stack<>();
        for (T element : queue) {
            stack.push(element);
        }

        System.out.print("Очередь в обратном порядке: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}