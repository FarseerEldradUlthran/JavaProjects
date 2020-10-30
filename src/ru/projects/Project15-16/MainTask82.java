import java.util.Scanner;
import java.util.TreeSet;

public class MainTask82 {
    public static void main(String[] args) {
        String input, addCase;
        int count1 = 0, count2 = 0;
        boolean flag = true;
        System.out.println("Выберите действие и введите одну из комманд: \n LIST \n ADD \n EXIT");
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> emailTree = new TreeSet();
        emailTree.add(" Java@mail.ru");
        emailTree.add(" Plus@yandex.ru");
        while (flag) {
            input = scanner.next();
            if (input.equals("LIST")) {
                for (String i: emailTree) {
                    System.out.println(i);
                }
            }
            else if (input.equals("ADD")) {
                addCase = scanner.nextLine();
                for (int i = 0; i < addCase.length(); i++){
                    if(addCase.charAt(i) == '@'){
                        count1++;
                    }
                    else if(addCase.charAt(i) == '.'){
                        count2++;
                    }
                }
                if(count1 == 1 && count2 == 1) {
                    emailTree.add(addCase);
                    count1 = 0;
                    count2 = 0;
                }
                else{
                    System.out.println("Почта некорректна, повторите ввод.");
                }
            }
            else {
                System.out.println("Неверная команда. Повторите ввод.");
            }
        }
    }
}
