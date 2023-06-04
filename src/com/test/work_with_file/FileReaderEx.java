package com.test.work_with_file;

import com.test.FileRead;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) throws IOException {
        FileReader reader = null;
        try {
            reader = new FileReader("src/com/test/work_with_file/files/fileWrtiterTest1.txt");//берет файл который будет читать
            int character;//переменная для посимвольного чтения символов, в типе int по unicode
            while ((character=reader.read()) != -1){//любой файл читается по их числам в unicode и в конце файла
                // всегда находится -1. если наша переменная по посимвольному чтению равна -1 значит мы прочли все
                System.out.print((char)character);//выводим считаный символ в формате int и переводим в тип char
            }
            System.out.println("\ndone");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            reader.close();//в конце закрываем
        }
    }
}
//String separator = File.separator;//в виндовсе разделитель между папками "\" а в МАС и Линуксе так "/" чтобы прога работала и там и там используем seporator который сам узнает какой надо брать
// это в случае если файл лежит вне проекта - String path = "src" + separator + "com" +separator+"test" +separator+ "work_with_file" +separator+ "files" +separator+ "fileWrtiterTest1.txt";