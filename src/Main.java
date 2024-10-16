import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        try {
            database.read("data.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
            System.exit(-1);
        } catch (InvalidInputException | NegativeSideException | NoSuchElementException ex) {
            System.exit(-1);
        }
//        database.report();
        database.getMinMaxBBCoordinates();
    }
}