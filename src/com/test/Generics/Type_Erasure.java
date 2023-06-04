package com.test.Generics;
//увы, generic появились недавно. и компилятор их распознает, а вот джава машина нет. поэтому, для неё
//и после процесса Type erasure все джинерики приобразуются в преведение типов
// такая запись
//         ArrayList<String> arr = new ArrayList<>();
//         arr.add("lol");
//         String a = arr.get(0)

// после Type erasure выглядит так
//         ArrayList arr = new ArrayList<>();
//         arr.add("lol");
//         String a = (String)arr.get(0);

import java.util.ArrayList;

//public class Type_Erasure {
//
//    public void abc(Example<Integer> ex){//и тут для jvm это выглядит как два одинаковых метода, ибо generic просто исчезает
//
//    }
//    public void abc(Example<String> ex){//и соответсвенно возникает ошибка, ты разкоменть код и поймешь)
//
//    }
////та же проблема возникает и при попытки Overriding ибо это тебе не перегрузка, чтобы просто типы менять
//}
//class Example<T>{
//    private T value;
//
//    public void getvalue(){
//        System.out.println(value);
//    }

//}
