import java.io.*;
import java.util.Scanner;

public class MainTask102 {
    public static void main(String[] args) {
        WorkingWithLog wWLog = new WorkingWithLog();
        Scanner scanner = new Scanner(System.in);
        String stringPath;
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
        System.out.println("Input directory path: ");
        stringPath = scanner.nextLine();
        wWLog.directorySize1(stringPath);
    }
}
class WorkingWithLog {
    public static double directorySize1(String path)
    {
        WorkingWithLog wWLog1 = new WorkingWithLog();
        File file=new File(path);
        double directorySize1 = (double)file.length();
        if(file.isDirectory())
        {
            File[] files =file.listFiles();
            for(File item:files)
            {
                directorySize1 += directorySize1(item.getPath());
            }
        }
        wWLog1.directorySize(directorySize1, path);
        return 0;
    }

    public static double directorySize(double directorySize1, String path)
    {
        WorkingWithLog wWLog1 = new WorkingWithLog();
        String logPath = "C:/Users/Spiritseer/Desktop/JavaProject10";
        double finalSize;
        String sizeTemp;
        if(directorySize1 >= 8L * 1024 * 1024 * 1024 * 1024){
            finalSize = directorySize1/(8L*1024*1024*1024*1024);
            sizeTemp = "Tb";
        }
        else if (directorySize1 >= 8L*1024*1024*1024) {
            finalSize = directorySize1/(8L*1024*1024*1024);
            sizeTemp = "Gb";
        }
        else if (directorySize1 >= 8L*1024*1024) {
            finalSize = directorySize1/(8L*1024*1024);
            sizeTemp = "Mb";
        }
        else if (directorySize1 >= 8L*1024) {
            finalSize = directorySize1/(8L*1024);
            sizeTemp = "Kb";
        }
        else if (directorySize1 >= 8) {
        finalSize = directorySize1/8;
        sizeTemp = "byte";
        }
        else{
            finalSize = directorySize1;
            sizeTemp = "bit";
        }
        String finalLogString = ("The directory " + path + " size is " + finalSize + " " + sizeTemp);
        wWLog1.log(logPath, finalLogString);
        return 0;
    }
    public static void log(String path1, String stringText) {
        String stringText1 = stringText + "\n";
        try(FileOutputStream file = new FileOutputStream(path1 + "/log.txt", true);)
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
