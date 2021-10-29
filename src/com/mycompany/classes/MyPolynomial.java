package com.mycompany.classes;

public class MyPolynomial {

    //В UML нет методов доступа к коэффициентам, просто сделаю их публичными
    public double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        int degree = coeffs.length - 1;
        while (coeffs[degree] == 0 && degree > 0) {
            degree--;
        }
        return degree;
    }

    public double evaluate(double x) {
        //Если я правильно понял, в этом методе мы подставляем значение x в полином
        double result = 0;
        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i]*Math.pow(x, i);
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial right) {
        //Метод add не меняет this объект
        double[] tmpCoeffs;
        int leftDeg = getDegree();
        int rightDeg = right.getDegree();
        int i = 0;
        tmpCoeffs = (leftDeg>=rightDeg)? new double[leftDeg+1]:new double[rightDeg+1];
        while (i <= leftDeg && i <= rightDeg) {
            tmpCoeffs[i] = coeffs[i] + right.coeffs[i];
            i++;
        }
        while (i <= leftDeg) {
            tmpCoeffs[i] = coeffs[i];
            i++;
        }
        while (i <= rightDeg) {
            tmpCoeffs[i] = right.coeffs[i];
            i++;
        }
        return new MyPolynomial(tmpCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        double[] tmpCoeffs;
        int leftDeg = getDegree();
        int rightDeg = right.getDegree();
        tmpCoeffs = new double[leftDeg+rightDeg+1];
        for (int i = 0; i <= leftDeg; i++) {
            for (int j = 0; j <= rightDeg; j++) {
                tmpCoeffs[i+j] += coeffs[i]*right.coeffs[j];
            }
        }
        return new MyPolynomial(tmpCoeffs);
    }

    @Override
    public String toString() {
        //Неясно, должен ли полином с коэффициентами, к примеру, {1,-1, 0}
        // записываться как 1.0x^2-1.0x
        // или как x^2-x, я выбрал вариант попроще (первый)
        String result = "";
        int degree = getDegree();
        int hasPreviousTerm = 0;
        String termX = "";
        while (degree >=0) {
            if (degree > 1) {
                termX = "x^"+degree;
            }
            else {
                if (degree == 1) {
                    termX = "x";
                }
                else {
                    termX = "";
                }
            }
            if (hasPreviousTerm == 0) {
                result += coeffs[degree] + termX;
                hasPreviousTerm = 1;
            }
            else {
                if (coeffs[degree] > 0) {
                    result += "+" + coeffs[degree] + termX;
                }
                else {
                    if (coeffs[degree] < 0) {
                        result += coeffs[degree] + termX;
                    }
                }
            }
            degree--;
        }
        return result;
    }

}
