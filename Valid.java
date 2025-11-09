import java.util.Scanner;

public class Valid {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt() { // Проверка на целое число
        while (true) {
            try {
                int value = scanner.nextInt();
                return value;
            } catch (Exception e) {
                System.out.print("Ошибка! Введите целое число: ");
                scanner.nextLine();
            }
        }
    }

    public static String getString(String fieldName) { // Проверка на ввод строки
        while (true) {
            try {
                String value = scanner.nextLine().trim();
                if (value.isEmpty()) {
                    System.out.print("Ошибка! " + fieldName + " не может быть пустым: ");
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.print("Ошибка ввода! Попробуйте снова: ");
            }
        }
    }
}
