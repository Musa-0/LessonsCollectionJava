package com.test.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx {
    //Stream делает из передаваемой коллекции или массива поток данных
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("worid");
        list.add("totees");


        //сделаем так что мы хотим изменить слова в коллекции на их рамер
        List<Integer> list2 = list.stream().map(element->element.length()).collect(Collectors.toList());//здесь мы с помощью stream сделали поток, метод map делает какие-либо операции
        // с каждым элементом этого потока с помощью lambda выражений где element это элемент потока, и в итoге мы получаем поток int чисел размеров слов
        // и далее преобразуем его в список с помощью collect(Collectors.toList()) и передаем этот список нашему новому списку. вообще мы можем этот поток преобразовать в любую коллекцию
        System.out.println(list2);
        //пример с массивом
        int[] array = {1,2,3,4,5};


        array = Arrays.stream(array).map(element -> {//если элемент потока делится на цело на 3 то делим это число на три
        if(element%3==0)
            element/=3;
        return element;
        }).toArray();//т в конце преобразовываем поток в массив
        System.out.println(Arrays.toString(array));


        //filter - фильтрует элементы потока
        Set<Integer> set = list2.stream().filter(element->{return element>3;}).collect(Collectors.toSet());//отфильтруем наш поток из списка и все числа
        // меньше 3 не войдут в него, а после преобразуем поток во множество
        System.out.println(set);



        //forEach - ничего не возвращает, он анужна для вывода чего-либо
        Arrays.stream(array).forEach(el->{el*=2;//выведит элементы увеличенные в двое
            System.out.println(el);});



        //reduce - из всего стрима он возвращает одно значение. агригатная функция, например сумма всех чисел потока
        int result = list2.stream().reduce((sum, el)->sum+el).get();//в данном слечае вернем первый параметр sum с помощью get()

        //sorted делает сортировку
        int[] arry = {4,3,6,8,7,46,7,5};
        Arrays.stream(arry).sorted().toArray();//тут он просто вернет отсортированые мыссив
        System.out.println(Arrays.toString(arry));
        //но если у нас объекты которые надо отсортировать по своему

        String[] arrstr = {"мол", "ну", "шабатон"};
        List<String> liststr = Arrays.stream(arrstr).sorted((x,y) -> x.length()-y.length()).toList();//тут мы прописываем
        System.out.println(liststr);                                        // компаратор по котором у будем сортировать

        Stream<Integer> stream1 = Stream.of(1,2,3,4,5);
        stream1.filter(el -> {return el%2==0;}).map(el -> el+1);//это не вызовится. пока не появится функция которая делает
                        // что-либо с этим всем например toList() или reduse и forEach, короче что-то что вернет не Stream

        //concat объеденяет стримы Stream<Integer> streamresult = Stream.concat(stream1, stream2);
        //stream1.count() вернет количество элементов
        //stram.distinct - удалит все копии

        //СТРИМЫ МЫ НЕ МОЖЕМ ПЕРЕИСПОЛЬЗОВАТЬ. НАПРИМЕР ВЫЗВАТЬ ДВА РАЗА РАЗНЫЕ ФУНКЦИИ НЕ В ОДНОЙ ОПЕРАЦИИ А В ДВУХ
    }
}
