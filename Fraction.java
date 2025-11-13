public class Fraction implements FractionInterface {
    private int numerator;
    private int denominator;

    // Конструктор с параметрами - создает дробь с заданными числителем и знаменателем
    public Fraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    @Override
    public void setNumerator(int numerator) { // Сеттер числителя
        this.numerator = numerator;
    }

    @Override
    public void setDenominator(int denominator) { // Сеттер знаменателя
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть 0");
        }
        if (denominator < 0) {
            throw new IllegalArgumentException("Знаменатель не может быть отрицательным!");
        }
        this.denominator = denominator;
    }

    @Override
    public double getRealValue() { // Геттер для получения вещественного значения дроби
        return (double) numerator / denominator;
    }

    public int getNumerator() { // Геттер числителя
        return numerator;
    }

    public int getDenominator() { // Геттер знаменателя
        return denominator;
    }

    @Override
    public String toString() { // Метод для строкового представления дроби в формате числитель/знаменатель
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) { // Метод для сравнения двух дробей
        if (this == obj)
            return true; // Проверка на равенство
        if (obj == null || getClass() != obj.getClass())  // Проверка на null и совпадение классов
            return false;
        // Приведение типа и сравнение числителей и знаменателей
        Fraction fraction = (Fraction) obj;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }
}
