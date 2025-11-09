class Cat implements Meowable {
    private String name;
    private int meowCount;

    public Cat() { // Конструктор создает кота без имени и нулевым счетчиком
        this.name = "Без имени";
        this.meowCount = 0;
    }

    public Cat(String name) { // Конструктор создает кота с заданным именем
        setName(name);
        this.meowCount = 0;
    }

    @Override
    public void meow() { // Для одного мяу
        meow(1);
    }

    public void meow(int n) { // Для нескольких мяу
        if (n <= 0) {
            System.out.println(name + ": тишина");
            return;
        }
        meowCount += n; // Увеличиваем счетчик на n мяуканий
        StringBuilder res = new StringBuilder(name + ": ");
        for (int i = 0; i < n; i++) {
            res.append("мяу");
            if (i < n - 1)
                res.append("-");
        }
        res.append("!");
        System.out.println(res);
    }

    public String getName() { // Геттер для имени кота
        return name;
    }

    public void setName(String name) { // Сеттер для имени кота
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя кота не может быть пустым!");
        }
        if (!name.matches("^[a-zA-Zа-яА-ЯёЁ\\s]+$")) {
            throw new IllegalArgumentException("Имя кота может содержать только буквы и пробелы!");
        }
        this.name = name.trim();
    }

    public int getMeowCount() { // Геттер для счётчика мяуканий
        return meowCount;
    }

    public void setMeowCount(int meowCount) { // Сеттер для счётчика мяуканий
        if (meowCount < 0) {
            throw new IllegalArgumentException("Количество мяуканий не может быть отрицательным!");
        }
        this.meowCount = meowCount;
    }

    @Override
    public String toString() { // Метод для строкового представления кота
        return "кот: " + name;
    }
}