package codejam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AlienLanguage {

    private static Function<String, List<String>> splitter = s -> {
        List<String> output = new ArrayList<>();
        boolean isBraceContext = false;
        String subString = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                isBraceContext = true;
            } else if (c == ')'){
                isBraceContext = false;
                output.add(subString);
                subString = "";
            } else {
                //character
                if (isBraceContext) {
                    subString += c;
                } else {
                    output.add("" + c);
                }
            }
        }
        return output;
    };

    static BiFunction<String, List<String>, Boolean> isPermutation = (dictLine, input) -> {
        if (dictLine.length() != input.size()) {
            throw new IllegalArgumentException("Lengths do not match");
        }
        for (int i = 0; i < dictLine.length(); i++) {
            if (!input.get(i).contains("" + dictLine.charAt(i))) {
                return false;
            }
        }
        return true;
    };

    static BiFunction<List<String>, List<String>, Long> permutationCount =
            (dict, input) -> dict.stream().filter(dictLine -> isPermutation.apply(dictLine, input)).count();

    public static void main(String[] args) throws Exception {
        decode("inputs1.txt");
    }

    private static void decode(String fileName) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get(fileName));
        String[] ldn = inputs.get(0).split(" ");
        int l = Integer.valueOf(ldn[0]), d = Integer.valueOf(ldn[1]), n = Integer.valueOf(ldn[2]);
        List<String> dictionary = inputs.subList(1, d + 1);
        List<List<String>> patterns = inputs.subList(d + 1, inputs.size()).stream()
                .map(splitter)
                .collect(Collectors.toList());
        for (int i = 0; i < patterns.size(); i++) {
            System.out.println("Case #" + (i+1) + ": " + permutationCount.apply(dictionary, patterns.get(i)));
        }
    }
}
