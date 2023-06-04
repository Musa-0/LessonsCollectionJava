package com.test.annotationEx.bot;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class CommandListener {

    @Command(name = "Привет",
            args = "",
            desc = "В культурнов обществе здороваются",
            showInHelp = false,
            maxArgs = 1,
            aliases = {"Хай", "Здорова"})
    public String hello(String[] args){                      //создаем метод приветствия. передавая ему метаданные. благодаря которым мы сможем вызывать этот метод, по этим метаданым
        return "Привет от Бота! " + args[0];
    }

    @Command(name = "Пока",
            args = "",
            desc = "",
            aliases = {"Покеда"})
    public String bye(String[] args){                    //метод прощания
        return "Пока от Бота!";
    }

    @Command(name = "Помощь",
            args = "",
            desc = "Описание всех комманд",
            aliases = {"help"})
    public String help(String[] args){                       //метод который выводит все комманды. метод help
        StringBuilder stringBuilder = new StringBuilder();
        Class commandListener = CommandListener.class;
        Method[] methods = commandListener.getDeclaredMethods();
        for(Method m: methods){
            if(m.isAnnotationPresent(Command.class)){               //если у метода есть аннотация Command
                Command com = m.getAnnotation(Command.class);
                if(com.showInHelp()){    //если аннотация содержит переменную showInHelp как true
                    stringBuilder.append("Бот, ")           //то добавляем к строке вывода всех комманд, ещё одну комманду
                            .append(com.name()).append(" ")
                            .append(com.args()).append(" - ")
                            .append(com.desc()).append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }
}
