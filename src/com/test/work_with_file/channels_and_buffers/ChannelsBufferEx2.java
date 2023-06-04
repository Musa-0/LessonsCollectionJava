package com.test.work_with_file.channels_and_buffers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelsBufferEx2 {
    public static void main(String[] args) {
        try(RandomAccessFile file =
                    new RandomAccessFile("src/com/test/work_with_file/files/buffer_channel2.txt", "rw");
            FileChannel channel = file.getChannel();) {

            ByteBuffer buffer = ByteBuffer.allocate(5);

            channel.read(buffer);//читаем из файла 5 байт данных и записываем их в буфер
            buffer.flip();
            System.out.println((char)buffer.get());//прочтем 3 байта a
            System.out.println((char)buffer.get());//                b
            System.out.println((char)buffer.get());//                c
            buffer.rewind();//переместит позицию на 0, и чтение буфера будет идти теперь с начала
            System.out.println((char)buffer.get());//               a - так как теперь мы читаем с начала

            System.out.println("\n-----------------------------------------\n");

            buffer.compact();// мы сейчас на букве b, и хотим записать ещё один символ. метод compact в отличии от clear
            //не перемещает позицию 0 и начинаем перезаписывать данные. вместо этого, он берет те данные что ещё не прочел
            //а именно b c d e, он прочел лишь а. после чего перемещает их, в начало буфера, а сам дописывает байт в конец
            //тем самым мы сохранили байты которые ещё не прочли, и можем добавить символ в конец буфера. удалив букву 'а'
            //теперь у нас режим записи, и мы на позиции e+1

            channel.read(buffer);//допишем в освободившее место после compact след букву из файла букву f
            buffer.flip();//переходим в режим чтения

            while (buffer.hasRemaining()){
                System.out.println((char) buffer.get());//выведем все оставшиеся данные, от буквы а которую уже прочли
                // и плюс f что мы добавили на конец
            }

            System.out.println("\n-------------------------------\n");
            buffer.clear();//переходим в режим обычной записи с первого элемента
            channel.read(buffer);//и читаем из файла последние 4 байта записывая их в буффер
            buffer.flip();//переходим в режим чтения
            System.out.println((char) buffer.get());//берем букву g из нашего буфера

            buffer.mark();//ставит отметку на этом месте, чтобы потом вернуться к нему. сейчас мы на позиции h

            System.out.println((char) buffer.get());//вывели h
            System.out.println((char) buffer.get());//вывели i

            buffer.reset();//возвращаемся к этой отметке обратно, на место где поставили mark, а именно на букве h

            while (buffer.hasRemaining()){
                System.out.println((char) buffer.get());//выведем все данные после h так как мы находимся на h из-за
                // отметки которую поставили выше
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
