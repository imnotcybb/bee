package com.cybb.bee;

import com.cybb.bee.model.Cat;

public class Main {
    public static void main(String[] args) {
        Cat hope = new Cat("hope", 4, false);
        System.out.println("现在有" + Cat.getCount() + "只猫！");

        Cat hapa = new Cat("hapa", 3, false);
        Cat joey = new Cat("joey", 6, false);
        System.out.println("现在有" + Cat.getCount() + "只猫！");
        hope.eat();
        hapa.sleep();
        joey.play();

        hapa.dead();
        System.out.println("现在有" + Cat.getCount() + "只猫！");
    }
}