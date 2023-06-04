package com.test.work_with_file.path_and_files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
//скопируем директорию с файлами и папками в другую директорию
public class CopyFileTree {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("src/com/test/work_with_file/path_and_files/test_dir");//папка из которой будем копировать
        Path destination = Paths.get("src/com/test/work_with_file/path_and_files/copy_test_dir");//папка куда будем копировать
        Files.walkFileTree(source,new MyFileVisitor2(source,destination));//проходимся по файлу копируя элементы из souce в destination
    }
}

class MyFileVisitor2 extends SimpleFileVisitor<Path>{//SimpleFileVisitor - позволяют оверайдить лишь те методы которые нам нужны

    private Path source;//папка из которой копируем
    private Path destination;//папка куда копируем

    public MyFileVisitor2(Path source, Path destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {//копируем пустую папку
        Path newDestination = destination.resolve(source.relativize(dir));//создаем путь для новой папки в которую будем копировать
        Files.copy(dir, newDestination);//копируем папку из одной папки в другую
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {//копируем каждый файл из папки
        Path newDestination = destination.resolve(source.relativize(file));//объеденяем относительный путь тек папки, с другой папкой
        Files.copy(file,newDestination);
        return FileVisitResult.CONTINUE;
    }
}
