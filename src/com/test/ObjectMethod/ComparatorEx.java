package com.test.ObjectMethod;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//компараторы нужны для сравнения двух объктов по каким либо методам, мы можем сделать много компараторов, для сравнения
//объектов по разным полям, в зависимости от того как нам надо, он словно на время перезаписывает метод compareTo в классе
public class ComparatorEx {
    public static void main(String[] args) {

        List<People> list = new ArrayList<>();

        People p1 = new People(1, "Zaur");
        People p2 = new People(3, "Amina");
        People p3 = new People(2, "Musa");

        list.add(p1);list.add(p2);list.add(p3);

        Collections.sort(list, new IdComparator());//отсортирует по id
        System.out.println(list);

        Collections.sort(list, new NameComparator());//отсортирует по name
        System.out.println(list);




    }
}

class IdComparator implements Comparator<People> {
    @Override
    public int compare(People p1, People p2) {//этот метод нужен для того, чтобы создавать саму начинку компаратора,
        // не привязывая её к классу. чтобы мы могла сравнивать по разным полям класса
        return p1.id-p2.id;
    }
}
class NameComparator implements Comparator<People> {
    @Override
    public int compare(People p1, People p2) {
        return p1.name.compareTo(p2.name);//сравниваем по имени человека
    }
}


class People{

    int id;
    String name;

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public People(int id, String name) {
        this.id = id;
        this.name = name;
    }
}