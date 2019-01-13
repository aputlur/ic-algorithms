package org.algos.ic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicateFiles {

    public static void main(String[] args) throws IOException {

        findDuplicateFiles("/tmp/test/");
    }

    public static String findDuplicateFiles(String filePath) throws IOException {

        List<Path> paths = Files.list(Paths.get(filePath)).collect(Collectors.toList());
        HashMap<String,String> contentToPath = new HashMap<>();
        HashMap<String,String> duplicates = new HashMap<>();
        for(Path path : paths){
            String st =  new String(Files.readAllBytes(path));
            if(!contentToPath.containsKey(st))
            contentToPath.put(st, path.getFileName().toString());
            else
                duplicates.put(path.getFileName().toString(), contentToPath.get(st));
        }
        System.out.println(duplicates);
        return null;
    }

}
