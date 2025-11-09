import java.util.*;
import java.util.stream.Collectors;

public class Polyline {
    private List<Point> points;

    public Polyline() { // Конструктор создает пустую ломаную линию
        this.points = new ArrayList<>(); // Пустой список точек
    }

    // Конструктор создает ломаную линию из готового списка точек
    public Polyline(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    // Основной метод для обработки точек
    public static Polyline processPoints(List<Point> inputPoints) {
        List<Point> result = inputPoints.stream() // Создаем поток из входных точек
                .distinct() // Убираем дубликаты
                .sorted(Comparator.comparingDouble(Point::getX)) // Сортируем по X
                .map(p -> new Point(p.getX(), Math.abs(p.getY()))) // Делаем Y положительным
                .collect(Collectors.toList()); // Собираем результат обратно в список
        return new Polyline(result);
    }

    public int getPointCount() { // Геттер для количества точек в ломаной линии
        return points.size();
    }

    public boolean isEmpty() { // Метод для проверки пустая ли ломаная линия
        return points.isEmpty();
    }

    @Override
    public String toString() { // Метод для строкового представления ломаной линии
        if (points.isEmpty()) {
            return "Ломаная линия: нет точек";
        }
        return points.stream()
                .map(Point::toString) // Преобразуем каждую точку в строку
                .collect(Collectors.joining(" -> ", "Ломаная линия: ", ""));
    }
}