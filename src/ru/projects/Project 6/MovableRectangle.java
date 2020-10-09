import java.util.Scanner;

class Rectangle{
    private double y01;
    private double x02;

    public void SetA(double y01) {
        this.y01 = y01;
    }

    public void SetB(double x02) {
        this.x02 = x02;
    }

    public double GetA() {
        return y01;
    }

    public double GetB() {
        return x02;
    }

    Rectangle(double y01, double x02) {
        SetA(y01);
        SetB(x02);
    }

    public void FirstCoord() {
        System.out.println("Ваши изначальные координаты:" + "\n");
        System.out.println("x01 = 0;" + " y01 = " + GetA());
        System.out.println("x02 = " + GetB() + "; y02 = 0;");
    }
}
interface Movable {
    int move(double x1, double y1, double x2, double y2, double x01, double y01, double x02, double y02);
}
class MovableRectangle1 implements Movable{
    private double x1, y1, x2, y2, x01, y01, x02, y02;

    void test1(double x1, double y1, double x2, double y2, double x01, double y01, double x02, double y02){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = x2;
        this.x01 = x01;
        this.y01 = y01;
        this.x02 = x02;
        this.y02 = x02;

        Scanner sc = new Scanner(System.in);
        while(x1 == x2 && y1 == y2) {
            System.out.println("Перемещение произошло успешно, нарушения целостности прямоугольника не произошло");
            x01 = x01 + x1;
            y01 = y01 + y1;
            x02 = x02 + x2;
            y02 = y02 + y2;
            System.out.println("Текущий результат:");
            System.out.println("x1 = " + x01 + " y1 = " + y01 + " x2 = " + x02 + " y2 = " + y02);
            System.out.println("Введите координаты х и у для точки левого верхнего угла прямоугольника: ");
            x1 = sc.nextDouble();
            y1 = sc.nextDouble();
            System.out.println("Введите координаты х и у для точки правого нижнего угла прямоугольника: ");
            x2 = sc.nextDouble();
            y2 = sc.nextDouble();
        }
        System.out.println("Целостность была нарушена. Будут выведены последние верные результаты.");
        System.out.println("x1 = " + x01 + " y1 = " + y01 + " x2 = " + x02 + " y2 = " + y02);
    }

    @Override
    public int move(double x1, double y1, double x2, double y2, double x01, double y01, double x02, double y02) {
        return 0;
    }
}

public class MovableRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1, x2, y1, y2;
        double x01, y01, x02, y02;
        x01 = 0;
        System.out.println("Введите ширину прямоугольника:");
        y01 = sc.nextDouble();
        System.out.println("Введите длину прямоугольника:");
        x02 = sc.nextDouble();
        y02 = 0;
        Rectangle rectangle = new Rectangle(y01, x02);
        rectangle.FirstCoord();
        System.out.println("Введите координаты х и у для точки левого верхнего угла прямоугольника: ");
        x1 = sc.nextDouble();
        y1 = sc.nextDouble();
        System.out.println("Введите координаты х и у для точки правого нижнего угла прямоугольника: ");
        x2 = sc.nextDouble();
        y2 = sc.nextDouble();
        MovableRectangle1 moverec = new MovableRectangle1();
        moverec.test1(x1, y1, x2, y2, x01, y01, x02, y02);
    }
}
