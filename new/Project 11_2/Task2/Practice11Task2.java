import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;

public class Practice11Task2 {
    public static void main(String[] args) throws IOException {
        Document html = Jsoup.connect("https://www.mirea.ru").get();
        Elements elements = html.getElementsByTag("img");
        for (Element element : elements) {
            String str = element.attr("abs:src");
            if ((str.contains(".png") || str.contains(".jpeg") || str.contains(".jpg"))) {
                String imageName = str.substring(str.lastIndexOf("/") + 1);
                System.out.println(imageName);
                URL url = new URL(str);
                File file = new File("temp2Images");
                if (!file.exists()) {
                    file.mkdir();
                }
                InputStream in = new BufferedInputStream(url.openStream());
                FileOutputStream fileOut = new FileOutputStream("temp2Images/" + imageName);
                byte[] buffer = new byte[8192];
                int n;
                while ((n = in.read(buffer)) != -1) {
                    fileOut.write(buffer, 0, n);
                }
                in.close();
                fileOut.close();
            }
        }
    }
}
