import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.util.Scanner;


public class Day3 {
    public static void main(String[] args) throws Exception {
        int totalP1 = 0;
        int totalP2 = 0;
        boolean state = true;

        Pattern patternMul = Pattern.compile("mul\\(([0-9]+)\\,([0-9]+)\\)");
        Pattern patternDo = Pattern.compile("mul\\(([0-9]+)\\,([0-9]+)\\)|(do\\(\\))|(don't\\(\\))");
        File myObj = new File("Day3Input.txt");
        try (Scanner text = new Scanner(myObj)) {
            while (text.hasNextLine()) {
                String line = text.nextLine();

                //P1
                Matcher matchTester = patternMul.matcher(line);
                while (matchTester.find()) {
                    int tempNumber = Integer.valueOf(matchTester.group(1)) * Integer.valueOf(matchTester.group(2));
                    totalP1 += tempNumber;
                }

                //P2
                Matcher matchTester2 = patternDo.matcher(line);
                while (matchTester2.find()) {
                    if (matchTester2.group(3) != null) {
                        state = true;
                    }
                    else if (matchTester2.group(4) != null) {
                        state = false;
                    }
                    else if (state && matchTester2.group(1) != null) {
                        int tempNumber = Integer.valueOf(matchTester2.group(1)) * Integer.valueOf(matchTester2.group(2));
                        totalP2 += tempNumber;
                    }
                }
            }
        }    
        
        System.out.println(totalP1);
        System.out.println(totalP2);
    }
}

