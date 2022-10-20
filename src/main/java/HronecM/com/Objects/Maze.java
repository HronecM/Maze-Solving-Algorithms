package HronecM.com.Objects;

import java.awt.*;

public class Maze {

    char[][] mazeGrid;
    Point start;
    Point end;
    int width;
    int height;

    public Maze(char[][] tempMaze) {
        mazeGrid = tempMaze;
    }

    public char getTile(int row, int col){
        return mazeGrid[row][col];
    }

    public char[][] getMazeGrid() {
        return mazeGrid;
    }

    public void setMazeGrid(char[][] mazeGrid) {
        this.mazeGrid = mazeGrid;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(int a, int b) {
        start = new Point(a,b);
    }

    public void setSize(int a, int b) {
        width = a;
        height = b;
    }

    public int getSizeHeight(){
        return height;
    }

    public int getSizeWidth(){
        return width;
    }

    public void setEnd(int a, int b) {
        end = new Point(a,b);
    }
}
