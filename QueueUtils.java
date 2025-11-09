import java.util.*;

public class QueueUtils {
    // Метод для проверки равных соседних элементов в очереди
    public static <T> boolean equalNeighbors(Queue<T> queue) {
        if (queue == null) {
            throw new IllegalArgumentException("Очередь не может быть null!");
        }
        if (queue.isEmpty()) {
            return false;
        }
        Iterator<T> it = queue.iterator();
        T prev = it.next(); // Получаем первый элемент очереди и сохраняем его
        T first = prev; // Сохраням первый элемент чтобы сравнить с последним
        while (it.hasNext()) {
            T current = it.next();
            if (prev.equals(current)) {
                return true;
            }
            prev = current;
        }
        return prev.equals(first); // Проверяем первый с последним
    }
}