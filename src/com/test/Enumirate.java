package com.test;

public enum Enumirate {//enum  это набор именованных констант, который помогает в определении своих собственных типов данных
    DOG("собака"),CAT("кошка"),FROG("лягушка");//это не строки это объекты Enum которые передают аргумент перевода
    //это равно такой записи - Enumirate DOG = new DOG("собака")

    private String translate;
    Enumirate(String translate){//конструктор для перевода названия животного
        this.translate = translate;
    }
    Enumirate(){}
    public String getTranslate(){
        return translate;
    }
}

class Animals {
    public static void main(String[] args) {


        Enumirate animal = Enumirate.CAT;//туут мы теперь не можем поместить что-то чего нет в нашем enum все значения мы берём из нашего enun которых хранит наши константы
        switch (animal){
            case DOG:
                System.out.println(animal.getTranslate());
                break;
           case CAT:
                System.out.println(animal.getTranslate());
                break;
            case FROG:
                System.out.println(animal.getTranslate());
                break;
        }
        Enumirate test = Enumirate.valueOf("FROG");//преобразует из строки в имя констант и пользователь может вводить имена животных
        System.out.println(test.name());//выводит имя константы

        //этот способ был до enum, минусы его в том что тут есть не определённость animal может содержать любое число и мы не будем понимать какому животному оно будет соответствовать. да и тип может быть лишь один
//        private static final int DOG = 0;
//        private static final int CAT = 1;
//        private static final int FROG = 2;
//        int animal = DOG;
//
//        switch (animal){
//            case DOG:
//                System.out.println("Dog");
//                break;
//            case CAT:
//                System.out.println("Cat");
//                break;
//            case FROG:
//                System.out.println("Frog");
//                break;
//            default:
//                System.out.println("its not animal");
//        }

    }
}