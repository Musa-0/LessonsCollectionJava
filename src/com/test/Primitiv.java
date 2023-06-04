package com.test;

public class Primitiv {
    public static void main(String[] args) {
    int a = 123;
    long l = 4423423L;
    l = a; //ошибки не будет так как loag точно содержит в себе все числа int
    //a=l; // неявно сделать такое нельзя так как в ljng может быть число больше чем может содержать int
    a = (int)l;//но мы можем сделать это явно указав int тогда можно
    //    так же и с float b double
    byte b = (byte)129;//в таком случае byte начнет отсчет с начала [-128:127] а тут 129 след b=-127 отсчет пойдет по кругу
    int d = (int)'k';
    }}
