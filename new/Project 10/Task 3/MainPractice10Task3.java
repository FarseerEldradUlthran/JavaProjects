import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class MainPractice10Task3 {
    public static void main(String[] args) throws IOException {
        String path1, path2;
        Scanner scanner = new Scanner(System.in);
        WorkingWithLog wWLog1 = new WorkingWithLog();
        System.out.println("Input path of the directory, which you want to copy: ");
        wWLog1.log("Input path of the directory, which you want to copy: \n");
        path1 = scanner.nextLine();
        wWLog1.log(path1 + "\n");
        System.out.println("Input path of the directory, where you want to place the copy: ");
        wWLog1.log("Input path of the directory, where you want to place the copy: \n");
        path2 = scanner.nextLine();
        wWLog1.log(path2 + "\n");
        File file1 = new File(path1);
        File file2 = new File(path2);
        wWLog1.copy(file1, file2);
        System.out.println("Directory has been copied.");
        wWLog1.log("Directory has been copied. \n");
    }
}

class WorkingWithLog {
    public static void log(String directoryPath) throws IOException {
        String logPath = "temp1/log.txt";
        File file = new File(logPath);
        if (new File("temp1").mkdirs()) {
            try {
                if (file.createNewFile())
                    System.out.println("");
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
    public static void copy(File path1, File path2) throws IOException {
        if (path1.isDirectory()) {
            if (!path2.exists()) {
                path2.mkdirs();
            }
            for (String f : Objects.requireNonNull(path1.list())) {
                copy(new File(path1, f), new File(path2, f));
            }
        } else {
            try (
                    InputStream in = new FileInputStream(path1);
                    OutputStream out = new FileOutputStream(path2)
            ) {
                byte[] buf = new byte[1024];
                int length;
                while ((length = in.read(buf)) > 0) {
                    out.write(buf, 0, length);
                }
            }
        }
    }
}
