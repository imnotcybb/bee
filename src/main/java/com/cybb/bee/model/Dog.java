package com.cybb.bee.model;

public class Dog implements PetAction {
    private int age;
    private String name;
    private String breed;

    public Dog(int age1, String name1, String breed1) {
        this.age = age1;
        this.name = name1;
        this.breed = breed1;
    }

    @Override
    public void eat() {
        System.out.println(name + "在吃狗粮");
    }

    @Override
    public void sleep() {
        System.out.println(name + "在客厅睡觉");
    }

    @Override
    public void play() {
        System.out.println(name + "在玩球");
    }

    @Override
    public void dead() {
        System.out.println(name + "在玩球");
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed(){
        return this.breed;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }
}
