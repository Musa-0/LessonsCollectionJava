package com.test.work_with_file.channels_and_buffers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferEx1 {
    public static void main(String[] args) {
        try (RandomAccessFile file =
            new RandomAccessFile("src/com/test/work_with_file/files/buffer_channel.txt", "rw");//создаем чтение или записи файла с любого места
            FileChannel channel = file.getChannel();)//СОЗДАЕМ НАШ КАНАЛ созданный из файла
        {

            ByteBuffer buffer = ByteBuffer.allocate(25);//создаем буффер с макс размером 25 байт

            StringBuilder str = new StringBuilder();//будем записывать сюда данные из нашего файла

            int byteRead = channel.read(buffer);//КАНАЛ ЧИТАЕТ ДАННЫЕ ИЗ ФАЙЛА, И ЗАПИСЫВАЕТ ЭТИ ДАННЫЕ В БУФФЕР!
            // а сам метод возвращает коллво прочитанных байт

            while (byteRead > 0)//будем читать данные, пока колличество прочитанных байт из файла, больше нуля
            {
                System.out.println("Read " + byteRead);//выводим сколько данных мы будем читать

                buffer.flip();//меняем режим буфера на режим чтения

                while (buffer.hasRemaining())//пока из буфера есть что читать
                {

                    str.append((char) buffer.get());//читаем из буфера данные, и записываем их в нашу строку
                }

                buffer.clear();//переводим снова в режим записи
                byteRead = channel.read(buffer);//и записываем данные в буфер
            }
            //Можешь запускать
            System.out.println(str);



            //Запись в файл
            String text = "\nHiiii my name is, whaaat? my name is whooo? my name is chiki chiki slimshaaaady";//создадим строку

            //будем использовать тот же канал, так как канал имеет двустороннюю передачу даннх

//            ByteBuffer buffer1 = ByteBuffer.allocate(text.getBytes().length);//создадим буфер размером с нашу строку
//            buffer1.put(text.getBytes());//запишем в буфер нашу строку целиком, так как размер буфера равен размеру строки
//            buffer1.flip();//меняем на режим чтения, чтобы канал смог прочитать данные из буффера и записать в файл
//            channel.write(buffer1);//channel ЗАПИШЕТ В ФАЙЛ К КОТОРОМУ ОН ПРИВЯЗАН ДАННЫЕ ИЗ БУФЕРА

            //все эти строки можно заменить двумя
            ByteBuffer buffer1 = ByteBuffer.wrap(text.getBytes());//берем из файла все байты и записываем их в буффер
            channel.write(buffer1);//а далее читаем их из буфера и записываем в файл


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
