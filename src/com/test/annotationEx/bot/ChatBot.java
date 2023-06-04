package com.test.annotationEx.bot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

public class ChatBot {                      //наш класс бота

    private static final HashMap<String, Method> COMMAND = new HashMap<>();                //список всех комманд
    private static final CommandListener LISTENER = new CommandListener();          //наш класс прослушивающий комманды
    static
    {
        Method[] methods = LISTENER.getClass().getDeclaredMethods();//берем все методы класса CommandListener кроме тех что унаследованы

        for(Method m: methods){             //проходимся по всем методам

            if (m.isAnnotationPresent(Command.class)){          //если метод имеет аннотацию Command то
                COMMAND.put(m.getAnnotation(Command.class).name(),m);       //добавляем её в наш словарь команд, где имя будет метаданные из аннотации, а метод будет сам метод

                for (String s: m.getAnnotation(Command.class).aliases()){
                    COMMAND.put(s, m);              // так же кладем слова заменяющие нашу команду, с указателем на ту же комманду
                    //например Привет:hello, Здарова:hello итд итп
                }

            }
        }

    }

    public String reciveMessage(String message) throws InvocationTargetException, IllegalAccessException {    //метод, который принимает сообщения боту

        if(message.toLowerCase().startsWith("бот")){        //если сообщение начинается со слова бот
            try {
                String[] arr_mesage = message.split(" ");//берем список ['Бот', 'команда', 'аргумент1','аргумент2'...]
                String command = arr_mesage[1]; //берем саму команду
                String[] args = Arrays.copyOfRange(arr_mesage, 2, arr_mesage.length);  //получаем все аргументы сообщения
                Method m = COMMAND.get(command);

                if (m == null)        //если такой команды нет
                {
                    //(вывод помощи)
                    return (String) COMMAND.get("help").invoke(LISTENER, (Object) args);
                }
                Command com = m.getAnnotation(Command.class);
                if (args.length < com.minArgs())
                {
                    return "Аругментов меньше чем нужно";
                }
                else if (args.length > com.maxArgs())
                {
                    return "Аругментов больше чем нужно";
                }
                //Через рефлексию вызываем нашу функцию-обработчик
                //Именно потому что мы всегда передаем аrgs у функции должен быть параметр
                //String[] args — иначе она просто не будет найдена;
                return (String) m.invoke(LISTENER, (Object) args);
            }
            catch (ArrayIndexOutOfBoundsException e)            //в случае если написано просто Бот
                {
                    return "Напишите какую-нибудь команду. А не просто 'Бот'";
                }
        }
        else {
            return "Не корректно введена команда";
        }

    }
}
