import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберите номер задания 1-8: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Введите первую дробь:");
                        System.out.print("Числитель: ");
                        int num1 = Valid.getInt();
                        System.out.print("Знаменатель: ");
                        int den1 = Valid.getInt();
                        Fraction fraction1 = new Fraction(num1, den1);
                        FractionCache cache1 = new FractionCache();
                        System.out.println("Введите вторую дробь:");
                        System.out.print("Числитель: ");
                        int num2 = Valid.getInt();
                        System.out.print("Знаменатель: ");
                        int den2 = Valid.getInt();
                        Fraction fraction2 = new Fraction(num2, den2);
                        FractionCache cache2 = new FractionCache();
                        cache1.setNumeratorCache((double)fraction1.getNumerator());
                        cache1.setDenominatorCache((double)fraction1.getDenominator());
                        cache1.setRealValueCache(fraction1.getRealValue());
                        cache2.setNumeratorCache((double)fraction2.getNumerator());
                        cache2.setDenominatorCache((double)fraction2.getDenominator());
                        cache2.setRealValueCache(fraction2.getRealValue());
                        System.out.println("Дробь 1: " + fraction1 + " = " + cache1.getRealValueCache());
                        System.out.println("Дробь 2: " + fraction2 + " = " + cache2.getRealValueCache());
                        System.out.println("Дробь 1 = Дробь 2: " + fraction1.equals(fraction2));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Введите имя кота: ");
                        String catName = Valid.getString("Имя кота");
                        Cat cat = new Cat(catName);
                        System.out.println("Создан: " + cat);
                        System.out.print("Сколько раз должен мяукнуть кот: ");
                        int meowCount = Valid.getInt();
                        cat.meow(meowCount);
                        int count = cat.getMeowCount();
                        int result = count;
                        System.out.println("Кот мяукал: " + result + " раз");
                        System.out.println("Вызов мяуканья у каждого объекта");
                        Cat cat1 = new Cat("Барсик");
                        Cat cat2 = new Cat("Мурзик");
                        Collection<Meowable> catsCollection = new ArrayList<>();
                        catsCollection.add(cat1);
                        catsCollection.add(cat2);
                        catsCollection.add(cat1);
                        catsCollection.add(cat2);
                        catsCollection.add(cat1);
                        Funs.meowsCare(catsCollection);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        List<String> list = new ArrayList<>();
                        System.out.print("Введите количество элементов в списке: ");
                        int elementCount = Valid.getInt();
                        System.out.println("Введите элементы списка:");
                        for (int i = 0; i < elementCount; i++) {
                            System.out.print("Элемент " + (i + 1) + ": ");
                            String element = scanner.nextLine();
                            list.add(element);
                        }
                        System.out.println("Исходный список: " + list);
                        List<String> result = ListTasks.remove(list);
                        System.out.println("Список после удаления подряд идущих дубликатов: "
                                + result);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Введите имя файла с данными о магазинах: ");
                        String filename = scanner.nextLine();
                        List<Store> stores = Store.readFromFile(filename);
                        for (int i = 0; i < stores.size(); i++) {
                            Store store = stores.get(i);
                            System.out.println((i + 1) + ". " + store);
                        }
                        Map<Integer, List<Store>> groupedStores = Store.groupByFat(stores);
                        for (Map.Entry<Integer, List<Store>> entry : groupedStores.entrySet()) {
                            System.out.println("Жирность " + entry.getKey() + "%: " +
                                    entry.getValue().size() + " магазинов");
                            for (Store store : entry.getValue()) {
                                System.out.println("  - " + store.getCompany() + " - " +
                                        store.getPrice() + " коп.");
                            }
                        }
                        int[] cheapestCounts = StoreAnalyzer.findCheapestSourCream(stores);
                        System.out.println("Количество магазинов с самой дешевой сметаной:");
                        System.out.println("15%: " + cheapestCounts[0] + " магазинов");
                        System.out.println("20%: " + cheapestCounts[1] + " магазинов");
                        System.out.println("25%: " + cheapestCounts[2] + " магазинов");
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.print("Введите имя файла с текстом: ");
                        String filename = scanner.nextLine();
                        Set<Character> digits = TextAnalyzer.findDigitsInText(filename);
                        if (digits.isEmpty()) {
                            System.out.println("В тексте не найдено цифр.");
                        } else {
                            List<Character> sortedDigits = new ArrayList<>(digits);
                            Collections.sort(sortedDigits);
                            System.out.println("Цифры, встречающиеся в тексте: " + sortedDigits);
                        }
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        Queue<String> queue = new LinkedList<>();
                        System.out.print("Введите количество элементов в очереди: ");
                        int elementCount = Valid.getInt();
                        System.out.println("Введите очереди списка:");
                        ;
                        for (int i = 0; i < elementCount; i++) {
                            System.out.print("Элемент " + (i + 1) + ": ");
                            String element = scanner.nextLine();
                            queue.add(element);
                        }
                        System.out.println("Исходная очередь: " + queue);
                        boolean hasEqual = QueueUtils.equalNeighbors(queue);
                        System.out.println("Есть соседние одинаковые элементы: " + hasEqual);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        System.out.print("Введите количество точек: ");
                        int count = scanner.nextInt();
                        List<Point> points = new ArrayList<>();
                        for (int i = 0; i < count; i++) {
                            System.out.println("Точка " + (i + 1) + ":");
                            double x = Point.correctDouble(scanner, "Введите координату X: ");
                            double y = Point.correctDouble(scanner, "Введите координату Y: ");
                            points.add(new Point(x, y));
                        }
                        System.out.println("Исходные точки: " + points);
                        System.out.println("Количество точек: " + points.size());
                        Polyline processedPolyLine = Polyline.processPoints(points);
                        System.out.println(processedPolyLine);
                        System.out.println("Количество точек после обработки: " +
                                processedPolyLine.getPointCount());
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        System.out.print("Введите имя файла с именами: ");
                        String filename = scanner.nextLine();
                        Map<Integer, List<String>> result = FileProcessor.
                                processNamesFile(filename);
                        System.out.println("Результат группировки:");
                        for (Map.Entry<Integer, List<String>> entry : result.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Вводить можно только число 1-8!");
            }
        } else {
            System.out.println("Вводить можно только число 1-8!");
        }
    }
}
