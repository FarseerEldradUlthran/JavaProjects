import java.util.ArrayList;
import java.util.Scanner;

public class MainTask81 {
    public static void main(String[] args) {
        int editInput, deleteInput;
        String input, addCase, editCase;
        System.out.println("Выберите действие и введите одну из комманд: \n LIST \n ADD \n EDIT \n DELETE \n EXIT");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        ArrayList<String> toDoList = new ArrayList<>();
        toDoList.add("Сделать дз по Java");
        toDoList.add("Посетить магазин");
        while (!input.equals("EXIT")) {
            if (input.equals("LIST")) {
                for (int j = 0; j < toDoList.size(); j++) {
                    System.out.println(j + ". " + toDoList.get(j));
                }
            }
            else if (input.equals("ADD")) {
                System.out.println("Какое дело вы хотите добавить?");
                Scanner scanner1 = new Scanner(System.in);
                addCase = scanner1.nextLine();
                toDoList.add(addCase);
            }
            else if (input.equals("EDIT")) {
                System.out.println("Введите номер дела (начиная с 0), которое вы хотите изменить");
                Scanner scanner2 = new Scanner(System.in);
                editInput = scanner2.nextInt();
                toDoList.remove(editInput);
                System.out.println("Введите новое задание вместо старого");
                Scanner scanner3 = new Scanner(System.in);
                editCase = scanner3.nextLine();
                toDoList.add(editInput, editCase);
            }
            else if (input.equals("DELETE")) {
                System.out.println("Введите номер дела (начиная с 0), которое вы хотите удалить");
                Scanner scanner4 = new Scanner(System.in);
                deleteInput = scanner4.nextInt();
                toDoList.remove(deleteInput);
            }
            else {
                System.out.println("Неверная команда. Повторите ввод.");
            }
            input = scanner.nextLine();
        }
    }
}
