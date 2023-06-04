package com.test.work_with_file.serializer;

import java.io.Serializable;

public class Person implements Serializable {//этот интерфейс позволяет джаве сериализовывать этот объект
    private static final long serialVersionUID = 4877536310083278588L;//это id состояния класса. допустим мы создали объект этого класса и записали его в файл
    //и потом мы решили изменить этот класс сделать изменения. изменить или удалить некоторые поля. и тогда мы не сможем открыть этот объект так как он
    //пренадлежит старому классу а это новый. и этот id присваивается всем объектам и если мы изменим наш класс то мы изменим и его serialUID и когда мы присвоим
    //объект из файла, старого класса объекту нового класса то этот id бужет отличаться и он просто не передасться. сработает ошибка

    private int id;
    private String name;
    private transient int age =10;//transient - запрещает этому полю сериализовываться. и вызывая это поле у объекта из сериализатора оно будет ровняться нулю если int если string то null.
    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String toString(){
        return id + ":" + name;
    }
}
