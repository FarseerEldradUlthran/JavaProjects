import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Practice11Task1 {
    public static void main(String[] args) throws IOException {
        HashMap<String, Double> hashMap = new HashMap<>();
        List<String> table = Files.readAllLines(Paths.get("temp1/movementList.txt"));
        double inc = 0.0, out = 0.0;
        for (int i = 1; i <= 119; i++) {
            String[] line = table.get(i).split("\t");
            String path = line[5].replaceAll("( ){3,}", "   ");
            path = path.replace('\\', '/');
            String[] nextpath = path.split("   ");
            String organisation = nextpath[1].substring(nextpath[1].indexOf('/') + 1);
            double income = Double.parseDouble(line[6].replace(',', '.'));
            double outcome = Double.parseDouble(line[7].replace(',', '.'));
            inc += income;
            out += outcome;
            if (!hashMap.containsKey(organisation)) {
                hashMap.put(organisation, outcome);
            } else {
                double d = hashMap.get(organisation) + outcome;
                hashMap.put(organisation, d);
            }
        }
        System.out.println("Summary income: " + out);
        System.out.println("Summary outcome: " + inc);
        System.out.println("All organisations outcome: ");
        for (String k : hashMap.keySet()) {
            System.out.println(k + ": " + hashMap.get(k));
        }
    }
}
