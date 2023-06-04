package com.test.work_with_file;

import java.io.*;
//ВСЕГДА ИСПОЛЬЗУЙТЕ БУФЕРИЗАЦИЮ ЕСЛИ ЭТО ВОЗМОЖНО
// Буферизация - это загрузка части файла, происходящая во время потоковой передачи. например музыка загружается
//по кусочкам. в момент когда мы её слушаем. Использование буферизации, позволяет достичь большей эфективности при
//чтении или записи в файл. BufferedWriter и BufferedReader - это обертки для FileWrtiter и FileReader
//но если FileReader читает файл посимвольно. и кааждый раз для нового символа обращается к файлу что затратно. то
//Buffer позволяет один раз наполнить его несколькими символами а после уже работать с ними из буфера. что куда быстрее
//Так же и при записи. буфер возьмет в себя часть символов и разом их запишет а не будет обращаться по 1000 раз
public class Bufferesed {
    //прочтем данные из одного файла и запишем их в другой
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(//создаем буферизированое чтение из файла
                    new FileReader("src/com/test/work_with_file/files/bufferFileReaderTest1.txt"));
            BufferedWriter writer = new BufferedWriter(//создаем буферезированую запись в файл
                    new FileWriter("src/com/test/work_with_file/files/bufferFileWrtiterTest2.txt"));)
        {
//            int character; можно читать посимвольно
//            while ((character=reader.read()) != -1){
//                writer.write(character);
//            }
            //А можно сразу по строчно
            String line;
            while ((line=reader.readLine()) != null){
                writer.write(line);//записываем построчно а не посимвольно
                writer.write("\n");
            }
            System.out.println("done");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;
    }

}
