package ru.Romanov.task7;

import java.util.Objects;

public class Line {
    private Point start;
    private Point end;

    public Line() { //Конструктор создаёт линию в начале координат {0;0}
        this.start = new Point();
        this.end = new Point();
    }

    // Конструктор создает линию по координатам двух точек
    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public Point getStart() { // Геттер для начальной точки
        return start;
    }

    public void setStart(Point start) { // Сеттер для начальной точки
        if (start == null) {
            throw new IllegalArgumentException("Начальная точка не может быть null!");
        }
        this.start = start;
    }

    public Point getEnd() { // Геттер для конечной точки
        return end;
    }

    public void setEnd(Point end) { // Сеттер для конечной точки
        if (end == null) {
            throw new IllegalArgumentException("Конечная точка не может быть null!");
        }
        this.end = end;
    }

    @Override
    public String toString() { // Метод для строкового представления линии
        return "Линия от " + start + " до " + end;
    }

    @Override
    public boolean equals(Object obj) { // Метод для сравнения двух линий
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Line line = (Line) obj;
        return start.equals(line.start) && end.equals(line.end);
    }

    @Override
    public int hashCode() { // Метод генерирует хэш-код линии
        return Objects.hash(start, end);
    }
}
