import java.util.HashSet;
import java.util.Set;

public class ProjectCosts {
    public static void main(String[] args) {
        int[] projectCosts = {1, 3, 5};
        int target = 2;
        System.out.println(countPairs(projectCosts, target));  // Output: 2
    }

    public static int countPairs(int[] projectCosts, int target) {
        Set<Integer> costSet = new HashSet<>();
        int count = 0;

        // Insert all project costs into the set
        for (int cost : projectCosts) {
            costSet.add(cost);
        }

        // Check for each cost if the complement (cost + target) or (cost - target) exists
        for (int cost : projectCosts) {
            if (costSet.contains(cost + target)) {
                count++;
            }
            if (costSet.contains(cost - target)) {
                count++;
            }
            // Remove the current element to avoid counting the same pair twice
            costSet.remove(cost);
        }

        return count;
    }
}
