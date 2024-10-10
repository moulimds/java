import java.util.*;

public class NoPairsAllowed {
    public static void main(String[] args) {
        // Example input list of words
        List<String> words = Arrays.asList("add", "boook", "break");

        // Call the minimalOperations function
        List<Integer> result = minimalOperations(words);

        // Print the result
        System.out.println(result);
    }

    // Function to find the minimal number of substitutions for each word
    public static List<Integer> minimalOperations(List<String> words) {
        List<Integer> result = new ArrayList<>();

        // Loop through each word in the input list
        for (String word : words) {
            int substitutions = 0;

            // Iterate over the word and check for adjacent characters
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) == word.charAt(i - 1)) {
                    // If two adjacent characters are equal, we need to make a substitution
                    substitutions++;
                }
            }
            // Add the count of substitutions to the result list
            result.add(substitutions);
        }

        return result;
    }
}
