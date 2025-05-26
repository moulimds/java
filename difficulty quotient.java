import java.util.Scanner;

public class difficulty quotient {
    public static int Difficulty(String str) {
        if (str == null) return 0;

        String[] words = str.split(" ");
        int hard = 0, easy = 0;

        for (String word : words) {
            int vowels = countVowels(word);
            int consonants = word.length() - vowels;
            boolean hasConsecutiveConsonants = hasConsecutiveConsonants(word);

            if (consonants > vowels || hasConsecutiveConsonants) {
                hard++;
            } else {
                easy++;
            }
        }

        return 5 * hard - 2 * easy;
    }

    public static int countVowels(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                count++;
            }
        }
        return count;
    }

    public static boolean hasConsecutiveConsonants(String word) {
        int consecutiveConsonants = 0;
        for (char c : word.toCharArray()) {
            if (!isVowel(c)) {
                consecutiveConsonants++;
                if (consecutiveConsonants >= 3) {
                    return true;
                }
            } else {
                consecutiveConsonants = 0;
            }
        }
        return false;
    }

    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String str = scanner.nextLine();
        int difficulty = Difficulty(str);
        System.out.println("Difficulty quotient: " + difficulty);
    }
}
