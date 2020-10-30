import java.util.ArrayList;
import java.util.Scanner;

public class MainTask82 {
    public static void main(String[] args) {
        String input, addCase;
        String[] a = new String[100];
        int count1 = 0, count2 = 0;
        System.out.println("Выберите действие и введите одну из комманд: \n LIST \n ADD \n EXIT");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        ArrayList<String> toDoList = new ArrayList<>();
        toDoList.add("Java@mail.ru");
        toDoList.add("Plus@yandex.ru");
        while (!input.equals("EXIT")) {
            if (input.equals("LIST")) {
                for (int j = 0; j < toDoList.size(); j++) {
                    System.out.println(toDoList.get(j));
                }
            }
            else if (input.equals("ADD")) {
                System.out.println("Введите почту:");
                Scanner scanner1 = new Scanner(System.in);
                addCase = scanner1.nextLine();
                for (int i = 0; i < addCase.length(); i++){
                    if(a[i].equals("@")){
                        count1++;
                    }
                    else if(a[i].equals(".")){
                        count2++;
                    }
                }
                if(count1 == 1 && count2 == 1) {
                    toDoList.add(addCase);
                }
                else{
                    System.out.println("Почта некорректна, повторите ввод.");
                }
            }
            else {
                System.out.println("Неверная команда. Повторите ввод.");
            }
            input = scanner.nextLine();
        }
    }
}
