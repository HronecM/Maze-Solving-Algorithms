package HronecM.com.Scanners.Query;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class QueryFileFinder {
    public static String query(String directory) {
        Scanner scanner = new Scanner(System.in);
        List<String> txtFiles = new ArrayList<>();
        List<String> bmpFiles = new ArrayList<>();

        File dir = new File(directory);
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.getName().endsWith((".bmp"))) {
                bmpFiles.add(file.getName());
            }
            if (file.getName().endsWith((".txt"))) {
                txtFiles.add(file.getName());
            }
        }
        if (bmpFiles.isEmpty() & txtFiles.isEmpty()) {
            System.out.println("No viable maze file!");
            System.out.println("Please use either a bitmap with with two open edges or text file where:");
            System.out.println("\t. = Empty tile \n\t# = Wall tile \n\tS = Start tile\n\tX = End tile");
            System.exit(0);
        } else {
            System.out.println("List of viable files found in local directory: ");
            int val, tempVal = 0;
            int fileNum = bmpFiles.size() + txtFiles.size();
            for (val = 0; val < fileNum; val++) {
                if (val < txtFiles.size()) {
                    System.out.println(val + 1 + ". " + txtFiles.get(val));
                } else {
                    System.out.println(val + 1 + ". " + bmpFiles.get(tempVal));
                    tempVal++;
                }
            }

            System.out.println("Please select maze: ");
            while (true) {
                String input = scanner.nextLine();
                if (input.isEmpty()) System.exit(0);
                int select = Integer.parseInt(input);

                if (input.matches("\\d+") && select <= val) {
                    if (select >= tempVal) {
                        return bmpFiles.get((select - tempVal));
                    } else return txtFiles.get(select-1);
                }

                if (!txtFiles.isEmpty()) {
                    for (String temp : txtFiles) {
                        if ((input + ".txt").equals(temp) || input.equals(temp)) return temp;
                    }
                }

                if (!bmpFiles.isEmpty()) {
                    for (String temp : bmpFiles) {
                        if ((input + ".bpm").equals(temp) || input.equals(temp)) return temp;
                    }
                }
                System.out.println("Wrong file name please try again or press enter to exit");
            }
        }

        return null;
    }
}
