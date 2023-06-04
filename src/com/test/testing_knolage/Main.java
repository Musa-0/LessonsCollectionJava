package com.test.testing_knolage;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Musa",17,4.5);
        User user2 = new User("Hava",16,3.4);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user1.equals(user2));

    }
}
