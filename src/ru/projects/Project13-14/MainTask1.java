import java.util.StringTokenizer;

public class MainTask1 {
    public static void main(String[] args) {
        int a = 0, b = 0;
        int counter = 0;
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        StringTokenizer st = new StringTokenizer(text, " ");
        while(st.hasMoreTokens()) {
            counter++;
            String key = st.nextToken();
            if (counter == 3) {
                a = Integer.parseInt(key.trim());
            }
            if (counter == 12) {
                b = Integer.parseInt(key.trim());
            }
        }
        System.out.println("Вася и Маша в сумме получили " + (a+b) + " рублей");
    }
}