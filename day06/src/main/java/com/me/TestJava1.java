package com.me;

import com.me.next.Person;

/**
 * @author maow
 * @create 2020-05-25 10:31
 */
public class TestJava1 extends Person {
    public static void main(String[] args) throws CloneNotSupportedException {
        TestJava1 testJava1 = new TestJava1();
        testJava1.clone();
//        User user = new User();
//        user.clone();
//        user.speak();
    }
}




//class User extends Person {
//    public void test() throws CloneNotSupportedException {
//        User user = new User();
//        user.clone();
//    }
//}