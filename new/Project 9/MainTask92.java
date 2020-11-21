import java.util.*;
import java.util.stream.IntStream;

public class MainTask92 {
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
        String found1, found2, found3, found4;
        HashSet<String> setHash = new HashSet<String>(arrayList);
        TreeSet<String> setTree = new TreeSet<String>(arrayList);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер (типа Х999АН001), который хотите найти: ");
        String number = scanner.nextLine();
        long start = System.nanoTime();
        if (arrayList.contains(number)){
            found1 = "номер найден";
        }
        else{
            found1 = "номер не найден";
        }
        long end1 = System.nanoTime()-start;
        Collections.sort(arrayList);
        start = System.nanoTime();
        if (Collections.binarySearch(arrayList,number) >= 0){
            found2 = "номер найден";
        }
        else{
            found2 = "номер не найден";
        }
        long end2 = System.nanoTime()-start;
        start = System.nanoTime();
        if (setHash.contains(number)){
            found3 = "номер найден";
        }
        else{
            found3 = "номер не найден";
        }
        long end3 = System.nanoTime()-start;
        start = System.nanoTime();
        if (setTree.contains(number)){
            found4 = "номер найден";
        }
        else{
            found4 = "номер не найден";
        }
        long end4 = System.nanoTime()-start;
        System.out.println("Поиск перебором: " + found1 + ", поиск занял: " + end1 + " нс");
        System.out.println("Бинарный поиск: " + found2 + ", поиск занял: " + end2 + " нс");
        System.out.println("Поиск в HashSet: " + found3 + ", поиск занял: " + end3 + " нс");
        System.out.println("Поиск в TreeSet: " + found4 + ", поиск занял: " + end4 + " нс");
    }
}
