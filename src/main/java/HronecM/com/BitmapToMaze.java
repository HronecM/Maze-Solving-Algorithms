package HronecM.com;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BitmapToMaze {
    public static List<char[][]> bitmapFile(List<String> bmpList) {
        List<char[][]> mazes = new ArrayList<>();
        String line;
        int rgb;
        BufferedImage img;
        for (String path : bmpList) {
            try {
                img = ImageIO.read(new File(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int height = img.getHeight();
            int width = img.getWidth();
            char[][] maze = new char[height][width];
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    rgb = img.getRGB(w, h);
                    int red = (rgb >> 16) & 255;
                    int green = (rgb >> 8) & 255;
                    int blue = (rgb) & 255;

                    // F importing Color just to group rgb values
                    if (red == 0 & green == 0 & blue == 0) {
                        maze[h][w] = '#';
                    } else  {
                        maze[h][w] = '#';
                    }

                }
            }
            mazes.add(maze);
        }
        return mazes;
    }
}
