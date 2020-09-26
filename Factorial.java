import java.util.Scanner;

class Factorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int sum = 1;
        for(int i = 1; i <= a; i++) {
            sum = sum * i;
        }
        System.out.print(sum);
    }
}