import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

class ImageResize extends Thread
{
    private File[] files;
    private String  dstFolder;
    private long start;
    public ImageResize(File[] files, String dstFolder, long start) {
        this.files = files;
        this.dstFolder = dstFolder;
        this.start=start;
    }
    @Override
    public void run() {
        try {
            for(File file : files)
            {
                BufferedImage image = ImageIO.read(file);
                if(image == null) {
                    continue;
                }
                int newWidth = image.getWidth() / 2;
                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );
                BufferedImage newImage = new BufferedImage(
                        newWidth, newHeight, BufferedImage.TYPE_INT_RGB
                );
                int widthStep = image.getWidth() / newWidth;
                int heightStep = image.getHeight() / newHeight;
                for (int x = 0; x < newWidth; x++)
                {
                    for (int y = 0; y < newHeight; y++) {
                        int rgb = image.getRGB(x * widthStep, y * heightStep);
                        newImage.setRGB(x, y, rgb);
                    }
                }
                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}
public class MainPractice13{
    public static void main(String[] args) throws IOException {
        String srcFolder = "images";
        String dstFolder = "imagesShort";
        File srcDir = new File(srcFolder);
        int coreNumber = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of CPU cores: "+ coreNumber);
        long start = System.currentTimeMillis();
        File[] files = srcDir.listFiles();
        if (!Files.exists(Paths.get(dstFolder)))
        {
            Files.createDirectories(Paths.get(dstFolder));
        }
        int middle = files.length / coreNumber;
        File[][] fail = new File[coreNumber][];
        Thread[] stream = new Thread[coreNumber];
        for(int i = 0; i< coreNumber; i++)
        {
            if(i<(coreNumber -1))
            {
                fail[i]=new File[middle];
            }
            else {
                fail[i]=new File[files.length-middle*i];
            }
            System.arraycopy(files, middle*i,fail[i],0, fail[i].length);
            stream[i]=new ImageResize(fail[i],dstFolder,start);
            stream[i].start();
        }
    }
}