import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) throws Exception {
        String[][] inputConditions = new String[0][0];
        String[][] inputPages = new String[0][0];
        int pageCounter = 0;
        int incorrectPageCounter = 0;

        File myObj = new File("Day5Input.txt");
        try (Scanner text = new Scanner(myObj)) {
            int counter = 0;
            boolean skipped = false;
            while (text.hasNextLine()) {
                String line = text.nextLine();
                if (line == "") {
                    counter = 0;
                    skipped = true;
                    continue;
                }
                if (skipped) {
                    String[][] inputTemp = Arrays.copyOf(inputPages, inputPages.length + 1);  
                    inputPages = inputTemp;
                    String[] rowTemp = new String[(line.length() + 1) / 3];   
                    for (int i = 0; i < line.length(); i += 3) {
                        rowTemp[i / 3] = line.substring(i, i + 2);
                    } 
                    inputPages[counter] = rowTemp;
                    counter++;
                }
                else {
                    String[][] inputTemp = Arrays.copyOf(inputConditions, inputConditions.length + 1);  
                    inputConditions = inputTemp;
                    String[] rowTemp = {line.substring(0, 2), line.substring(3, 5)};   
                    inputConditions[counter] = rowTemp;
                    counter++;
                }
            }

            //P1 && P2
            for (int i = 0; i < inputPages.length; i++) {
                boolean state = true;
                System.out.println(inputPages.length);
                for (int j = 0; j < inputPages[i].length - 1 && state; j++) {
                    for (int k = j + 1; k < inputPages[i].length && state; k++ ) {
                        for (int l = 0; l < inputConditions.length; l++) {
                            if (inputPages[i][j].equals(inputConditions[l][0]) && inputPages[i][k].equals(inputConditions[l][1])) {
                                break;
                            }
                            else if(l == inputConditions.length - 1) {
                                state = false;
                                break;
                            }
                        }
                    }
                }
                if (state) {
                    pageCounter += Integer.valueOf(inputPages[i][(inputPages[i].length - 1) / 2]);
                }
                else {
                    for (int j = 0; j < inputPages[i].length - 1 && state; j++) {
                        boolean state2 = false;
                        for (int k = j + 1; k < inputPages[i].length && state; k++ ) {
                            for (int l = 0; l < inputConditions.length; l++) {
                                if (inputPages[i][j].equals(inputConditions[l][0]) || inputPages[i][j].equals(inputConditions[l][1])) {
                                    state2 = true;
                                }
                                if (inputPages[i][j].equals(inputConditions[l][0]) && inputPages[i][k].equals(inputConditions[l][1])) {
                                    break;
                                }
                                else if(l == inputConditions.length - 1) {
                                    if (state2) {
                                        String temp = inputPages[i][inputPages[i].length - 1];
                                        inputPages[i][inputPages[i].length - 1] = inputPages[i][j];
                                        inputPages[i][j] = temp;
                                    }
                                    else {
                                        String temp = inputPages[i][j];
                                        inputPages[i][j] = inputPages[i][j + 1];
                                        inputPages[i][j + 1] = temp;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    System.out.println(Arrays.toString(inputPages[i]));
                    incorrectPageCounter += Integer.valueOf(inputPages[i][(inputPages[i].length - 1) / 2]);
                }
            }

            System.out.println(pageCounter);
            System.out.println(incorrectPageCounter);
        }  
    }
}
