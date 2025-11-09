import java.util.*;
import java.nio.file.*;

public class TextAnalyzer {
    // Метод для поиска цифр в файле
    public static Set<Character> findDigitsInText(String filename) throws Exception {
        if (filename == null || filename.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя файла не может быть пустым!");
        }
        Path filePath = Paths.get(filename);
        if (!Files.exists(filePath)) {
            throw new IllegalArgumentException("Файл не существует: " + filename);
        }
        String text = Files.readString(filePath); // Читаем всё содержимое файла в одну строку
        Set<Character> digits = new HashSet<>(); // Для хранения уникальных цифр
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.add(c);
            }
        }
        return digits;
    }
}