import java.util.Scanner;

public class MainTask3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text1 = in.nextLine();
        String changedText = text1.replaceAll("[a-zA-Zа-яА-Я]*", "");
        String number1 = changedText.replaceAll("[-!@#=$%.^&*()_+№;:?/\\\"~]*", "");
        String number = number1.replaceAll(" ", "");
        String[] numbers = number.split("");
        if (numbers[0].equals("8") && numbers.length == 11 || numbers[0].equals("7") && numbers.length == 11){
            System.out.println("+7 (" + numbers[1] + numbers[2] + numbers[3] + ") " + numbers[4] +
                    numbers[5] + numbers[6] + "-" + numbers[7] + numbers[8] + "-" + numbers[9] + numbers[10]);
        }
        else if (numbers.length == 10){
            System.out.println("+7 (" + numbers[0] + numbers[1] + numbers[2] + ") " + numbers[3] +
                    numbers[4] + numbers[5] + "-" + numbers[6] + numbers[7] + "-" + numbers[8] + numbers[9]);
        }
        else{
            System.out.println("Неверный формат номера.");
        }
    }
}