import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainTask83 {
    public static void main(String[] args) {
        int counter = 0;
        String input;
        Map<String, String> map = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        System.out.println("Доступна команда: \n LIST \n Также вы можете ввести новую информацию или найти имеющуюся ");
        map.put("Мария", "89035487541" );
        map.put("Алексей Петрович", "89145624514" );
        while (flag){
            input = scanner.nextLine();
            boolean checkLetters1 = input.matches("^[a-zA-Zа-яА-Я]+$");
            boolean checkLetters2 = input.matches("[a-zA-Zа-яА-Я\\-]+[ ][a-zA-Zа-яА-Я\\-]+");
            boolean checkLetters3 = input.matches("[a-zA-Zа-яА-Я\\-]+[ ][a-zA-Zа-яА-Я\\-]+[ ][a-zA-Zа-яА-Я\\-]+");
            boolean checkNumbers = input.matches("[0-9]+$");
            if (input.equals("LIST")){
                for(Map.Entry<String, String> item : map.entrySet()){

                    System.out.println(item.getKey() + " - " + item.getValue());
                }
            }
            else if (input.equals("EXIT")){
                flag = false;
            }
            else if (checkLetters1 || checkLetters2 || checkLetters3){
                counter = 0;
                for (Map.Entry<String, String> item : map.entrySet()) {
                    if (input.equals(item.getKey())) {
                        System.out.println(item.getKey() +" - "+ item.getValue());
                        counter++;
                        break;
                    }
                }
                if (counter == 0) {
                    System.out.println("Впишите номер: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String number = scanner1.next();
                    map.put(input, number);
                }
            }
            else if (checkNumbers){
                counter = 0;
                for(Map.Entry<String, String> item : map.entrySet()) {
                    if (input.equals(item.getValue())) {
                        System.out.println(item.getKey() + " - " + item.getValue());
                        counter++;
                        break;
                    }
                }
                if (counter == 0) {
                    System.out.println("Впишите имя: ");
                    Scanner scanner2 = new Scanner(System.in);
                    String name = scanner2.nextLine();
                    map.put(name, input);
                }
            }
            else {
                System.out.println("Данные введены некорректно");
            }
        }
    }
}
