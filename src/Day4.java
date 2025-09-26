import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) throws Exception {
        String[][] input = new String[0][0];
        String[] verify = {"X", "M", "A", "S"};
        int XmasCounter = 0;
        int XCounter = 0;

        File myObj = new File("Day4Input.txt");
        try (Scanner text = new Scanner(myObj)) {
            int counter = 0;
            while (text.hasNextLine()) {
                String[][] inputTemp = Arrays.copyOf(input, input.length + 1);  
                input = inputTemp;
                String line = text.nextLine();
                String[] rowTemp = new String[line.length()];   
                for (int i = 0; i < line.length(); i++) {
                    rowTemp[i] = line.substring(i, i + 1);
                }
                input[counter] = rowTemp;
                counter++;
            }
        }  
        
        //P1
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i][j].equals("X")) {
                    if (i > 2) {
                        int[] tempVerifier = {-1, 2};
                        if (j < 3) {
                            tempVerifier[0] = 0;
                        }
                        if (j > input[i].length - 4) {
                            tempVerifier[1] = 1;
                        }
                        for (int k = tempVerifier[0]; k < tempVerifier[1]; k++) {
                            for (int l = 1; l < 4; l++) {
                                if (input[i - l][j + (k * l)].equals(verify[l])) {
                                    if (l == 3) {
                                        XmasCounter++;
                                    }
                                    continue;
                                }
                                else {
                                    break;
                                }
                            }
                        }
                    }
                    if (i < input.length - 3) {
                        int[] tempVerifier = {-1, 2};
                        if (j < 3) {
                            tempVerifier[0] = 0;
                        }
                        if (j > input[i].length - 4) {
                            tempVerifier[1] = 1;
                        }
                        for (int k = tempVerifier[0]; k < tempVerifier[1]; k++) {
                            for (int l = 1; l < 4; l++) {
                                if (input[i + l][j + (k * l)].equals(verify[l])) {
                                    if (l == 3) {
                                        XmasCounter++;
                                    }
                                    continue;
                                }
                                else {
                                    break;
                                }
                            }
                        }
                    }
                    if (j > 2) {
                        for (int k = 1; k < 4; k++) {
                            if (input[i][j - k].equals(verify[k])) {
                                if (k == 3) {
                                    XmasCounter++;
                                }
                                continue;
                            }
                            else {
                                break;
                            }
                        }
                    }
                    if (j < input[i].length - 3) {
                        for (int k = 1; k < 4; k++) {
                            if (input[i][j + k].equals(verify[k])) {
                                if (k == 3) {
                                    XmasCounter++;
                                }
                                continue;
                            }
                            else {
                                break;
                            }
                        }
                    }
                }
            }
        }

        //P2
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i][j].equals("M")) {
                    if (i > 1) {
                        int[] tempVerifier = {-1, 2};
                        if (j < 2) {
                            tempVerifier[0] = 1;
                        }
                        if (j > input[i].length - 3) {
                            tempVerifier[1] = 1;
                        }
                        for (int k = tempVerifier[0]; k < tempVerifier[1]; k += 2) {
                            for (int l = 1; l < 3; l++) {
                                if (input[i - l][j + (k * l)].equals(verify[l + 1])) {
                                    if (l == 2) {
                                        if (k == -1 && ((input[i][j - 2].equals("M") && input[i - 2][j].equals("S"))
                                        || (input[i][j - 2].equals("S") && input[i - 2][j].equals("M")))) {
                                            XCounter++;
                                        }
                                        else if(k == 1 && ((input[i][j + 2].equals("M") && input[i - 2][j].equals("S"))
                                        || (input[i][j + 2].equals("S") && input[i - 2][j].equals("M")))) {
                                            XCounter++;
                                        }
                                    }
                                    continue;
                                }
                                else {
                                    break;
                                }
                            }
                        }
                    }
                    if (i < input.length - 2) {
                        int[] tempVerifier = {-1, 2};
                        if (j < 2) {
                            tempVerifier[0] = 1;
                        }
                        if (j > input[i].length - 3) {
                            tempVerifier[1] = 1;
                        }
                        for (int k = tempVerifier[0]; k < tempVerifier[1]; k += 2) {
                            for (int l = 1; l < 3; l++) {
                                if (input[i + l][j + (k * l)].equals(verify[l + 1])) {
                                    if (l == 2) {
                                        if (k == -1 && ((input[i][j - 2].equals("M") && input[i + 2][j].equals("S"))
                                        || (input[i][j - 2].equals("S") && input[i + 2][j].equals("M")))) {
                                            XCounter++;
                                        }
                                        else if(k == 1 && ((input[i][j + 2].equals("M") && input[i + 2][j].equals("S"))
                                        || (input[i][j + 2].equals("S") && input[i + 2][j].equals("M")))) {
                                            XCounter++;
                                        }
                                    }
                                    continue;
                                }
                                else {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println(XmasCounter);
        System.out.println(XCounter / 2);
    }
}