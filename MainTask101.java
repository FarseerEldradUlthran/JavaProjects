import java.io.*;
import java.util.Scanner;

public class MainTask101 {
    public static void main(String[] args) {
        WorkingWithLog wWLog = new WorkingWithLog();
        Scanner scanner = new Scanner(System.in);
        String stringText;
        String logPath = "C:/Users/Spiritseer/Desktop/JavaProject10";
        File file = new File(logPath);
        if(!file.isDirectory()){
            if(file.mkdir()) {
                System.out.println("File has been created at directory JavaProject10 on the Desktop");
            }
            else{
                System.out.println("ERROR");
            }
        }
        System.out.println("Input massage: ");
        stringText = scanner.nextLine();
        wWLog.log(logPath, stringText);
    }
}
class WorkingWithLog {
    public static void log(String path1, String stringText) {
        String stringText1 = stringText + "\n";
        try(FileOutputStream file= new FileOutputStream(path1 + "/log.txt", true);)
        {
            byte[] buff = stringText1.getBytes();
            file.write(buff, 0, buff.length);
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}