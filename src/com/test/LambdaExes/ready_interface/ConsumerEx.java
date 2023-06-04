package com.test.LambdaExes.ready_interface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//Consumer лишь потребляет элементы, и ничего не возвращает
//                  void accept(T t); он нужен скорее для изменения чего-либо
public class ConsumerEx {

    public static void changeCar(SportCar car, Consumer<SportCar> carConsumer){
        carConsumer.accept(car);//что именно будет делать accept с нашей машиной, мы пропишем в Lambda
    }

    public static void main(String[] args) {
        ArrayList<SportCar> sporcars = new ArrayList<>();
        sporcars.add(new SportCar("nisan","blue",1.5));
        sporcars.add(new SportCar("nisan","blue",1.5));
        sporcars.add(new SportCar("nisan","blue",1.5));

        changeCar(sporcars.get(0),car -> {//тут мы вызовем наш метод и опишем то что мы будет делать с объектом который передаем в него
            car.color = "red";//изменим параметры первой машины
            car.engine = 3.6;
        });
        System.out.println(sporcars.get(0));


        //так же можем использовать консьюмер в ForEach
        List<Integer> list1 = List.of(1,2,3,4,5);
        list1.forEach(i -> System.out.println(i));//он будет проходиться по каждому элементу списка и выводить его
    }
}


class SportCar{
    String model;
    String color;
    double engine;

    public SportCar(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }
}