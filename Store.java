import java.util.*;
import java.nio.file.*;
import java.io.*;

public class Store {
    private String company;
    private String street;
    private int fat;
    private int price;

    // Конструктор с пустыми значениями компании, улицы с жирностью 15 и ценой 2000
    public Store() {
        this.company = "";
        this.street = "";
        this.fat = 15;
        this.price = 2000;
    }

    // Конструктор создает магазин с заданными значениями
    public Store(String company, String street, int fat, int price) {
        setCompany(company);
        setStreet(street);
        setFat(fat);
        setPrice(price);
    }

    public String getCompany() { // Геттер для названия компани
        return company;
    }

    public void setCompany(String company) { // Сеттер для названия компани
        if (company == null || company.trim().isEmpty()) {
            throw new IllegalArgumentException("Название компании не может быть пустым!");
        }
        if (company.length() > 20) {
            throw new IllegalArgumentException("Название компании слишком длинное! Максимум 20 символов.");
        }
        this.company = company.trim();
    }

    public String getStreet() { // Геттер для названия улицы
        return street;
    }

    public void setStreet(String street) { // Сеттер для названия улицы
        if (street == null || street.trim().isEmpty()) {
            throw new IllegalArgumentException("Название улицы не может быть пустым!");
        }
        if (street.length() > 20) {
            throw new IllegalArgumentException("Название улицы слишком длинное! Максимум 20 символов.");
        }
        this.street = street.trim();
    }

    public int getFat() { // Геттер для жирности сметаны
        return fat;
    }

    public void setFat(int fat) { // Сеттер для жирности сметаны
        if (fat != 15 && fat != 20 && fat != 25) {
            throw new IllegalArgumentException("Жирность должна быть 15, 20 или 25%!");
        }
        this.fat = fat;
    }

    public int getPrice() { // Геттер для цены сметаны
        return price;
    }

    public void setPrice(int price) { // Сеттер для цены сметаны
        if (price < 2000 || price > 5000) {
            throw new IllegalArgumentException("Цена должна быть в диапазоне от 2000 до 5000 копеек!");
        }
        this.price = price;
    }

    @Override
    public String toString() { // Метод для строкового представления магазина
        return company + " " + street + " " + fat + "% " + price + " коп.";
    }

    @Override
    public boolean equals(Object obj) { // Метод для сравнения двух магазинов на равенство
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Store store = (Store) obj;
        return fat == store.fat && price == store.price &&
                Objects.equals(company, store.company) &&
                Objects.equals(street, store.street);
    }

    // Метод для чтения магазинов из файла
    public static List<Store> readFromFile(String filename) throws Exception {
        List<Store> stores = new ArrayList<>();
        Path filePath = Paths.get(filename); // Создаем путь к файлу
        if (!Files.exists(filePath)) {
            throw new IllegalArgumentException("Файл не существует: " + filename);
        }
        List<String> lines = Files.readAllLines(filePath);
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("Файл пуст");
        }
        // Первая строка - количество магазинов
        int storeCount = Integer.parseInt(lines.get(0).trim());
        // Обрабатываем остальные строки
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim(); // Получаем и обрезаем строку
            if (line.isEmpty()) // Пропускаем пустые строки
                continue;
            String[] parts = line.split(" ");
            if (parts.length < 4) {
                System.out.println("Пропускаем некорректную строку: " + line);
                continue;
            }
            try {
                StringBuilder companyBuilder = new StringBuilder(); // Собираем название магазина
                int j = 0;
                while (j < parts.length - 3) { // Собираем всё кроме улица, жирность, цена
                    if (companyBuilder.length() > 0)
                        companyBuilder.append(" ");
                    companyBuilder.append(parts[j]);
                    j++;
                }
                String company = companyBuilder.toString();
                String street = parts[j];
                int fat = Integer.parseInt(parts[j + 1]);
                int price = Integer.parseInt(parts[j + 2]);
                stores.add(new Store(company, street, fat, price));
            } catch (Exception e) {
                System.out.println("Ошибка в строке " + (i + 1) + ": " + line + " - " + e.getMessage());
            }
        }
        if (stores.size() != storeCount) {
            System.out.println("Внимание: заявлено " + storeCount + " магазинов, но прочитано " + stores.size());
        }
        return stores;
    }

    // Метод для группировки магазинов по жирности
    public static Map<Integer, List<Store>> groupByFat(List<Store> stores) {
        Map<Integer, List<Store>> groupedStores = new HashMap<>();
        for (Store store : stores) {
            int fat = store.getFat();
            // Если жирности нет в map создаём новый список
            groupedStores.computeIfAbsent(fat, k -> new ArrayList<>()).add(store);
        }
        return groupedStores;
    }

    // Метод для поиска минимальной цены в списке магазинов
    public static int findMinPrice(List<Store> stores) {
        if (stores == null || stores.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        int minPrice = Integer.MAX_VALUE;
        for (Store store : stores) {
            if (store.getPrice() < minPrice) {
                minPrice = store.getPrice();
            }
        }
        return minPrice;
    }

    // Метод для подсчета магазинов с заданной ценой
    public static int countStoresWithPrice(List<Store> stores, int targetPrice) {
        int count = 0;
        for (Store store : stores) {
            if (store.getPrice() == targetPrice) {
                count++;
            }
        }
        return count;
    }
}