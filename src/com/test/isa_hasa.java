package com.test;

public class isa_hasa {


//    IS-A - это когда какой-то класс наследует другой
//
//            Teacher IS-A People
//
//            HAS-A - это когда два класса взаимо связыываются
//



//            1Ассоциация- отношения основаные на использовании
//            class A{
//                private B bklass;
//            }
//            class B{
//
//            }
//


//            2Агрегация-использование объекта класса, в методах, в которые мы можем положить одинаковые объекты одного
//            класса для разных объектов другого класса
//            class A{
//                private B bklass;
//                public A(B bklass) {
//                    this.bklass = bklass; - тут мы можем вставить любой объект
//                }
//            }
//            class B{
//            }
//



//            3композиция - тоже самое что и агрегация. но тут, для каждого объекта одного класса, создается отдельный
//            объект другого класса
//            class A{
//                private B bklass;
//                public A(B bklass) {
//                    this.bklass = new B() - тут мы создаем для каждого объекта A свою ссылку на объект B
//                }
//            }
//            class B{
//            }
//
//    }
}
