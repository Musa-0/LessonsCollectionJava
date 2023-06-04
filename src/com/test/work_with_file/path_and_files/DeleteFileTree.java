package com.test.work_with_file.path_and_files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DeleteFileTree {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/com/test/work_with_file/path_and_files/copy_test_dir");
        Files.walkFileTree(path,new MyFileVisitor3());//проходимся по файлу копируя элементы из souce в destination
    }
}

class MyFileVisitor3 extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {//удаляем файлы
        System.out.println("Удаляем файл " + file.getFileName());
        Files.delete(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {//после удаления файлов удаляем папку
        System.out.println("Удаляем папку " + dir.getFileName());
        Files.delete(dir);
        return FileVisitResult.CONTINUE;

    }
}
