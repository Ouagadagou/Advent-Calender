import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws Exception {
        int[][] main = new int[0][0];
        int lineCounter = 0;
        File myObj = new File("Day2Input.txt");
        int totalReport = 0;
        int totalSimplerReport = 0;
        
        try (Scanner text = new Scanner(myObj)) {
            while (text.hasNextLine()) {
                int[][] mainRowTemp = Arrays.copyOf(main, main.length + 1);     
                main = mainRowTemp;
                String line = text.nextLine();
                int lastSpace = -1;
                int[] row = new int[0];
                for (int i = 0; i < line.length(); i++) {
                    if (line.substring(i,i + 1).equals(" ")) {
                        int[] rowTemp = Arrays.copyOf(row, row.length + 1);
                        rowTemp[row.length] = Integer.valueOf(line.substring(lastSpace + 1, i));
                        row = rowTemp;
                        lastSpace = i;
                    }
                    else if (i == line.length() - 1) {
                        int[] rowTemp = Arrays.copyOf(row, row.length + 1);  
                        rowTemp[row.length] = Integer.valueOf(line.substring(lastSpace + 1, i + 1));
                        row = rowTemp;
                        main[lineCounter] = row;
                    }
                }
                lineCounter++;
            }
        }  
        
        for (int i = 0; i < main.length; i++) {
            //P1
            boolean incrementing = true;
            boolean wait = false;
            if (main[i][0] > main[i][1]) {
                incrementing = false;
            }
            else if (main[i][0] == main[i][1]) {
                if (main[i][1] == main[i][2]) {
                    wait = true;
                }
                else {
                    if (main[i][1] > main[i][2]) {
                        incrementing = false;
                    }
                }
            }

            if (wait != true) {
                for (int j = 0; j < main[i].length; j++) {
                    if (j == main[i].length - 1) {
                        totalReport++;
                        break;
                    }
                    if (incrementing == true && main[i][j] < main[i][j + 1] && Math.abs(main[i][j] - main[i][j + 1]) <= 3) {
                        continue;
                    }
                    else if (incrementing == false && main[i][j] > main[i][j + 1] && Math.abs(main[i][j] - main[i][j + 1]) <= 3) {
                        continue;
                    }
                    else {
                        break;
                    }
                }
            }
            
            //P2
            boolean mistake = false;
            int increases = 0;
            int decreases = 0;
            for (int j = 0; j < 4; j++) {
                if (main[i][j] > main[i][j + 1]) {
                    decreases++;
                }
                else if (main[i][j] < main[i][j + 1]) {
                    increases++;
                }
            }
            int incORdec = increases - decreases;
            if (incORdec == 0) {
                continue;
            }
            else if (incORdec > 0) {
                incrementing = true;
            }
            else {
                incrementing = false;
            }
            for (int j = 0; j < main[i].length; j++) {
                if (j == main[i].length - 1) {
                    totalSimplerReport++;
                    break;
                }
                if (incrementing == true && main[i][j] < main[i][j + 1] && Math.abs(main[i][j] - main[i][j + 1]) <= 3) {
                    continue;
                }
                else if (incrementing == false && main[i][j] > main[i][j + 1] && Math.abs(main[i][j] - main[i][j + 1]) <= 3) {
                    continue;
                }
                else if (mistake){
                    break;
                }
                else {
                    mistake = true;
                    if (j == main[i].length - 2) {
                        totalSimplerReport++;
                        break;
                    }
                    if (j == 0) {
                        if (incrementing == true && main[i][j] < main[i][j + 2] && Math.abs(main[i][j] - main[i][j + 2]) <= 3) {
                        }
                        else if (incrementing == false && main[i][j] > main[i][j + 2] && Math.abs(main[i][j] - main[i][j + 2]) <= 3) {
                        }
                        else if (incrementing == true && main[i][j + 1] < main[i][j + 2] && Math.abs(main[i][j + 1] - main[i][j + 2]) <= 3) {
                        }
                        else if (incrementing == false && main[i][j + 1] > main[i][j + 2] && Math.abs(main[i][j + 1] - main[i][j + 2]) <= 3) {
                        }
                        else {
                            break;
                        }
                        j++;
                        continue;
                    }
                    else {
                        if (incrementing == true && main[i][j] < main[i][j + 2] && Math.abs(main[i][j] - main[i][j + 2]) <= 3) {
                        }
                        else if (incrementing == false && main[i][j] > main[i][j + 2] && Math.abs(main[i][j] - main[i][j + 2]) <= 3) {
                        }
                        else if (incrementing == true && main[i][j + 1] < main[i][j + 2] && Math.abs(main[i][j + 1] - main[i][j + 2]) <= 3) {
                            if (incrementing == true && main[i][j - 1] < main[i][j + 1] && Math.abs(main[i][j - 1] - main[i][j + 1]) <= 3) {
                            }
                            else if (incrementing == false && main[i][j - 1] > main[i][j + 1] && Math.abs(main[i][j - 1] - main[i][j + 1]) <= 3) {
                            }
                            else {
                                break;
                            }
                        }
                        else if (incrementing == false && main[i][j + 1] > main[i][j + 2] && Math.abs(main[i][j + 1] - main[i][j + 2]) <= 3) {
                            if (incrementing == true && main[i][j - 1] < main[i][j + 1] && Math.abs(main[i][j - 1] - main[i][j + 1]) <= 3) {
                            }
                            else if (incrementing == false && main[i][j - 1] > main[i][j + 1] && Math.abs(main[i][j - 1] - main[i][j + 1]) <= 3) {
                            }
                            else {
                                break;
                            }
                        }
                        else {
                            break;
                        }
                        j++;
                        continue;
                    }
                }
            }
        }

        System.out.println(totalReport);
        System.out.println(totalSimplerReport);
    }
}