import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Part2 {
    public static void main(String[] args) throws IOException {
        String inputFileName = "input.txt";

        try (Stream<String> stream = Files.lines(Paths.get(inputFileName))) {
            PriorityQueue<Integer> top3Calories = new PriorityQueue<>();
            int currentElfTotal = 0;

            for (String line : (Iterable<String>) stream::iterator) {
                if (line.isEmpty()) {
                    top3Calories.offer(currentElfTotal);

                    if (top3Calories.size() > 3) {
                        top3Calories.poll();
                    }

                    currentElfTotal = 0;
                } else {
                    currentElfTotal += Integer.parseInt(line);
                }
            }

            top3Calories.offer(currentElfTotal);

            if (top3Calories.size() > 3) {
                top3Calories.poll();
            }

            int sumOfTop3 = top3Calories.stream().mapToInt(Integer::intValue).sum();

            System.out.println("The total calories carried by the top 3 elves is " + sumOfTop3);
        } catch (IOException ex) {
            System.out.println("Error reading file: " + inputFileName);
        }
    }
}
