package com.test.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
//HashMap это массив LinkedList-ов каждый из которых содержит пары ключ-значений
public class HashMapEx {
    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>(16,0.75f);//эти два аргумента важныыыы первый говорит о размере массива
        //  на основе которого и строится словарь второй элемент увеличивает размер массива в двое тогда когда он дошел до размера
        // (размер который мы задали в первом аргументе)*(второй аргумент). 16*0.75=12 когд абудет 12 элементов словарь увеличится в двое
        // и чем больше размер словаря мы укажем тем меньше операций увеличения массива будет но больше памяти затратиться. 0.75 считается золотой серединой
        //чем больше элементов этого массива тем больше LinkedList и тем быстрее происходит поиск по этим LinkedList так как скорость поиска LinkedList О(n) так как они работают как списки
        Student st1 = new Student(1,"Musa", "Haniev", 1);
        Student st2 = new Student(2,"Hava", "Hanieva", 3);
        map.put(st1, 3.4);
        map.put(st2, 4.9);
        Student st3 = new Student(3,"Musa", "Haniev", 1);//сделаем копию 1 студента
        System.out.println(map.containsKey(st3));
        for(Map.Entry<Student,Double> entry : map.entrySet()){//entry возвращает и Node то есть и ключ и значение и хэшкод и ссылку на след объект
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
class Student implements Comparable<Student>{
    final Integer id;//id будет не изменяемым так как по нему будет строиться hashcode
    String name;
    String surname;
    int course;

    public Student(int id,String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }
    //неглассное правило если hashcode у двух объектов равный то и equals должен быть равным
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }
    //хэш каждого объекта который будет теперь создаваться на основе имени фамиии и курса
//используется в HashMap and SetHash
    @Override
    public int hashCode() {
        return Objects.hash(id);//хэш код будет делаться на основе айди который будет не изменяем.
        // и если айди у двух объектов одинаковы то эти объекты это одна сущность
    }

    @Override
    public int compareTo(Student o) {//для сравнения объектов
        return this.id.compareTo(o.id);}//будем сравнивать id

}

//    void clear()
//    Удаляет все соответствия с этого Map.
//        2	Object clone()
//        Возвращает мелкую копию этого экземпляра HashMap: сами ключи и значения не клонируются.
//        3	boolean containsKey(Object key)
//        Возвращает true, если этот Map содержит отображение для указанного ключа.
//        4	boolean containsValue(Object value)
//        Возвращает true, если этот Map отображает одну или несколько клавиш в указанное значение.
//        5	Set entrySet() - Set set = HashMapObjectMusa.entrySet();
//        Возвращает set коллекции отображений, содержащихся в этом Map.
//        6	Object get(Object key)
//        Возвращает значение, для которого указанный ключ отображается в этой хэш-карте идентификатора, или null (нуль), если Map не содержит отображения для этого ключа.
//        7	boolean isEmpty()
//        Возвращает true, если этот Map не содержит отображений значений ключа.
//        8	Set keySet()
//        Возвращает заданное set ключей, содержащихся на этом Map.
//          8.1 values() - возвращает коллекцию значений из словаря

//        9	Object put(Object key, Object value)
//        Связывает указанное значение с указанным ключом на этом Map.
//        10	putAll(Map m)
//        Копирует все отображения с указанного Map на этот Map. Эти отображения заменят любые отображения, которые это отображение имело для любого из ключей, находящихся в настоящее время на указанном Map.
//        11	Object remove(Object key)
//        Удаляет отображение для этого ключа с этого Map, если присутствует.
//        12	int size()
//        Возвращает количество ключ-значение отображений на этом Map.
//        13	Collection values()
//        Возвращает представление (вид) коллекции значений, содержащихся на этой карте.