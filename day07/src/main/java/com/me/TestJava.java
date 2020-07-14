package com.me;

/**
 * @author maow
 * @create 2020-05-26 11:41
 */
public class TestJava {
    public static void main(String[] args) {
        System.out.println(Human.class.getInterfaces().length);
    }
}

interface Human{

}

class Person1 implements Human{

}

class User1 extends Person1{

}
