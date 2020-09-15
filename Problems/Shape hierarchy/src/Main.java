abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {
    double a;
    double b;
    double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getPerimeter() {
        return a + b + c;
    }

    @Override
    double getArea() {
        double returnArea = getPerimeter() / 2;
        returnArea = Math.sqrt(returnArea * (returnArea - a) * (returnArea - b) * (returnArea - c));

        return returnArea;
    }
}

class Rectangle extends Shape {
    double a;
    double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    double getPerimeter() {

        return 2.0 * (a + b);
    }

    @Override
    double getArea() {
        return a * b;
    }
}

class Circle extends Shape {
    double a;

    public Circle(double a) {
        this.a = a;
    }

    @Override
    double getPerimeter() {
        return 2.0 * Math.PI * a;
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(a, 2);
    }
}