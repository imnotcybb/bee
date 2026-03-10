package com.cybb.bee.model;

public class Cat implements PetAction {
    public static int count = 0;
    private String name;
    private int age;
    private boolean isIndoor;

    public Cat(String name, int age, boolean isIndoor) {
        count = count + 1;
        this.name = name;
        this.age = age;
        this.isIndoor = isIndoor;
    }

    @Override
    public void play() {
        System.out.println(name + "玩毛线球");
    }

    @Override
    public void eat() {
        System.out.println(name + "吃猫粮");
    }

    @Override
    public void sleep() {
        System.out.println(name + "睡猫窝");
    }

    @Override
    public void dead() {
        count = count - 1;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public boolean getIsIndoor() {
        return this.isIndoor;
    }

    public static int getCount() {
        return count;
    }
}
