package com.test;

import java.io.*;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        File file = new File("src/com/test/musa");//указываем путь к нашему файлу
        PrintWriter pw = new PrintWriter(file);//класс который может перезаписывать данные в файл
        PrintWriter pws = new PrintWriter(new FileWriter(file, true));//будет дописывать данные в файл а не перезаписывать
        pw.println("Test File");//записываем одну строку в файл
        pws.println("Test File2");

        pw.close();//закрываем файл
        pws.close();

        //2 способ
        File file1 = new File("text.txt");//создаём файл
        FileWriter writer = new FileWriter(file1);
        writer.write("lol lol lol looool l ol lo llo llo llo ool lo llo");//записываем что-то
        writer.close();
    }
}
