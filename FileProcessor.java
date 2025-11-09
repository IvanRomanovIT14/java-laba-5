import java.util.*;
import java.nio.file.*;
import java.io.*;

public class FileProcessor {
    // Метод для обработки файла с именами
    public static Map<Integer, List<String>> processNamesFile(String filename) throws Exception {
        if (filename == null || filename.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя файла не может быть пустым!");
        }
        Path filePath = Paths.get(filename);
        if (!Files.exists(filePath)) {
            throw new IllegalArgumentException("Файл не существует: " + filename);
        }
        Map<Integer, List<String>> result = new HashMap<>(); // Храним число и список имён
        List<String> lines = Files.readAllLines(filePath);
        for (String line : lines) {
            if (line.trim().isEmpty()) // Пропускаем пустые строки
                continue;
            String[] parts = line.split(":"); // Разделяем строку на части по двоеточию
            if (parts.length == 2) {  // Обрабатываем только строки, которые содержат 2 части
                String name = formatName(parts[0].trim());
                String numberStr = parts[1].trim();
                if (!numberStr.isEmpty()) { // Проверяем, что строка с числом не пустая
                    try {
                        int number = Integer.parseInt(numberStr);
                        // Добавляем имя в карту, если нету то созадём новый список
                        result.computeIfAbsent(number, k -> new ArrayList<>()).add(name);
                        // Пропускаем строки с некорректными номерами
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        return result;
    }

    // Вспомогательный метод для форматирования имени
    private static String formatName(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        // Первая буква заглавная, остальные строчные
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}