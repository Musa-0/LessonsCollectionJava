package com.test;

import java.io.File;
import java.io.FileNotFoundException;//подключаем исключение на случай если такого файла не будет в системе
import java.util.Arrays;
import java.util.Scanner;

public class FileRead {
    public static void main(String[] args) throws FileNotFoundException {//подключаем исключение на случай если такого файла не будет в системе
        //String separator = File.separator;//в виндовсе разделитель между папками "\" а в МАС и Линуксе так "/" чтобы прога работала и там и там используем seporator который сам узнает какой надо брать
        // это в случае если файл лежит вне проекта - String path = "C:" + separator + "Users" +separator+"1" +separator+ "IdeaProjects" +separator+ "Test2" +separator+ "src" +separator+"com" +separator+ "test" +separator+ "musa";
        //File file = new File(path);//объект для того чтобы переместить данные нашего файла в наш код
        File file = new File("src/com/test/musa");//а можно и так указать путь если файл лежит в проекте
        Scanner scanner = new Scanner(file);//наш сканер принимает не ввод из клавиатуры а данные из файла
//        while(scanner.hasNextLine()){//если есть ещё строки то true
//            System.out.println(scanner.nextLine());
//
//        }
        String line = scanner.nextLine();//берём первую стоку
        String[] number = line.split(" ");//разделяем цифры по пробелам
        int[] num = new int[3];//массив из стрёх чисел
        int count = 0;
        for(String n : number ){
            num[count++] = Integer.parseInt(n);// делаем все строковые числа в тип int
        }
        System.out.println(Arrays.toString(num));//выводит массив

        scanner.close();//закрывает наш сканер чтобы поток не оставался открытым
    }
}
