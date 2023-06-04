package com.test.ExeptionsEx;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//ВСЕ КЛАССЫ ИСКЛЮЧЕНИЙ НАСЛЕДУЮТСЯ ОТ КЛАССА Exception
public class Exeptions {
    public static void main(String[] args) throws FileNotFoundException {//1 метод: тут мы говорим джаве что в этом методе может выскочить вот твкое исключение.

        File file = new File("die");//укажем не существующий файл
        except_try(file);//вызовим функцию первого метода исключение и передадим объект File
        Scanner sc = new Scanner(file);// случае если нету файла необходимо исключение говорящее о том чт файла нет
        try {//если функция read выдаст исключение то оно будет обработано тут
            read();
        }
        catch (FileNotFoundException e){
            System.out.println("lololololo");
        }

        }
        //тут нам нужно исключение FileNotFoundException и его объект выбрасывается в том случае если произошла ошибка
        //есть два способа создать исключеие 1 указывая его в нашей функции с помощью throw. а 2 это с помощью try catch


    public static void except_try(File file){
        //2 метод:
        try {
            Scanner sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);//выбрасывает исключение
            System.out.println("ohohohoh ohohoh hohohoh ohohoh");
        }
    }
    //если мы хотим вызвать исключение с помощью throw в не главном методе main то тогда throw надо указать и в том методе и в том где его вызывают и везде по иеррархии вверх
    public static void read() throws FileNotFoundException {//необходимо указать исключение throw и тут и в методе main
        File file = new File("die");//укажем не существующий файл
        Scanner sc = new Scanner(file);
    }
}
