package HronecM.com;

import HronecM.com.Objects.Maze;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextToMaze {
    public static List<Maze> textFile(List<String> txtList) throws IOException {
        List<Maze> mazes = new ArrayList<>();
        String line;
        int row = 0, col = 0, temp;
        for (String path : txtList) {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {
                temp = line.length();
                if (col < temp || col == 0) col = temp;
                row++;
            }

            reader = new BufferedReader(new FileReader(path));
            char[][] tempMaze = new char[row][col];
            Maze maze = new Maze(tempMaze);
            int tempRow = 0, tempCol;
            while ((line = reader.readLine()) != null) {
                for (tempCol = 0; tempCol < col; tempCol++) {
                    if (line.charAt(tempCol) == 'S') {
                        maze.setStart(tempCol, tempRow);
                    } else if (line.charAt(tempCol) == 'X') {
                        maze.setEnd(tempCol, tempRow);
                    }
                    tempMaze[tempRow][tempCol] = line.charAt(tempCol);
                }
                tempRow++;
            }
            maze.setMazeGrid(tempMaze);
            maze.setSize(col, row);
            mazes.add(maze);

        }
        return mazes;
    }


}
