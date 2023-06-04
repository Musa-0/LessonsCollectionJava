package com.test.InnerClasses;

public class Static_Nested_Class {

    static class A{}        //статический внутрений класс Nested Static Class

    class B{}               //внутрений класс Iner Class

    void method(){
        class C{}           //локальный класс тоже самое что и inner class но видит его лишь метод в котором он лежит
    }                       //и при этом обращаться может к данным из блока функции в которой лежит. но если они
                            // final или effective final то есть не меняется. так же не имеет стетических полей


    //анонимный класс

}
