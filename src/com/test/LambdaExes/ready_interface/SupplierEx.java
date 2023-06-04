package com.test.LambdaExes.ready_interface;
// Supplier это поставщик который не принимает параметры а лишь возвращает объект типа T, и имеет лишь одну функцию
//              T get();

import java.util.ArrayList;
import java.util.function.Supplier;

public class SupplierEx
{
//напишем метод принимающий список, в который будет класть 3 машины, а какие именно машины, мы пропишем в Lambda выражении

    public static ArrayList<Car> createCar(Supplier<Car> carSupplier){
        ArrayList<Car> al = new ArrayList<>();
        for (int i = 0; i<3; i++){
            al.add(carSupplier.get());//а что будет делать этот метод? мы напишем в Lambda выражении
        }
        return al;
    }

    public static void main(String[] args) {
        ArrayList<Car> cars = createCar(() -> new Car("Nisan","red",1.6));//и так мы вызвали метод,
        System.out.println(cars);       // в который передали машину которую хотим создать. и наш метод создаст 3 таких машин
    }

}



class Car{
    String model;
    String color;
    double engine;

    public Car(String model, String color, double engine) {
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
