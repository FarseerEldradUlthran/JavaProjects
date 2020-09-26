import java.util.Scanner;

public class Book {
    Scanner in = new Scanner(System.in);
    String name = in.nextLine();
    String title = in.nextLine();
    int volumes = in.nextInt();
    int pages = in.nextInt();
    void characteristics() {System.out.print("The name of the author is " + name + "\n" + "The book title is " + title + "\n" + "At this book you have " + volumes + " volumes and " + pages + " pages");}
}
class BookTest {
    public static void main(String[] args) {
        System.out.print("Input the name of the author, book title, the number of volumes and the number of pages:" + "\n");
        Book show = new Book();
        show.characteristics();
    }
}