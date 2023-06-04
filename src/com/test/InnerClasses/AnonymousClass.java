package com.test.InnerClasses;
//анонимные классы не имеют имени
public class AnonymousClass {

    public static void main(String[] args) {

        Math m = new Math() {//мы с помощью интерфейса создали объект класса, который нам нужен всего один раз, анонимный класс
            int pis = 2;
            int delit2(int res){//мы не можем использовать это вне класса как бы не хотели даже если public
                return res/pis;
            }
            @Override
            public int doOperation(int a, int b) {//оверрайдим метод который должен быть в этом классе, по интерфейсу
                return delit2(a+b);
            }
        };
        System.out.println(m.doOperation(3,2));



        Math m2 = new Math() {//можно таких создать сколько угодно, и каждый будет делать свой метод doOperation
            @Override
            public int doOperation(int a, int b) {
                return a-b;
            }
        };
        System.out.println(m2.doOperation(1,3));

        LOL lol = new LOL(){//тоже самое можно делать и с помощью других классов а не интерфейсов
            @Override
            public void printany(){
                System.out.println("YYEEEEEEEES");
            }
        };
        lol.printany();

    }

}
class LOL{
    public void printany(){
        System.out.println("LOOOOOOOOOOOOOL");
    }
}
interface Math{
    int doOperation(int a, int b);//какая либо операция с двумя переменными
}