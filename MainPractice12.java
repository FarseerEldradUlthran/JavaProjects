import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class lines1 {
    public Map<String,ArrayList> stations = new HashMap<>();
    public List<lines2> lines = new ArrayList<>();
}

class lines2 {
    public String number;
    public String name;
}

public class MainPractice12 {
    public static ArrayList<String> lineList = new ArrayList<>();
    public static ArrayList<String> numberList = new ArrayList<>();
    public static Map<String,ArrayList> stationMap = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        List<String> files = Files.readAllLines(Paths.get("temp12/metro.json"));
        files.forEach(file-> stringBuffer.append(file).append("\n"));
        stringBuffer.toString();
        lines1 metro=new lines1();
            Document html = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").get();
            Elements elementsLines = html.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln");
            for (Element elementLine : elementsLines)
            {
                String line = elementLine.text();
                lineList.add(line);
                String string = elementLine.attr("abs:data-line");
                String lineNumber= string.substring(string.lastIndexOf('/')+1);
                numberList.add(lineNumber);
            }
            for(int i=0;i<17;i++)
            {
                ArrayList<String> stationList=new ArrayList<>();
                Elements stationName = html.select("div[data-line=" + numberList.get(i) + "]").select("span.name");
                for(Element st:stationName)
                {
                    String string1 = st.toString().split(">")[1].split("<")[0];
                    stationList.add(string1);
                }
                stationMap.put(numberList.get(i), stationList);
            }
        for(int i=0; i<numberList.size(); i++)
        {
            lines2 lines = new lines2();
            lines.number = numberList.get(i);
            lines.name = lineList.get(i);
            metro.lines.add(lines);
        }
        metro.stations = stationMap;
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter("temp12/metro.json");
        json.toJson(metro, writer);
        writer.flush();
        writer.close();
        String jsons= json.toJson(metro);
        System.out.println(jsons);
    }
}