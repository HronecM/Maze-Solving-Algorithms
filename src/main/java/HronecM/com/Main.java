package HronecM.com;

import HronecM.com.Scanners.DirFileFinder;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        /*
         bitmap
         txt file
         */
        File file;
        String path;
        if (args.length == 0) {
            String dir = System.getProperty("user.dir");
            path = DirFileFinder.dir(dir);
        } else{
            file = new File(args[0]);
            if(!file.exists()){
                System.out.println("Incorrect file path!");
                System.exit(0);
            }
        }




    }
}