package HronecM.com;

import HronecM.com.Scanners.Query.QueryAllBmp;
import HronecM.com.Scanners.Query.QueryAllTxt;
import HronecM.com.Scanners.Query.QueryFileFinder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File file;
        String temp;
        String dir = System.getProperty("user.dir") +"\\src\\main\\resources";
        List<String> txtList = new ArrayList<>();
        List<String> bmpList = new ArrayList<>();
        List<char[][]> mazes = new ArrayList<>();

        if (args.length == 0) {
            temp = QueryFileFinder.query(dir);
            if (temp.contains("txt")) txtList.add(temp);
            else bmpList.add(temp);
        } else if (args[0].equals("alltxt")) txtList = QueryAllTxt.queryAllTxt(dir);
        else if (args[0].equals("allbmp")) bmpList = QueryAllBmp.queryAllBmp(dir);
        else {
            temp = args[0];
            file = new File(args[0]);
            if (!file.exists()) {
                System.out.println("Incorrect file path!");
                System.exit(0);
            } else if (temp.contains("txt")) txtList.add(temp);
            else bmpList.add(temp);
        }

        if (!txtList.isEmpty()) mazes = TextToMaze.textFile(txtList);
        if (!bmpList.isEmpty()) mazes = BitmapToMaze.bitmapFile(bmpList);


    }
}