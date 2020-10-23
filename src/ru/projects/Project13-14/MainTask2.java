import java.util.Scanner;

public class MainTask2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        String[] words = text.split(" ");
        if (words.length == 3){
            System.out.println("Фамилия: " + words[0] + '\n' + "Имя: " + words[1] + '\n' + "Отчество: " + words[2]);
        }
        else if (words.length == 2){
            System.out.println("Фамилия: " + words[0] + '\n' + "Имя: " + words[1]);
        }
        else{
            System.out.println("Введенная строка не является ФИО");
        }
    }
}