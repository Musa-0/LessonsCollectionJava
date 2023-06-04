package com.test.work_with_file.path_and_files;
//Files.walkFileTree(Path start, FileVisitor visitor) используется для обхода дерева файлов
//Path start - это файл с которого начинаем обход

//FileVisitor visitor - это интерфейс описывающий логика обхода дерева файлов
//preVisitDirectory - срабатывает перед обращением к элементам директории. когда натыкается на папку
//visitFile -срабатывает при обращении к элементам. когда натыкается на файл
//postVisitDirectory -срабатывает после обращения к элементам директории. когда натыкается на папку
//visitFileFailed -срабатывает когда файл по каким-то причинам не доступен

//но чтобы не использовать все эти методы, можно использовать SimpliFileVisitor, который имеет базовые методы,
// и можно тупо переопределить те что нам нужны

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFileTreeEx {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/com/test/work_with_file/path_and_files/test_dir");//укажем папку которую будем обходить
        Files.walkFileTree(path,new MyFileVisitor());//переаем нашу папку, и логику обхода папки
    }
}
class MyFileVisitor implements FileVisitor<Path>{//имплементируем интерфейс логики обхода дирректории

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {//срабатывает перед обращением к элементам папке
        System.out.println("Вошли в директорию " + dir);
        return FileVisitResult.CONTINUE;//продолжаем работать
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {//срабатывает при обращении к элементам именно файлам
        System.out.println("File name: " + file.getFileName());
        return FileVisitResult.CONTINUE;//продолжааем работать
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {//срабатывает когда файл по каким-то причинам не доступен
        System.out.println("Error на файле " + file.getFileName());
        return FileVisitResult.CONTINUE;//прекращаем работу
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {//срабатывает после обращения к элементам
        System.out.println("Выходим из директории " + dir);
        return FileVisitResult.CONTINUE;//продолжааем работать
    }

    //после вызова и окончания работы каждого метода мы должны сказать что мы будет делать дальше, для этого используем
    //enum FileVisitResult а именно такие значения
    //CONTINUE - означает что нужно продолжать обход по файлам
    //TERMINATE - означает что нужно немедленно прекратить обход
    //SKIP_SUBTREE - означает что в данную директорию заходить не надо
    //SKIP_SIBLINGS - означает что в данной директории продолжать обход по файлам не нужно
}