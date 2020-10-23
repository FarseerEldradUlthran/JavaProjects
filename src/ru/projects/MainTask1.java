public class MainTask1 {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        String[] words = text.split(" ");
        int a = Integer.parseInt(words[2].trim());
        int b = Integer.parseInt(words[11].trim());
        System.out.println("Вася и Маша в сумме получили " + (a+b) + " рублей");
    }
}