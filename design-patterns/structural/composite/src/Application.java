import file.File;
import file.Folder;

/**
 * Client Application
 */
public class Application {
    public static void main(String[] args) {
        File file1 = new File("profile.jpg", 200);
        File file2 = new File("notes.txt", 500);

        Folder documents = new Folder("Documents");
        documents.addItem(file1);
        documents.addItem(file2);

        // print structure
        documents.printStructure("");

        // get total size
        System.out.println("total size: " + documents.getSize());
    }
}
