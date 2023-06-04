package com.test.Generics.Game_Olimp;
//Судь игры в том, что есть три команды, Schooler Students Employee,
//в одной команду могут быть лишь люди из своего же статуса. в команде со студентами могут быть лишь студенты
//Так же играть могут лишь команды своего ранга. команда работников с работниками
public class GamePlay {
    public static void main(String[] args) {


    Schooler sch1 = new Schooler("Амина", 11);//школьники
    Schooler sch2 = new Schooler("Musa", 13);
    Schooler sch3 = new Schooler("Миша", 11);
    Schooler sch4 = new Schooler("Хава", 13);

    Students st1 = new Students("Аня", 17);//студенты
    Students st2 = new Students("Ваня", 18);
    Students st3 = new Students("Саня", 19);
    Students st4 = new Students("Саша", 16);

    Employee em1 = new Employee("Дмитрий", 43);//работники
    Employee em2 = new Employee("Артем", 23);
    Employee em3 = new Employee("Федор", 36);
    Employee em4 = new Employee("Игорь", 25);

    Team<Schooler> team_sch1 = new Team<>("Драконы");//команды школьников
    Team<Schooler> team_sch2 = new Team<>("Школота");

    Team<Students> team_stu1 = new Team<>("Артемины");//команды студентов
    Team<Students> team_stu2 = new Team<>("Посейдоны");

    Team<Employee> team_emp1 = new Team<>("Мудрецы");//команды работников
    Team<Employee> team_emp2 = new Team<>("Работяги");

    team_sch1.addParticepent(sch1);//добавляем в первую команду школьников
    team_sch1.addParticepent(sch2);
    team_sch2.addParticepent(sch3);//добавляем во вторую команду школьников
    team_sch2.addParticepent(sch4);

    team_stu1.addParticepent(st1);//добавляем в первую команду студентов
    team_stu1.addParticepent(st2);
    team_stu2.addParticepent(st3);//добавляем во вторую команду студентов
    team_stu2.addParticepent(st4);

    team_emp1.addParticepent(em1);//добавляем в первую комкнду работников
    team_emp1.addParticepent(em2);
    team_emp2.addParticepent(em3);//добавляем во вторую команду работников
    team_emp2.addParticepent(em4);



//мы не можем добавить в команду школьников например работников, ибо наш класс постоет так что добавлять можем лишь своих

    team_sch1.gameWith(team_sch2);//соревнование двух команд школьников
    team_stu1.gameWith(team_stu2);//соревнование двух команд студентов
    team_emp1.gameWith(team_emp2);//соревнование двух команд работников

//мы не можем содать игру школьников и студентов например, так как мы сделали класс так, чтобы была игра лишь со своими

    }

}
