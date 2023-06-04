package com.test.work_with_file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;//java.io это все классы input и output

//RandomAccessFile позволяет читать информацию из любого места файла и записывать информацию в любое место файла
//это добивается путем использования Pointer - курсор. который мы можем передвигать на разное количество байт
public class RandomAccessFileEx {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile(
                "src/com/test/work_with_file/files/randomAccess.txt","rw"))//пишем файл. и режим чтение и запись
        {
        int a = file.read();//читаем первый элемент
            System.out.println((char)a);//конвертируя его в char

        file.seek(51);//перемещаем курсор чтения или записи на 50-ый байт и уже из него продолжится чтение данных из файла

        String s1 = new String(
                file.readLine().getBytes("ISO-8859-1"), "UTF-8");//.getBytes("ISO-8859-1") -
        // использует кодовую страницы для перевода на любой язык, использую utf-8
        System.out.println(s1);//выведем 1 строку

        file.seek(0);//переместимся в самое начало
            file.writeBytes("Hello ");   //и напишем Hello ибо хз как русские писать

        file.seek(file.length()-1);//переходим на последний байт. -1 так как отсчет с 0
            file.writeBytes("\n\t\t\t\t\tRobert Gring");

        long position = file.getFilePointer();//узнаем текущую позицию курсора. на каком байте мы сейчас
            System.out.println(position);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
