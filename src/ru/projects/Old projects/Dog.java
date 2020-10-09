import java.util.ArrayList;
import java.util.Scanner;

public class Dog {
    String name;
    int age, ConverseAge;
    Dog(String name1, int age1) {
        name = name1;
        age = age1;
    }

    int AgeConversion() {
        ConverseAge = age * 7;
        return ConverseAge;
    }

    String ToString() {
        return ("The name of the dog is " + name + ", the age is " + age + " and at human ages it is " + AgeConversion());
    }

    void Show() {
        System.out.println(ToString());
    }
}

class DogKennel{
    ArrayList<String> arrayList = new ArrayList<>();
    Scanner elem = new Scanner(System.in);

    void Input(){
        int x = 0;
        while (x != 5) {
            arrayList.add(elem.nextLine());
            x = x + 1;
        }
    }

    void Output(){
        for(String s : arrayList) {
            System.out.println(s);
        }
    }
}

class Main {
    public static void main(String[] args) {
        System.out.print("Input the name of dog and the dog age:" + "\n");
        Scanner in = new Scanner(System.in);
        String name1 = in.nextLine();
        int age1 = in.nextInt();
        Dog info = new Dog(name1, age1);
        info.ToString();
        info.AgeConversion();
        info.Show();
        DogKennel ArrayList = new DogKennel();
        System.out.println("You can input up to 5 dogs into the array");
        ArrayList.Input();
        ArrayList.Output();
    }
}
