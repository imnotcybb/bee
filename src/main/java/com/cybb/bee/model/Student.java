package com.cybb.bee.model;

public class Student {
    private Long id;
    private String studentNumber;
    private String name;
    private String email;
    private Integer age;
    private String major;
    private String grade;
    private String phone;

    // 构造函数
    public Student() {}

    public Student(String studentNumber, String name, String email, Integer age, String major, String grade,
            String phone) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.email = email;
        this.age = age;
        this.major = major;
        this.grade = grade;
        this.phone = phone;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
