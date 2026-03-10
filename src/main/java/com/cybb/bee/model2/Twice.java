package com.cybb.bee.model2;

public class Twice implements IdolSkill {
    private static int count = 0;
    private String name;
    private int age;
    private String nationality;
    private String color;

    public Twice(String name, int age, String nationality, String color) {
        count = count + 1;
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.color = color;
    }

    @Override
    public void sing() {
        System.out.println(name + "在唱歌");
    }

    @Override
    public void dance() {
        System.out.println(name + "在跳舞");
    }

    @Override
    public void rap() {
        System.out.println(name + "在rap");
    }

    public int gatAge() {
        return this.age;
    }

    public String gatNationality() {
        return this.nationality;
    }

    public String gatColor() {
        return this.color;
    }

    public static int getCount() {
        return count;
    }

    public void exit() {
        count = count - 1;
        System.out.println(name + "退团了");
    }
}
