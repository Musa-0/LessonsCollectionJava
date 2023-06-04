package com.test.threading;
//потоки демоны, отличаются от обычных(User потоков) тем что при окончании главного потока, он ждет окончания остальных потоков,
// а потоков демонов не ждут, если все основные потоки завершились то демон автоматически завершится
//Deamon потоки необходимы для исполнения фоновых задач, и оказания различных сервисов User потокам
public class DeamonEx {
    public static void main(String[] args) {
        System.out.println("Главный поток пошеееел");

        UserThread userThread = new UserThread();
        userThread.setName("user_Thread_musa");

        DeamonThread deamonThread = new DeamonThread();
        deamonThread.setName("deamon_Thread_musa");
        deamonThread.setDaemon(true);//делаем созданый поток демоном ДО ЕГО ЗАПУСКА, ИНАЧЕ НЕ СРАБОТАЕТ! и будет ошибка

        userThread.start();//User поток точно отрабтает полностью пока не закончится, другие потоки будут ждать его окончания
        deamonThread.start();//Deamon поток оборвется когда закончится Main поток, и User поток
        System.out.println("Главный поток завершен!");
    }
}

class UserThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is deamon " + isDaemon());

        for (char i= 'A'; i<='J'; i++){
            try {
                sleep(300);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class DeamonThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is deamon " + isDaemon());

        for (int i= 1; i<=1000; i++){//буквы от A до J
            try {
                sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}