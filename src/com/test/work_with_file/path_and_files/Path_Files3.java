package com.test.work_with_file.path_and_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Path_Files3 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("src/com/test/work_with_file/files/testfilePath_Files3.txt");
        String dialog = "-Privet\n-Privet\n-Kak dela?\n-Good!";
        Files.write(filePath, dialog.getBytes());//запишем в файл наш диалог

        List<String> list_line = Files.readAllLines(filePath);//прочтет и вернет лист стрингов

        for (String s: list_line){
            System.out.println(s);
        }
    }
}
