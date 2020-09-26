import java.util.Scanner;

abstract class Shape {
    public abstract double Area();
    public abstract void ToString();
}

class Circle extends Shape {
    private double a;
    private String S;

    public void SetA(double a) {
        this.a = a;
    }

    public void SetS(String S) {
        this.S = S;
    }

    public double GetA() {
        return a;
    }

    public String GetS() {
        return S;
    }
    Circle(double R, String CenterCircle) {
        SetS(CenterCircle);
        SetA(R);
    }

    public double Area() {
        return Math.PI * GetA() * GetA();
    }

    public double Circumference() {
        return 2 * Math.PI * GetA();
    }

    public void ToString() {
        System.out.println("Вывод окружности:");
        System.out.format("\n", GetA());
        System.out.println(GetS());
        System.out.println(Area());
        System.out.println(Circumference());
    }
}

class Square extends Shape {
    private double a;

    public void SetA(double a) {
        this.a = a;
    }

    public double GetA() {
        return a;
    }

    Square(double a) {
        SetA(a);
    }

    public double Area() {
        return GetA() * GetA();
    }

    public void ToString() {
        System.out.println("Вывод квадрата:");
        System.out.println(GetA());
        System.out.println(Area());
    }
}

class Rectangle extends Shape {
    private double a;
    private double b;

    public void SetA(double a) {
        this.a = a;
    }

    public void SetB(double b) {
        this.b = b;
    }

    public double GetA() {
        return a;
    }

    public double GetB() {
        return b;
    }

    Rectangle(double a, double b) {
        SetA(a);
        SetB(b);
    }

    public double Area() {
        return GetA() * GetB();
    }

    public void ToString() {
        System.out.println("Вывод прямоугольника:");
        System.out.println(GetA());
        System.out.println(GetB());
        System.out.println(Area());
    }
}

public class TesterShape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double R;
        String CenterCircle;
        System.out.println("Введите радиус окружности:");
        R = sc.nextInt();
        System.out.println("Введите центр окружности:");
        CenterCircle = sc.next();
        Circle circle = new Circle(R, CenterCircle);
        double a, b, c;
        System.out.println("Введите сторону квадрата");
        a = sc.nextInt();
        Square square = new Square(a);
        System.out.println("Введите первую сторону прямоугольника:");
        b = sc.nextInt();
        System.out.println("Введите вторую сторону прямоугольника:");
        c = sc.nextInt();
        Rectangle rectangle = new Rectangle(b, c);
        circle.ToString();
        square.ToString();
        rectangle.ToString();
    }
}