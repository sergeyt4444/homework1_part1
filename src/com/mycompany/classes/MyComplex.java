package com.mycompany.classes;

public class MyComplex {

    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public String toString() {
        if (imag >= 0) {
            return "(" + real + "+" + imag + "i)";
        }
        else {
            return "(" + real + imag + "i)";
        }
    }

    public boolean isReal() {
        //В задании сказано, что функция должна проверять наличие real части
        return real==0?false:true;
    }

    public boolean isImaginary() {
        //В задании сказано, что функция должна проверять наличие мнимой части
        return imag==0?false:true;
    }

    public boolean equals(double real, double imag) {
        return (real == this.real && imag == this.imag)?true:false;
    }

    public boolean equals(MyComplex another) {
        return  (another.getReal() == real && another.getImag() == imag)?true:false;
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imag,2));
    }

    public double argument() {
        if (real == 0) {
            if (imag > 0) {
                return Math.PI/2;
            }
            else {
                if (imag < 0) {
                    return -Math.PI/2;
                }
                else {
                    // Если комплексное число равно нулю, аргумент неопределен
                    return -100;
                }
            }
        }
        else {
            if (real > 0) {
                return Math.atan(imag/real);
            }
            else {
                if (real < 0 && imag >= 0) {
                    return Math.PI + Math.atan(imag/real);
                }
                else {
                    return -Math.PI + Math.atan(imag/real);
                }
            }
        }
    }

    public MyComplex add(MyComplex right) {
        setReal(this.real + right.getReal());
        setImag(this.imag + right.getImag());
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(this.real + right.getReal(), this.imag + right.getImag());
    }

    public MyComplex subtract(MyComplex right) {
        setReal(this.real - right.getReal());
        setImag(this.imag - right.getImag());
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        return new MyComplex(this.real - right.getReal(), this.imag - right.getImag());
    }

    public MyComplex multiply(MyComplex right) {
        setReal(this.real*right.getReal() - this.imag*right.getImag());
        setImag(this.real*right.getImag() + this.imag*right.getReal());
        return this;
    }

    public MyComplex divide(MyComplex right) {
        setReal((this.real*getReal() + this.imag*right.getImag())/(Math.pow(right.getReal(),2) + Math.pow(right.getImag(),2)));
        setImag((right.getReal()*this.imag - this.real*right.getImag())/(Math.pow(right.getReal(),2) + Math.pow(right.getImag(),2)));
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(this.real, -this.imag);
    }

}
