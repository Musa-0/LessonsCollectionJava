package com.test.ObjectMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//Comparable это интерейс который определяет, по каким полям будут сравниваться объекты класса
public class ComparableEx {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Musa");
        list.add("Hava");
        list.add("Amina");
        Collections.sort(list);//в данном случае список будет сортироваться по алфавиту.
        // так как в String уже прописан метод расспределения какой класс больше а какой нет
        System.out.println(list);

        //А что если это объекты нашего личного класса?
        Employee emp1 = new Employee(100,"Musa", "Haniev",12345);
        Employee emp2 = new Employee(101,"Hava", "Haniev",13324);
        Employee emp3 = new Employee(102,"Amina", "Haniev",13425);


        List<Employee> list_emp = new ArrayList<>(Arrays.asList(emp1, emp2, emp3));

        Collections.sort(list_emp);//и тут, будет идти сортировка по compareTo в нашем классе
        System.out.println(list_emp);


    }
}

class Employee implements Comparable<Employee>{//тут мы говорим о том, что данный класс получает интерфейс\
    // на способность сравнвать свои объекты друг с другом
    int id;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee anotherEmp) {//с помощью этого метода мы будем сравнивать два объекта
        //правила сравнения - если объект который не в скобках, больше того с которым сравниваем, то возвращаеся положительное число
        //если объект с которым сравниваем больше, то возвращаем отрицательный, если равны то возвращаем 0

        return this.id-anotherEmp.id;
        //return this.name.compareTo(anotherEmp.name); или можно по имени их сравнивать вызывая compareTo у класса String

    }
}
