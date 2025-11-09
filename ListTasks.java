import java.util.*;

public class ListTasks {
    //Метод для удаления подряд идущих дубликатов из списка
    public static <T> List<T> remove(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("Список не может быть null!");
        }
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        // Создаем новый список для хранения результата без дубликатов
        List<T> result = new ArrayList<>();
        T previous = null;
        for (T current : list) {
            if (!current.equals(previous)) {
                result.add(current);
                previous = current;
            }
        }
        return result;
    }
}