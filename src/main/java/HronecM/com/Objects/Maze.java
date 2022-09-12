package HronecM.com.Objects;

import java.awt.*;

public class Maze {


    char[][] maze;
    Point start;
    Point end;
    public Maze(char[][] tempMaze) {
    }

    public char getTile(int row, int col){
        return maze[row][col];
    }

    public char[][] getMaze() {
        return maze;
    }

    public void setMaze(char[][] maze) {
        this.maze = maze;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

}
