package com.test.work_with_file;

import java.io.*;

//DataInputStream и DataOutputStream - позволяют записывать в файл и читать из него примитивные типы данных
//этот класс обертка
public class DataInput_DataOutput_Stream {
    public static void main(String[] args) {
        try(DataOutputStream outputStream = new DataOutputStream(
                new FileOutputStream("src/com/test/work_with_file/files/binary/dataPrimitiv.bin"));
            DataInputStream inputStream = new DataInputStream(
                    new FileInputStream("src/com/test/work_with_file/files/binary/dataPrimitiv.bin"))
        ) {
            outputStream.writeBoolean(true);//записываем разные типы примитивных классов, int float итд
            outputStream.writeByte(5);
            outputStream.writeShort(120);
            outputStream.writeInt(500);
            outputStream.writeLong(1344234L);

            System.out.println(inputStream.readBoolean());//читаем поочередно данные своих типов
            System.out.println(inputStream.readByte());
            System.out.println(inputStream.readShort());
            System.out.println(inputStream.readInt());
            System.out.println(inputStream.readLong());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
