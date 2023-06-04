package com.test.LambdaExes.ready_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// интерфейс Function примимает один параметр, а и возвращает что-то
public class FunctionEx {
    public static void main(String[] args) {
        Student st1 = new Student("Musa",'m',17,2,5.3);//берем класс студентов из PredicateEx
        Student st2 = new Student("Hava",'w',18,4,6.2);
        Student st3 = new Student("Amina",'w',19,3,4.1);
        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);

        Function<Student, Double> f = student -> student.mark;
        double res = avgOfMark(students, st -> st.mark);//пишем что наш метод должен будет вычислять среднее арифметическое именно отметок
    }
    private static double avgOfMark(List<Student> list, Function<Student,Double> f){//метод вычисляющий среднее арифметическое

        double result = 0;// переменная конечного результата

        for (Student st: list){
            result+=f.apply(st);//от чего именно мы будем вычислять среднее арифметическое
        }
        result = result/list.size();
        return result;

    }

}
