package HronecM.com;

import HronecM.com.Objects.Maze;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BitmapToMaze {
    public static List<Maze> bitmapFile(List<String> bmpList) throws IOException {
        List<Maze> mazes = new ArrayList<>();
        Maze maze;
        String dir = System.getProperty("user.dir") + "\\src\\main\\resources\\";
        BufferedImage img;
        for (String path : bmpList) {
            img = ImageIO.read(new File(dir + path));
            int height = img.getHeight();
            int width = img.getWidth();
            char[][] tempMaze = new char[height][width];
            maze = new Maze(tempMaze);

            for (int h = 0; h < height; h++) {

                for (int w = 0; w < width; w++) {
                    int rgb = img.getRGB(w, h);
                    int red = (rgb >> 16) & 255;
                    int green = (rgb >> 8) & 255;
                    int blue = (rgb) & 255;

                    if (red == 0 & green == 0 & blue == 0) tempMaze[h][w] = '#';
                    else if (red > green && red>blue ) {
                        maze.setStart(w, h);
                        tempMaze[h][w] = 'S';
                    } else if (green > red && green > blue) {
                        maze.setEnd(w, h);
                        tempMaze[h][w] = 'X';
                    } else tempMaze[h][w] = '.';
                }
            }
            mazes.add(maze);
        }
        return mazes;
    }
}