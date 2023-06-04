package com.test.work_with_file.path_and_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Path - интерфейс для работы с путями к файлам, объект типа Path это путь к файлу или папке, её может и не быть,
// он работает с path строкой

public class Path_Files1 {
    public static void main(String[] args) throws IOException {

        Path filepath = Paths.get("testfilePath_Files.txt");//возьмем путь какого-то файла, которого мб даже и нет
        Path directorypath = Paths.get("src/com/test/work_with_file/files/testdirectoryPath_Files");//возьмем путь какой-то папки, которого мб даже и нет

        System.out.println("getFileName() = " + filepath.getFileName());//выведет само имя файла или директории
        System.out.println("getFileName() = " + directorypath.getFileName());//выведет само имя файла или директории
        System.out.println("--------------------------------------");

        System.out.println("getParent() = " + filepath.getParent());//выведем родительскую директорию для этого файл,
        // так как в пути мы указали лишь имя файла то и каталог родителя будет null
        System.out.println("getParent() = " + directorypath.getParent());//выведем родительскую директорию для этой папки
        System.out.println("--------------------------------------");

        System.out.println("getRoot() = " + filepath.getRoot());//берем рут директорию, но так как мы не указали путь,
        // а лишь имя файла то и рута папки не будет
        System.out.println("getRoot() = " + directorypath.getRoot());//берем рут директорию
        System.out.println("--------------------------------------");

        System.out.println("isAbsolute() = " + filepath.isAbsolute());//укажет абсолютный ли путь
        System.out.println("isAbsolute() = " + directorypath.isAbsolute());//укажет абсолютный ли путь
        System.out.println("--------------------------------------");

        System.out.println("toAbsolutePath() = " + filepath.toAbsolutePath().getParent());//укажет абсолютный путь
        // к возможному файлу, по нашей файловой системе, и из него возьмем каталог родителя
        System.out.println("toAbsolutePath() = " + directorypath.toAbsolutePath());//укажет абсолютный путь к возможной
        // папке, по нашей файловой системе
        System.out.println("--------------------------------------");

        System.out.println("directorypath.resolve(filepath) = " + directorypath.resolve(filepath));//получим путь, файла
        // filepath, лежащего в этой директории directorypath
        System.out.println("directorypath.resolve(filepath) = " + directorypath.relativize(filepath));// получим
        // относительный путь, который начинается от directorypath и заканчивается filepath. это если filepath уже имеет путь
        System.out.println("--------------------------------------");

        if(!Files.exists(filepath)){//првоеряем существует ли этот файл?
            Files.createFile(filepath);//если нет то создаем его
        }

        if(!Files.exists(directorypath)){//првоеряем существует ли этот каталог?
            Files.createDirectory(directorypath);//если нет то создаем его
        }

        System.out.println(Files.isReadable(filepath));//проверка имеем ли мы права на чтение
        System.out.println(Files.isWritable(filepath));//проверка имеем ли мы права на запись
        System.out.println(Files.isExecutable(filepath));//проверка имеем ли мы права на запуск

       // Files.isSameFile(file1,file2) - проверяет являются ли два пути путями на один и тот же файл
        System.out.println(Files.size(filepath));//выведет размер файла  в байтах

        //Files.getAttribute(filepath,"имя атрибута") можем посмотреть данные по атрибуту, загигли их

    }
}
