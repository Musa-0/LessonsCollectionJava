package com.test.work_with_file.path_and_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Path_Files2 {
    public static void main(String[] args) throws IOException {
        Path filepath = Paths.get("src/com/test/work_with_file/files/testfilePath_Files2.txt");
        Path directorypath = Paths.get("src/com/test/work_with_file/files/testdirectoryPath_Files");

        Files.copy(filepath, directorypath.resolve("file_before_copy.txt"));//файл filepath скопируется в файл созданный
        // по пути directorypath + "file_before_copy.txt", надо указать файл который копируем и файл в который копируем первый файл

        Files.copy(filepath,directorypath.resolve(filepath.getFileName()), StandardCopyOption.REPLACE_EXISTING);//скопирует
        //файл, но если такой файл уже существует по указанному пути, то заменить его на тот что мы копируем

        Files.copy(directorypath, directorypath.resolve(directorypath.getFileName()));//копирует папку, но без содержимого
        //чтобы скопировать содержимое, надо переместить каждый файл по отдельности

        Files.move(directorypath.resolve("file_before_copy.txt"), directorypath.
                resolve(directorypath.getFileName().resolve("test.txt")));//перемещает файл

        //чтобы переминовать файл, его нужно просто переместить в ту же папку
        //Files.move("file1.txt", "file2.txt"); таким образом file1 теперь называется file2

        Files.delete(directorypath.resolve(directorypath.getFileName().resolve("test.txt")));//удалит этот файл
        Files.delete(directorypath.resolve(directorypath.getFileName()));//удалит эту уже пустую папку, будь она не
        // пустой, была бы ошибка. нужно сначала удалить все файлы, а потом удалять папку

    }
}
