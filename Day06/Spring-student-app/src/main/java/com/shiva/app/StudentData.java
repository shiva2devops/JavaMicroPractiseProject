package com.shiva.app;

public class StudentData {

    String name;
    String roll;
    String schoolName;
    String age;

    public String getName() {
        return name;
    }

    public String getRoll() {
        return roll;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getAge() {
        return age;
    }

    public StudentData(){

    }
    public StudentData(String name, String roll, String schoolName, String age) {
        this.name = name;
        this.roll = roll;
        this.schoolName = schoolName;
        this.age = age;
    }




}
