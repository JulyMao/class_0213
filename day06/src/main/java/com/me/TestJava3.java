package com.me;

/**
 * @author maow
 * @create 2020-05-25 20:28
 */
public class TestJava3 {
    public static void main(String[] args) {

        //
        User1 user = new User1();
        test(user);

    }
    public static void test(Person person) {
        System.out.println("person...");
    }
//    public static void test(User1 user1) {
//        System.out.println("user1...");
//    }

}
class Person {

}
class User1 extends Person {
}
