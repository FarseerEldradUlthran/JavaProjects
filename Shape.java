import java.util.Scanner;

abstract class Shape {
    int rad, side;

    Shape(int rad_1, int side_1) {
        this.rad = rad_1;
        this.side = side_1;
    }

    public abstract double getCircumference();
    public abstract double getRad();
    public abstract int getSide();
}

abstract class Circle extends Shape {

    Circle(int rad, int side) {
        super(rad, side);
    }

    public double getCircumference() {
        System.out.println("Длина окружности равна: " + 2 * 3.14 * rad);
        return 0;
    }

    public double getRad() {
        System.out.println("Площадь окружности равна: " + 3.14 * Math.pow(rad, 2));
        return 0;
    }

}
abstract class Square extends Shape {

    Square(int rad_1, int side_1) {
        super(rad_1, side_1);
    }

    public int getSide() {
        System.out.println("Площадь квадрата равна: " + Math.pow(side, 2));
        return 0;
    }
}
abstract class Rectangle extends Shape {
    private int side_b;
    Rectangle(int rad_1, int side_1, int side_b) {
        super(rad_1, side_1);
        this.side_b = side_b;
    }

    void getSqr_2(int side_) {
        side_b = side_;
        System.out.print("лощадь прямоугольника равна: " + side * side_b);
    }
}

class TestShape {
    void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("введите радиус: ");
        int rad = input.nextInt();
        System.out.println("Ведите сторону для квадрата и 2-ую сторону дя прямоугольник: ");
        int side_a = input.nextInt();
        int side_b = input.nextInt();
        Shape test = new Shape(rad, side_a) {
            @Override
            public double getCircumference() {
                return 0;
            }

            @Override
            public double getRad() {
                return 0;
            }

            @Override
            public int getSide() {
                return 0;
            }
        };
        test.getCircumference();
    }
}
