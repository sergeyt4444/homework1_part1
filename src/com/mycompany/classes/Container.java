package com.mycompany.classes;

import java.util.Objects;

public class Container {
    private int x1,y1,x2,y2;

    public Container(int x, int y, int width, int height) {
        x1 = x;
        y1 = y;
        x2 = x1 + width;
        y2 = y1 + height;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return x2 - x1;
    }

    public int getHeight() {
        return y2 - y1;
    }

    public boolean collides(Ball ball) {
        //Название метода не соответствует тому, чего он делает, в данной реализации
        // метод проверяет, находится ли мяч в границах контейнера
        if (ball.getX() + ball.getRadius() <= x2 && ball.getX() - ball.getRadius() >= x1 &&
                ball.getY() + ball.getRadius() <= y2 && ball.getY() - ball.getRadius() >= y1) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Container[(" + x1 + "," + y1 + "),(" + x2 + "," + y2 + ")]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return x1 == container.x1 && y1 == container.y1 && x2 == container.x2 && y2 == container.y2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2);
    }
}
