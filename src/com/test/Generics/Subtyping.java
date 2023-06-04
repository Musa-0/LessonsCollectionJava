package com.test.Generics;

import java.util.ArrayList;
import java.util.List;


public class Subtyping {

    public static void main(String[] args) {
        X x = new Y();//тут это сработает, так как Y Содержит в себе X



//        List<X> list1 = new ArrayList<Y>();//но тут уже не сраотает, так как List<X> и ArrayList<Y> это считается разными объектами
//        А нельзя потому, что если от класса Х будет зависеть ещё один класс например Z, то при вложении этого класса
//        в массив AyyarList<Y> не будет знать что это так как Y не связан с Z, но при этом Z наследник X. вот вам и причина
//        тупо будет ошибка

        Test test1 = new Test(1);//тут мы можем указывать лишь числовые значения, наследущиеся от Number
        Test<Double> test2 = new Test<>(3.4);//например double
        Test test3 = new Test((byte)19);//или byte
        System.out.println(test1.value);
        System.out.println(test2.value);
        System.out.println(test3.value);
    }

}
class X{ }
class Y extends X{ }
class Z extends X { }

//Subtyping  мы можем указать от какого класса должен наследоватсья объект премезированого класса см. ParameterizedClassEx.java
//например:
class Test<T extends Number>{//теперь, тут мы можем лишь вставлять любой тип данных наследованный от класса Number, другими словами лишь числовые значения, int double итд
    //кстати, после Type Erasure см Type_Erasure все T заменятся не на Object а на Number, так как если все типы которые тут могут быть
    //наследуются от Number то это значит что Number будет самым минимальным наследником всех объектов этого класса
    public T value;
    public Test(T value){
        this.value = value;
    }
    //так же и для методов
    class LOL{
        public <T extends Number&I1&I2> T testlol(ArrayList<T> l1){//теперь сюда мы можем передавать
            // лишь массивы с элементами наследующие Number, и имплиментит интерефейсы I1 и I2
            return l1.get(0);
        }
    }
}
interface I1{

}
interface I2{

}

