package euler;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem22 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String output = Files.readAllLines(Paths.get(Problem22.class.getResource("names.txt").toURI())).get(0);

        //Read sorted strings
        List<String> sortedNameStrings = Arrays.stream(output.split(","))
                                    .map(s -> s.replaceAll("\"", "")).sorted().collect(Collectors.toList());

        //To compute score : COLIN = 5 + ... etc
        Function<String, Long> score = s -> (long)s.chars().boxed().map(x -> x - 'A' + 1).reduce((i, j) -> i + j).get();

        long sum = IntStream.range(0, sortedNameStrings.size())
                .mapToObj(i -> (i + 1) * score.apply(sortedNameStrings.get(i)))
                .mapToLong(Long::longValue).sum();
        System.out.println(sum);
    }
}
