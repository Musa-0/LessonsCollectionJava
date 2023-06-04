package com.test.work_with_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// FileInputStream и FileOutputStream - нужны для работы с бинарными файлами. просто поток байт информации это может
//быть музыка видео итд.
//ТУТ МОЖНО ТАК ЖЕ ИСПОЛЬЗОВАТЬ BUFFER БУФЕРИЗАЦИЮ. ВСЕ ТАК ЖЕ КАК И ДЛЯ ReadFile смотри файл Bufferesed
public class FileInput_FileOutput_Stream {//создадим копироание картинки из одного файла в другой
    public static void main(String[] args) {
        try(FileInputStream inputStream = new FileInputStream(//берем файл который мы будем копировать в другой
                "src/com/test/work_with_file/files/binary/javaPing.webp");
            FileOutputStream outputStream = new FileOutputStream(//создаем файл в который скопируем инфу из первого файла
                    "src/com/test/work_with_file/files/binary/copyJavaPing.webp"))
        {
            int i;
            while ((i=inputStream.read()) != -1){//последний байт это -1. пока он не равен последнему байту - читаем
                outputStream.write(i);//записываем во второй файл данные что читаем из первого
            }
            System.out.println("done");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
