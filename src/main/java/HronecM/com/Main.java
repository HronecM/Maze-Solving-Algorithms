package HronecM.com;

import HronecM.com.Scanners.DirAllBmp;
import HronecM.com.Scanners.DirAllTxt;
import HronecM.com.Scanners.DirFileFinder;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file;
        String temp;
        String dir = System.getProperty("user.dir");
        List<String> txtList = new ArrayList<>();
        List<String> bmpList = new ArrayList<>();

        if (args.length == 0) {
            temp = DirFileFinder.dir(dir);
            if (temp.contains("txt")) txtList.add(temp);
            else bmpList.add(temp);
        } else if (args[0].equals("alltxt")) txtList = DirAllTxt.dirAllTxt(dir);
        else if (args[0].equals("allbmp")) bmpList = DirAllBmp.dirAllBmp(dir);
        else {
            temp = args[0];
            file = new File(args[0]);
            if (!file.exists()) {
                System.out.println("Incorrect file path!");
                System.exit(0);
            } else if (temp.contains("txt")) txtList.add(temp);
            else bmpList.add(temp);
        }


    }
}