import java.io.*;
import java.util.Scanner;

public class MainTask101102 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input directory path:");
        String path = scanner.nextLine();
        WorkingWithLog wWLog1 = new WorkingWithLog();
        File file = new File(path);
        double directorySize1, finalSize;
        String sizeTemp;
        directorySize1 = wWLog1.directorySize(file);
        if (directorySize1 < 1024L) {
            finalSize = directorySize1;
            sizeTemp = "byte";
        }
        else if (directorySize1 < 1024L*1024) {
            finalSize = directorySize1/(1024);
            sizeTemp = "Kb";
        }
        else if (directorySize1 < 1024L*1024*1024) {
            finalSize = directorySize1/(1024L*1024);
            sizeTemp = "Mb";
        }
        else if (directorySize1 < 1024L*1024*1024*1024) {
            finalSize = directorySize1/(1024L*1024*1024);
            sizeTemp = "Gb";
        }
        else{
            finalSize = directorySize1/(1024L*1024*1024*1024);
            sizeTemp = "Tb";
        }
        System.out.println("Directory size is: " + String.format("%.2f", finalSize) + sizeTemp);
        String finalLogString = ("The directory " + path + " size is " + String.format("%.2f", finalSize) + " " + sizeTemp + "\n");
        wWLog1.log(finalLogString);
    }
}

class WorkingWithLog {
    public static void log(String directoryPath) throws IOException {
        String logPath = "temp1/log.txt";
        File file = new File(logPath);
        if (new File("temp1").mkdirs()) {
            try {
                if (file.createNewFile())
                    System.out.println("log file has been created.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(logPath, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        outputStream.write(directoryPath.getBytes());
        outputStream.close();
    }
    public static double directorySize(File file){
        double directorySize1 = 0;
        File[] files = file.listFiles();
        assert files != null;
        for (File file1 : files) {
            if (file1.isFile()) {
                directorySize1 += file1.length();
            }
            else {
                directorySize1 += directorySize(file1);
            }
        }
        return directorySize1;
    }
}


