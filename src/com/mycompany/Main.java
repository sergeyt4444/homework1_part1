package com.mycompany;

import com.mycompany.classes.*;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(5,"blue");
        Rectangle rectangle = new Rectangle(5.0f, 10.0f);
        Employee employee = new Employee(1, "Vasya", "Pupkin", 100000);
        Author author1 = new Author("Vasya", "Vasya@mail.ru", 'm');
        Author author2 = new Author("Petya", "Petya@yandex.ru", 'm');
        Author[] authors = new Author[2];
        authors[0] = author1;
        authors[1] = author2;
        Book book = new Book("Book1", authors, 1000, 5);
        MyPoint p1 = new MyPoint(1,2);
        MyTriangle triangle = new MyTriangle(0,0,0,0,0,0);
        MyTriangle triangle1 = new MyTriangle(0,0,1,1,2,2);
        MyTriangle triangle2 = new MyTriangle(0,0,1,1,0,6);
        MyTriangle triangle3 = new MyTriangle(-1,0,1,0,0,1);
        MyComplex myComplex = new MyComplex(3,4);
        MyComplex myComplex1 = new MyComplex(4,3);
        MyPolynomial myPolynomial = new MyPolynomial(5, 5);
        MyPolynomial myPolynomial1 = new MyPolynomial(1,0,5);
        MyPolynomial myPolynomial2 = new MyPolynomial(0, -1, 0, -1, -1);
        Ball ball = new Ball(0,0,10,10,45);
        Container container = new Container(-10, -10, 30,30);
        System.out.println(circle.toString());
        System.out.println(circle.getArea());
        System.out.println(rectangle.toString());
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
        System.out.println(employee.toString());
        System.out.println(employee.getAnnualSalary());
        System.out.println(employee.getName());
        System.out.println(employee.raiseSalary(50));
        System.out.println(employee.getSalary());
        System.out.println(book);
        System.out.println(book.getAuthorNames());
        System.out.println(p1);
        System.out.println(p1.distance());
        System.out.println(p1.distance(5,5));
        System.out.println(triangle3);
        System.out.println(triangle3.getPerimeter());
        System.out.println(triangle.getType());
        System.out.println(triangle1.getType());
        System.out.println(triangle2.getType());
        System.out.println(triangle3.getType());
        System.out.println(myComplex);
        System.out.println(myComplex.argument());
        System.out.println(myComplex.magnitude());
        System.out.println(myComplex.addNew(myComplex1));
        System.out.println(myComplex.subtractNew(myComplex1));
        System.out.println(myComplex.conjugate());
        System.out.println(myComplex.multiply(myComplex1));
        System.out.println(myPolynomial.getDegree());
        System.out.println(myPolynomial1.getDegree());
        System.out.println(myPolynomial.evaluate(3));
        System.out.println(myPolynomial1.evaluate(10));
        System.out.println(myPolynomial);
        System.out.println(myPolynomial1);
        System.out.println(myPolynomial2);
        System.out.println(myPolynomial1.add(myPolynomial));
        System.out.println(myPolynomial.multiply(myPolynomial1));
        System.out.println(ball);
        System.out.println(container);
        System.out.println(container.collides(ball));
        ball.move();
        System.out.println(container.collides(ball));
        ball.move();
        System.out.println(container.collides(ball));
    }

}
