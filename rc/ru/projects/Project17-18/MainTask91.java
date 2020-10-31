import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MainTask91 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        String[] chars = new String[]{"А", "В","Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х", };
        String[] numbers = new String[] {"111", "222", "333", "444", "555", "666", "777", "888", "999",};
        String letterA, letterB, letterC, num;
        for (int reg = 1; reg < 200; reg++){
            for(int i = 0; i<chars.length; i++){
                letterA = chars[i];
                for(int j = 0; j<chars.length; j++){
                    letterB = chars[j];
                    for(int k = 0; k<chars.length; k++){
                        letterC = chars[k];
                        for(int n = 0; n<numbers.length; n++){
                            num = numbers[n];
                            if(!letterA.equals(letterB) && !letterB.equals(letterC) && !letterA.equals(letterC)) {
                                arrayList.add((String.format("%s%s%s%s%03d", letterA, num, letterB, letterC, reg)));
                            }
                        }
                    }
                }
            }
        }
    }
}
