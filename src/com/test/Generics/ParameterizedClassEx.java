package com.test.Generics;
//преметезированые классы это классы в которых можно заменять тип значений как templatename
public class ParameterizedClassEx {

    public static void main(String[] args) {
        Info<String> info = new Info<>("privet");//просто подствили тип String
        System.out.println(info);
        Info<Integer> info2 = new Info<>(1);//просто подствили тип Integer
        System.out.println(info2);
        Info<Boolean> info3 = new Info<>(false);//просто подствили тип Boolean
        System.out.println(info3);

        Info1<Integer, String> info1 = new Info1<>(1,"LOOOL");//тут мы можем вставить два разных объекта
        System.out.println(info1);

        System.out.println(info.getValue());
    }

}





class Info<T>{//наш класс теперь, не имеет определеной привязки к типу объекта.  и мы можем использовать любой тип
    private T value;
    public T getValue(){//это наш метод который принимает элемент типа T,
// и тут в отличии от метода в классе из ParameterizedMethod не нужно указывать generic <T> ибо он уже указан в начале класса
        return value;
    }
    public Info(T value){
        this.value = value;
    }
    public String toString(){
        return "{" + this.value + "}";
    }

}
class Info1<In, St>{//наш класс теперь имеет 2 типа объекта
    private In valuein;
    private St valuest;
    public Info1(In valuein, St valuest){
        this.valuein = valuein;
        this.valuest = valuest;
    }
    public String toString(){
        return "{" + this.valuein + " " + this.valuest + "}";
    }

}
