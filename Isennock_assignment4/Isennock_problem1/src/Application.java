import java.io.File;
import java.io.FileWriter;

public class Application {
    public static void main(String[] args) {

        File dataFile = new File("problem1.txt");
        File outputFile = new File("unique_words.txt");

        DuplicateRemover dupRem = new DuplicateRemover();

        dupRem.remove(dataFile);

        dupRem.write(outputFile);

    }
}
