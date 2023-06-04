package com.test.annotationEx;
//Аннотации - это специальные метки, методанные. Которые нужны для передачи определенной информации
public class Test1 {
    public static void main(String[] args) {
        Parents parents = new Child("Musa");
        parents.showInfo();
    }
}


class Parents{
    String name;

    Parents(String name){
        this.name = name;
    }
    @Deprecated // говорит о том что метод устарел
    void showInfo(){
        System.out.println("Имя родителя " + this.name);
    }
}

class Child extends Parents{
    public Child(String name){
        super(name);
    }

    @Override       // эта аннотация отвечает за то, является ли данный метод переопределенным или нет. порой мы можем
    //ошибиться в названии метода, или его параметрах, и тогда это будет не переопределенный метод, а просто метод,
    //а Override следит за тем чтобы мы точно знали, переопределен ли метод, или нет
    void showInfo(){
        System.out.println("Имя ребенка " + name);
    }

}