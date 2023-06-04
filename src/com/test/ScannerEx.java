package com.test;

import java.util.Scanner;

public class ScannerEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//класс ввода, где ввод делается из стандартной клавиатуры
        System.out.println("Введите что-то");
        String str = sc.nextLine();
        System.out.println(str);
    }
}
