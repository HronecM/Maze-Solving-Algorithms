package HronecM.com.Scanners.Query;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QueryAllTxt {
    public static List<String> queryAllTxt(String directory) {
        List<String> txtFiles = new ArrayList<>();
        File dir = new File(directory);
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.getName().endsWith((".txt"))) txtFiles.add(file.getName());
        }
        return txtFiles;
    }
}
