package com.test.annotationEx.bot;

import java.lang.reflect.InvocationTargetException;

public class Client {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ChatBot chatBot = new ChatBot();
        System.out.println(chatBot.reciveMessage("бот Привет Куларесов"));
    }
}
