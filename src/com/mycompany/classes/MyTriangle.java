package com.mycompany.classes;

public class MyTriangle {

    private MyPoint v1,v2,v3;
    public static final double eps = 0.0001;

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        v1 = new MyPoint(x1,y1);
        v2 = new MyPoint(x2,y2);
        v3 = new MyPoint(x3,y3);
    }

    @Override
    public String toString() {
        return "MyTriangle[v1=" + v1 +",v2=" + v2 + ",v3=" + v3 +"]";
    }

    public double getPerimeter() {
        return v1.distance(v2) + v1.distance(v3) + v2.distance(v3);
    }

    public String getType() {
        if (v1.getX() == v2.getX() && v1.getY() == v2.getY() && v2.getX() == v3.getX() && v2.getY() == v3.getY()) {
            return TriangleType.POINT.name();
        }
        else {
            if (Math.abs(v1.distance(v2) - v2.distance(v3) - v1.distance(v3)) <= eps ||
                    Math.abs(v1.distance(v3) - v1.distance(v2) - v2.distance(v3)) <= eps ||
                    Math.abs(v2.distance(v3) - v1.distance(v2) - v1.distance(v3)) <= eps) {
                return TriangleType.LINE.name();
            }
            else {
                if ((Math.abs(v1.distance(v2) - v2.distance(v3)) <= eps) &&(Math.abs(v2.distance(v3) - v1.distance(v3)) <= eps)) {
                    // Этот случай невозможен в целочисленных координатах, но все равно его рассмотрим
                    return TriangleType.EQUILATERAL.name();
                }
                else {
                    if ((Math.abs(v1.distance(v2) - v1.distance(v3))) <= eps || Math.abs((v1.distance(v2) - v2.distance(v3))) <= eps ||
                    Math.abs((v1.distance(v3) - v2.distance(v3))) <= eps) {
                        return TriangleType.ISOSCELES.name();
                    }
                    else {
                        return TriangleType.SCALENE.name();
                    }
                }
            }
        }
    }
}
