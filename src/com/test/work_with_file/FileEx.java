package com.test.work_with_file;

import java.io.File;
import java.util.Arrays;

//Класс File позволяет управлять информацией о файлах и директориях. File отвечает и за файлы и за дирекктории
//File работает с самим файлом, а не его содержимым
public class FileEx {
    public static void main(String[] args) {

        //в File можно вбить не существующую директориб или файл

        File file = new File("/home/sid/IdeaProjects/Test2/src/com/test/work_with_file/files/file1.txt");//берем наш файл
        File folder = new File("src/com/test/work_with_file/files/test_directory");//берем директорию
        File existingdirectory = new File("src/com/test/work_with_file/files/test_directory/directory_exist/");//возьмем не существующий файл


        System.out.println("Абсолютный путь file - " + file.getAbsolutePath());//выведет полный путь к файлу
        System.out.println("Абсолюный путь folder - " + folder.getAbsolutePath());//выведет полный путь к директории

        System.out.println("-----------------------------------------------");

        System.out.println("Указан абсолютный путь? file - " + file.isAbsolute());//проверяет, полный ли путь к файлу дан
        System.out.println("Указан абсолютный путь? folder - " + folder.isAbsolute());//проверяет, полный ли путь к папке дан

        System.out.println("-----------------------------------------------");

        System.out.println("Это директория? file - " + file.isDirectory());//проверяет, директория ли это
        System.out.println("Это директория? folder - " + folder.isDirectory());//проверяет, директория ли это

        System.out.println("-----------------------------------------------");

        System.out.println("Этот file существует? - " + file.exists());//проверяет, существует ли файл или папка
        System.out.println("Этот folder существует? - " + folder.exists());//проверяет, существует ли файл или папка
        System.out.println("Этот existingfile существует? - " + existingdirectory.exists());//проверяет, существует ли файл или папка

        System.out.println("-----------------------------------------------");

        System.out.println("создалась ли папка existingdirectory " + existingdirectory.mkdir());//создаст такой каталог вернет True если такого файла не было и теперь он создался

        System.out.println("Размер file - " + file.length());//возвращает размер файла
        //для папки так нельзя. надо сложить все файлы что внутри неё и тогда узнаешь

        System.out.println("-----------------------------------------------");

        existingdirectory.delete();//удаляет файл или директорию только если она пуста

        File[] list_files = folder.listFiles();//присвоит все файлы и директории этой директории
        System.out.println(Arrays.toString(list_files));//выведем их. но так как там ничего нет вернет пустой список

        System.out.println(file.isHidden());//скрыт ли файл или папка
        System.out.println(file.canExecute());//можем ли мы запускать файл
        System.out.println(file.canRead());//можем ли мы читать файл
        System.out.println(file.canWrite());//можем ли мы записывать в файл
    }
}
