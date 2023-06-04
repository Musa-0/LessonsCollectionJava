package com.test.InnerClasses.inner_class;
// Разбор Внутреннего класса
//внутренний класс н еможет содержать статических переменных. только если она не константа
//но можем обращаться к любым переменным внешнего класса
class Test{
    public static void main(String[] args) {

        Car car = new Car("black", 2);//создали машину черного цвета, 2 двери
        car.createEngine(150);//создадим мотор с мощностью 150
        Car.Engine engine = car.new Engine(234);//чтобы создать двигатель нужен обязательно оъект Car
        car.setEngine(engine);//положим в нашу машину новый двигатель
        engine.hoursePower = 345;//мы можем прям от сюда изменить мощность двигателя, и она применится в объекте
        System.out.println(car.engine);


    }
}

public class Car {
    String color;           //цвет
    int doorCount;          //колличество дверей
    public Engine engine;          //мотор

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Car(String color, int doorCount) {
        this.color = color;
        this.doorCount = doorCount;
    }

    public void createEngine(int hoursePower){
        this.engine = new Engine(hoursePower);//создаем мотор, внутри класса Машины, мотор не может существовать без машины
    }

    public class Engine{//вот наш внутренний  класс
        int hoursePower;//лошадиная сила


        public Engine(int hoursePower) {
            this.hoursePower = hoursePower;
        }

        @Override
        public String toString() {
            return "Engine{" + "HoursePower=" + hoursePower + '}';
        }
    }


    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }


}