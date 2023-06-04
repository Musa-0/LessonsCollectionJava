package com.test.threading.synchronizators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

//Exchanger - это синхронизатор, позволяющий обмен между двумя потоками. и оба потока, получают информацию одновременно
//есть два потока Т1 и Т2. если Т1 хочет передать информацию Т2. то он посласт сигнал на передачу данных, а сам будет
//ждать пока Т2 не прочтет этот сигнал и не отправит что-то в ответ, Т1 заблокируется. а Т2 будет работать пока не
//заметит сигнал о передаче данных. и тогда тот передаст что-либо в ответ. и два потока получат данные друг от друга одновреиенно
//Т2 ничего увидит пока сам не отправит в ответ данные. это как в камень ножницы бумага. надо одновременно показать
//сделаем камень ножницы бумагу. передаваемая инфа. должна быть одного и того же типа данных
public class ExchangerEx {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();//создаем объект обмена для двух потоков

        List<Action> friendAction1 = new ArrayList<>();//список событий которые покажет первый друг ножницы и бумага
        friendAction1.add(Action.NOJNICI);
        friendAction1.add(Action.BUMAGA);

        List<Action> friendAction2 = new ArrayList<>();//список событий который покажет второй друг бумага и ножницы
        friendAction2.add(Action.BUMAGA);
        friendAction2.add(Action.NOJNICI);

        new CuEfa("Vanya", friendAction1,exchanger);//создаем двух игроков
        new CuEfa("Musa", friendAction2,exchanger);

    }
}
enum Action{
    KAMEN, NOJNICI, BUMAGA;
}
class CuEfa extends Thread {
    private String name;
    private List<Action> myActiom;//список действий
    private Exchanger<Action> exchanger;


    public CuEfa(String name, List<Action> myActiom, Exchanger<Action> exchanger) {
        this.name = name;
        this.myActiom = myActiom;
        this.exchanger = exchanger;
        this.start();
    }
    private void whoWins(Action myAction, Action friendAction){
        if((myAction == Action.KAMEN && friendAction==Action.NOJNICI) ||//пишем все варианты нашей победы
                (myAction == Action.BUMAGA && friendAction == Action.KAMEN) ||
                (myAction == Action.NOJNICI && friendAction == Action.BUMAGA)){
            System.out.println(name + " Wins!");
        }
    }

    @Override
    public void run() {
        Action reply;//ответ друга
        for(Action action: myActiom){
            try {
                reply = exchanger.exchange(action);//в exchange я вписываю свою информацию а в ответ получаю инфу второго поткоа
                //пока второй поток, то есть друг не покажет что у него дальше поток не продолжится
                whoWins(action, reply);//после того как получим инфу от второго потока. вставляем эти данные в нам метод
                //он вызывает тот же метод. и если победил я то у меня выведится то что я победил. если победил он
                //то у него высветится то что он победил. такова логика нашей функции
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

