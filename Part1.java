import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Part1 {
    public static void main(String[] args) throws IOException {

        int maxCalories = 0, tempSum = 0;
        String filePath = "input.txt";

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            for (String line : (Iterable<String>) stream::iterator) {
                if (!line.isEmpty()) { // Check for empty line
                    tempSum += Integer.parseInt(line);
                } else {
                    // Handle empty line (e.g., reset tempSum)
                    tempSum = 0;
                }
                maxCalories = Math.max(maxCalories, tempSum);
            }
        }
        System.out.println("The elf with the most calories has: " + maxCalories);
    }
}
