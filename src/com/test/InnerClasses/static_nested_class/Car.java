package com.test.InnerClasses.static_nested_class;
//пример статического внутреннего класса

class Test{
    public static void main(String[] args) {
        Car.Engine engine = new Car.Engine(256);//таким образом, мы можем обратиться к статическому внутренему классу
        //мы можем использовать Engine как отдельный класс, смысл статик класса в том, чтобы указать пренадлежность к Car
        //мы можем создавать мотор, лишь через класс Car а не через его объекты, так как это статический класс а статика работает с классами а не объектами
        Car car = new Car("red",4,engine);//мы собрали машину, красного цвета, с 4 дверьми, и положили мотор мощностью 256
    }
}

public class Car {

    String color;           //цвет
    int doorCount;          //колличество дверей
    Engine engine;          //мотор
    static String model = "BMW";    //Модель машины


    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }


    public static class Engine{//вот наш внутренний статичный класс
        int hoursePower;//лошадиная сила

        static int countEngine;//колличество созданных моторов

        public Engine(int hoursePower) {
            countEngine++;
            System.out.println("Создан двигатель для модели " + model);//статические внутрение классы могут
                                         // обращаться к внешним переменым и методам, но лишь к статическим
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
