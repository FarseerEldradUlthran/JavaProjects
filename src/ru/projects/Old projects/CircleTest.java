import java.util.Scanner;
class Circle {
    public double radius, D, dlina, square, pi = 3.14;
    Circle(double radius1) {
        radius = radius1;
    }
    void GetD() {
        D = radius * 2;
        System.out.println(D);
    }
    void GetDlina() {
        dlina = 2 * pi * radius;
        System.out.println(dlina);
    }
    void GetSquare() {
        square = pi * Math.pow(radius, 2);
        System.out.println(square);
    }
    void setRadius(double radius1) {
        radius = radius1;
    }
}
public class CircleTest {
    static void collection(Circle inf) {
        inf.GetD();
        inf.GetDlina();
        inf.GetSquare();
    }
    public static void main(String[] args) {
        Scanner rad = new Scanner(System.in);
        System.out.println("Input radius: ");
        double rad1 = rad.nextDouble();
        Circle inf = new Circle(rad1);
        for(int i = 0; i < 2; i++) {
            if(i == 1) {
                rad1 = rad.nextDouble();
                inf.setRadius(rad1);
                collection(inf);
            }
            else {
                collection(inf);
            }
        }
    }
}
