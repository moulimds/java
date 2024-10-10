import java.util.*;

public class StringChains {

    public static int longestChain(int n, String[] words) {
        // Sort words based on their lengths, this helps in forming valid chains
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        // HashMap to store the longest chain ending with each word
        Map<String, Integer> dp = new HashMap<>();
        int longestChain = 1;

        // Process each word
        for (String word : words) {
            dp.put(word, 1);  // The word itself is the start of its own chain

            // Try removing each character to form a new word
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);  // Remove the character at index i
                String predecessor = sb.toString();

                if (dp.containsKey(predecessor)) {
                    dp.put(word, Math.max(dp.get(word), dp.get(predecessor) + 1));
                }
            }

            // Update the longest chain found so far
            longestChain = Math.max(longestChain, dp.get(word));
        }

        return longestChain;
    }

    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        int n = words.length;

        System.out.println(longestChain(n, words));  // Output: 4
    }
}
