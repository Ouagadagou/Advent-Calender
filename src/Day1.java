import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws Exception {
        int[] left = new int[0];
        int[] right = new int[0];
        int totalDifference = 0;
        int totalSimilarity = 0;

        File myObj = new File("Day1Input.txt");
        try (Scanner text = new Scanner(myObj)) {
            while (text.hasNextLine()) {
                String line = text.nextLine();
                int[] leftTemp = Arrays.copyOf(left, left.length + 1);     
                int[] rightTemp = Arrays.copyOf(right, right.length + 1);     
                leftTemp[left.length] = Integer.valueOf(line.substring(0, 5));
                rightTemp[right.length] = Integer.valueOf(line.substring(8, 13));
                left = leftTemp;
                right = rightTemp;
            }
        }
        Arrays.sort(left);
        Arrays.sort(right);

        //P1
        for (int i = 0; i < left.length; i++) {
            totalDifference += Math.abs(left[i] - right[i]);
        }

        //P2
        for (int i = 0; i < left.length; i++) {
            int similarAmount = 0;
            for (int j = 0; j < left.length; j++) {
                    if (left[i] == right[j]) {
                        similarAmount++;
                    }
            }
            totalSimilarity += similarAmount * left[i];
        }
        
        System.out.println(totalDifference);
        System.out.println(totalSimilarity);
    }
}
