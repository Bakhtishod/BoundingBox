import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Database {
    final ArrayList<Shape> shapes;

    public Database() {
        shapes = new ArrayList<>();
    }

    public void read(String filename) throws FileNotFoundException, InvalidInputException, NegativeSideException, NoSuchElementException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));

        try {
            int numShapes = sc.nextInt();

            for (int i = 0; i < numShapes; i++) {
                Shape shape;
                String category = sc.next();
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                double sideOrRadius = sc.nextDouble();

                if(sideOrRadius<0)
                    throw new NegativeSideException();

                shape = switch (category) {
                    case "C" -> new Circle(x, y, sideOrRadius);
                    case "S" -> new Square(x, y, sideOrRadius);
                    case "T" -> new Triangle(x, y, sideOrRadius);
                    case "H" -> new Hexagon(x, y, sideOrRadius);
                    default -> throw new InvalidInputException();
                };

                shapes.add(shape);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid data input!");
            throw new InputMismatchException();
        } catch (NoSuchElementException e) {
            System.out.println("Some fields of data are missing!");
            throw new NoSuchElementException();
        }
    }

    public void report() {
        System.out.println("A list of shapes: ");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    public void getMinMaxBBCoordinates(){
        double minX = Double.MAX_VALUE, maxX = 0;
        double minY = Double.MAX_VALUE, maxY = 0;

        for (Shape shape : shapes) {
            minX = Math.min(minX, shape.getBBCoordinates().minX);
            minY = Math.min(minY, shape.getBBCoordinates().minY);
            maxX = Math.max(maxX, shape.getBBCoordinates().maxX);
            maxY = Math.max(maxY, shape.getBBCoordinates().maxY);
        }

        System.out.println("Smallest bounding box coordinates:");
        System.out.println("Minimum X: " + minX);
        System.out.println("Minimum Y: " + minY);
        System.out.println("Maximum X: " + maxX);
        System.out.println("Maximum Y: " + maxY);
    }
}
