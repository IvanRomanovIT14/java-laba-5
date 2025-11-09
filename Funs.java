import java.util.*;

public class Funs {
    public Funs() { // Конструктор класса Funs
    }

    // Метод для вызова мяуканий
    public static void meowsCare(Collection<Meowable> meowables) {
        for (Meowable m : meowables) {
            m.meow();
        }
    }
}