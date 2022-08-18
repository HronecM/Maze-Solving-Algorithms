package HronecM.com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextToMaze {
    public static List<char[][]> textFile(List<String> txtList) throws IOException {
        List<char[][]> mazes = new ArrayList<>();
        String line;
        int row = 0, col = 0, temp;
        for (String path : txtList){

            BufferedReader reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {
                temp = line.length();
                if (col < temp || col == 0) {
                    col = temp;
                }
                row++;
            }

            reader = new BufferedReader(new FileReader(path));
            char[][] maze = new char[row][col];
            int tempRow = 0, tempCol;
            while ((line = reader.readLine()) != null) {
                for(tempCol = 0; tempCol < col; tempCol++){
                    maze[tempRow][tempCol] = line.charAt(tempCol);
                }
                tempRow++;
            }
            mazes.add(maze);
        }
        return mazes;
    }


}
