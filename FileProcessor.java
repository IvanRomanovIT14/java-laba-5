package ru.Romanov.task8;

import java.util.*;
import java.nio.file.*;
import java.util.stream.Collectors;

public class FileProcessor {
    // Метод для работы с файлом
    public static Map<Integer, List<String>> processNamesFile(String filename) throws Exception {
        if (filename == null || filename.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя файла не может быть пустым!");
        }
        Path filePath = Paths.get(filename);
        if (!Files.exists(filePath)) {
            throw new IllegalArgumentException("Файл не существует: " + filename);
        }
        return Files.lines(filePath)
                .filter(line -> !line.trim().isEmpty())
                .map(line -> line.split(":"))
                .filter(parts -> parts.length == 2)
                .map(parts -> new String[]{formatName(parts[0].trim()), parts[1].trim()})
                .filter(parts -> !parts[1].isEmpty())
                .collect(Collectors.toMap(
                        parts -> parseNumber(parts[1]),
                        parts -> new ArrayList<>(List.of(parts[0])),
                        (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        }
                ))
                .entrySet().stream()
                .filter(entry -> entry.getKey() != null)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }

    // Метод для форматирования имени
    private static String formatName(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    // Метод для преобразования строки в число
    private static Integer parseNumber(String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
