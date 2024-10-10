import java.util.Arrays;

public class ProjectEstimates {

    public static int getMinProcessingTime(int[] data, int processTimeA, int processTimeB) {
        Arrays.sort(data);  // Sort data files to allocate optimally

        int timeA = 0; // Total time taken by Processor A
        int timeB = 0; // Total time taken by Processor B

        for (int i = data.length - 1; i >= 0; i--) {
            if (timeA + (data[i] * processTimeA) <= timeB + (data[i] * processTimeB)) {
                timeA += data[i] * processTimeA;  // Assign to Processor A
            } else {
                timeB += data[i] * processTimeB;  // Assign to Processor B
            }
        }

        return Math.max(timeA, timeB); // The total processing time is the max of both processors
    }

    public static void main(String[] args) {
        int[] data = {4, 6, 2, 5};
        int processTimeA = 3;
        int processTimeB = 2;
        
        int result = getMinProcessingTime(data, processTimeA, processTimeB);
        System.out.println("Minimum Processing Time: " + result);
    }
}