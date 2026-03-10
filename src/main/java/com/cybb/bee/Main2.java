package com.cybb.bee;

import com.cybb.bee.model2.Twice;

public class Main2 {
    public static void main(String[] args) {
        Twice momo = new Twice("momo", 30, "Japan", "pink");
        Twice sana = new Twice("sana", 30, "Japan", "purple");
        Twice mina = new Twice("mina", 29, "Japan", "green");
        momo.dance();
        sana.sing();
        mina.rap();
        System.out.println("momo的应援色是" + momo.gatColor());
        mina.exit();
        System.out.println(Twice.getCount());
    }
}