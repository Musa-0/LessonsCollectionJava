package com.test;

public class CreateJavaFileEx {

//    javac[ключи][исходники] - компиляция
//    java [ключи] класс[аргументы] - запуск
//
//    javac Myapp.java - компиляция
//    java Myapp -запуск

//    но, есть проблема, что при создании множества классов, все они будут лежать там же где и исходники
//    и дабы выделить исполняемым файлам отдельное место мы пишем параметр -d
//    javac -d classes src/Myapp.java - теперь этот байт код будет положен в каталог classes, и не будет смешьватсья с другими
//

//    Джава машина, компилирует наш исходник, проверяя на ошибки. после компилятор создает новый файл закодированый c
//    помощью байт кода, а после, этот байт код, передается на устройство с джава машиной. и эта джава машина сама
//    скомпилирует данный код, в бинарный код для этого устройства

//структура проекта такова
//    Progect|
//           |--src тут хронятся исходники
//           |
//           |--classes - а тут наши байт коды
//
//-sourcepath указывает root каталог от которого будут идти относительные url
//            javac -d classes -sourcepath src; /sid/project/src src/com/les1/myApp - при создании байт кода в пакете classes
//            этот байт код будет знать, что корень проекта находится в src, и все относительные пути делать от туда

//    а что если нам нужен, не исходник, а например сами байт кода (.class) и допустим, нам нужен класс из другого проекта
//    чтобы указать байт кода классов, нужно использовать -classpath это как -sourcepath но не для исходников
//    а для самих файлов классов.
//            javac -d classes -cp ../project2/classes  src/com/les1/myApp - при компиляции мы указываем, где хронятся
//    файлы классов, с которыми он будет работать. -cp это и есть -classpath
//    java -cp classes;../prohect2/classes com.les1.myApp - тут мы указываем каталог с доп классами, и уже от них будет идти import
//    а именно отноительный url


//создаем файл Main.java
//javac Main.java   - компилируем его
// создаем манифест для jar архива
//jar cfe app.jar Main Main.class    - Main - точка входа в программу, Main.class это то что мы кладем в архив
//java -jar app.jar - запускаем
}


