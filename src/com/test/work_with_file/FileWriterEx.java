package com.test.work_with_file;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
    public static void main(String[] args) throws IOException {
        String text = "Муса это велиииикий человеееек\n" +
                "Он знаает толк. он всееее знает\n" +
                "Он как Гаупштабфюрер.\n";//вот наш тексе

        FileWriter writer=null;//создадим его вне try, чтобы блок закрытия в finaly не ругался
        try {
            writer = new FileWriter("src/com/test/work_with_file/files/fileWrtiterTest1.txt",true);
            //наш класс для записи указываем относительный путь к файлу. если его нет, то он создастся,
            // true во втором аргументе означает дописывание в файл а не его перезапись
            writer.write(text);//запишет, посимвольно, все символы в этот файл
            writer.write("Lol");//допишется в конце. тут мы передаем String, но String делает кастинг до Int
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            writer.close();// В КОНЦЕ ВСЕГДА ЗАКРЫВАЙТЕ СОЕДИНЕНИЕ. ИНАЧЕ НЕ СОХРАНИТСЯ ЗАПИСЬ В ФАЙЛ
        }
        System.out.println("done");
    }
}
//Что бы не забывать постоянно закрывать соединение можно использовать try с ресурсами
//после работы try ресурс что положен в его аргумент автоматически закроется

//try(FileWriter writer=new FileWriter("src/com/test/work_with_file/files/fileWrtiterTest1.txt",true; (можно тут ещё какой-то ресурс вставить который в конце должен закрыться) )) {
//
//        writer.write(text);
//        writer.write("Lol");

//        } catch (IOException e) {//если нам нужен try лишь для закрытия соединения в конце. то можно catch не писать тут
//        throw new RuntimeException(e);
//        }

//        System.out.println("done");
//        }