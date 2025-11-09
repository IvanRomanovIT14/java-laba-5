import java.util.*;

public class StoreAnalyzer {
    // Метод для поиска количества магазинов с самой дешевой сметаной по каждой жирности
    public static int[] findCheapestSourCream(List<Store> stores) {
        if (stores == null) {
            throw new IllegalArgumentException("Список магазинов не может быть null!");
        }
        Map<Integer, List<Store>> storesByFat = Store.groupByFat(stores);
        int count15 = 0;
        int count20 = 0;
        int count25 = 0;
        if (storesByFat.containsKey(15)) {
            List<Store> fat15Stores = storesByFat.get(15);
            int minPrice15 = Store.findMinPrice(fat15Stores);
            count15 = Store.countStoresWithPrice(fat15Stores, minPrice15);
        }
        if (storesByFat.containsKey(20)) {
            List<Store> fat20Stores = storesByFat.get(20);
            int minPrice20 = Store.findMinPrice(fat20Stores);
            count20 = Store.countStoresWithPrice(fat20Stores, minPrice20);
        }
        if (storesByFat.containsKey(25)) {
            List<Store> fat25Stores = storesByFat.get(25);
            int minPrice25 = Store.findMinPrice(fat25Stores);
            count25 = Store.countStoresWithPrice(fat25Stores, minPrice25);
        }
        return new int[]{count15, count20, count25};
    }
}