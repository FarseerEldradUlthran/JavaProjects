import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainTask83 {
    public static void main(String[] args) {
        int counter = 0;
        String input1;
        Map<String, String> map = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        System.out.println("Доступна команда: \n LIST \n Также вы можете ввести новую информацию или найти имеющуюся ");
        map.put("Мария", "+7 (903) 548-75-41" );
        map.put("Алексей Петрович", "+7 (914) 562-45-14" );
        while (flag){
            input1 = scanner.nextLine();
            String input2 = input1.replaceAll("[-!@#=$%.^&*()_+№;:?/\\\"~]*", "");
            String input = input2.replaceAll(" ", "");
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
                    String number1 = scanner1.nextLine();
                    String input3 = number1.replaceAll("[-!@#=$%.^&*()_+№;:?/\\\"~]*", "");
                    String number = input3.replaceAll(" ", "");
                    String[] numbers = input.split("");
                    if (numbers[0].equals("8") && numbers.length == 11 || numbers[0].equals("7") && numbers.length == 11){
                        number = ("+7 (" + numbers[1] + numbers[2] + numbers[3] + ") " + numbers[4] +
                                numbers[5] + numbers[6] + "-" + numbers[7] + numbers[8] + "-" + numbers[9] + numbers[10]);
                    }
                    else if (numbers.length == 10){
                        number = ("+7 (" + numbers[0] + numbers[1] + numbers[2] + ") " + numbers[3] +
                                numbers[4] + numbers[5] + "-" + numbers[6] + numbers[7] + "-" + numbers[8] + numbers[9]);
                    }
                    map.put(input, number);
                }
            }
            else if (checkNumbers){
                counter = 0;
                String[] numbers = input.split("");
                if (numbers[0].equals("8") && numbers.length == 11 || numbers[0].equals("7") && numbers.length == 11){
                    input = ("+7 (" + numbers[1] + numbers[2] + numbers[3] + ") " + numbers[4] +
                            numbers[5] + numbers[6] + "-" + numbers[7] + numbers[8] + "-" + numbers[9] + numbers[10]);
                }
                else if (numbers.length == 10){
                    input = ("+7 (" + numbers[0] + numbers[1] + numbers[2] + ") " + numbers[3] +
                            numbers[4] + numbers[5] + "-" + numbers[6] + numbers[7] + "-" + numbers[8] + numbers[9]);
                }
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