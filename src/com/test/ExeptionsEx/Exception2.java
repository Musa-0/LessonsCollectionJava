package com.test.ExeptionsEx;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception2 {
    public static void main(String[] args) {//возможно исключение IOException5
        //НАУЧИМСЯ ВЫБРАСЫВАТЬ ИСКЛЮЧЕНИЯ
        Scanner sc = new Scanner(System.in);
        try {
        int a = sc.nextInt();
        if (a<0){
            throw new MyException("LOLOLO");//если число менше 0 то тогда мы выбрасываем Наше исключение
        }
        }
        catch (MyException e){//исключение на случай если отрицательное число
            System.out.println("MyException");
        }
        catch (InputMismatchException | NumberFormatException n){//исключение на случай если ввели не число два исключение возможны
            System.out.println("Number format");
        }
        catch (Exception e){//на случай любой ошибки. это исключение надо ставить в конце так как оно обработает любое исключение и если поставить вверх то другие исключения под ним тупо не выполнятся
            System.out.println("i dont know");
        }

    }
}
