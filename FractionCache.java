package ru.Romanov.task1;

public class FractionCache {
    private Double numeratorCache;
    private Double denominatorCache;
    private Double realValueCache;

    public FractionCache() { // Конструктор без параметров
        this.numeratorCache = null;
        this.denominatorCache = null;
        this.realValueCache = null;
    }

    public Double getNumeratorCache() { // Геттер кэша числителя
        return numeratorCache;
    }

    public Double getDenominatorCache() { // Геттер кэша знаменателя
        return denominatorCache;
    }

    public Double getRealValueCache() { // Геттер кэшированного вещественного значения дроби
        return realValueCache;
    }

    public void setNumeratorCache(Double value) { // Сеттер кэша числителя
        this.numeratorCache = value;
    }

    public void setDenominatorCache(Double value) { // Сеттер кэша знаменателя
        this.denominatorCache = value;
    }

    // Сеттер кэшированного вещественного значения дроби
    public void setRealValueCache(Double value) {
        this.realValueCache = value;
    }
}