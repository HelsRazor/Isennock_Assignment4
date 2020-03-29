import java.io.File;

public class Application {

    public static void main(String[] args) {

        File dataFile = new File("problem2.txt");
        File outputFile = new File("unique_word_counts.txt");

        DuplicateCounter dc = new DuplicateCounter();

        dc.count(dataFile);
        dc.write(outputFile);

    }

}
