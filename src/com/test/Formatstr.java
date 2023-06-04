package com.test;

import java.security.SecureRandom;
import java.util.regex.Pattern;

public class Formatstr {

    public static void main(String[] args) {
        String a = String.format("time %s %7d %f", "ggg", 4435, 94.0f);//%s - str %f - float %d -int  %5d - означает длину этой подстроки не в зависимости от длины числа
        System.out.println(a);//printf - выводит строку форатируя её

        String i = "q-,";
        int index_tire = i.indexOf("-");
        String letter = Character.toString(i.charAt(index_tire-1));
        System.out.println(letter);

        if(i.valueOf(index_tire-1).compareTo("a")<=0 || i.valueOf(index_tire+1).compareTo("a")<=0){
            System.out.println("lol");
        }

        }
    }
