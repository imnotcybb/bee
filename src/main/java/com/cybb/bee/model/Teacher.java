package com.cybb.bee.model;

public class Teacher {

    private String name;     // 姓名
    private String gender;   // 性别
    private int age;         // 年龄
    private String subject;  // 科目
    private int level;       // 职级（1-8级）
    private String campus;   // 校区
    private int years;       // 工龄

    // 无参构造函数
    public Teacher() {
    }

    // 全参构造函数
    public Teacher(String name, String gender, int age, String subject, int level, String campus, int years) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.subject = subject;
        this.level = level;
        this.campus = campus;
        this.years = years;
    }

    // getter 和 setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    // toString 方法（方便打印）
    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", subject='" + subject + '\'' +
                ", level=" + level +
                ", campus='" + campus + '\'' +
                ", years=" + years +
                '}';
    }
}
