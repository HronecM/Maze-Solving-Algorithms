package HronecM.com.Scanners.Query;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QueryAllBmp {
    public static List<String> queryAllBmp(String directory) {
        List<String> bmpFiles = new ArrayList<>();
        File dir = new File(directory);
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.getName().endsWith((".bmp"))) {
                bmpFiles.add(file.getName());
            }
        }
        return bmpFiles;
    }
}
