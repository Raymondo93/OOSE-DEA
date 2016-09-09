package com.unittest.oefening;

/**
 * Created by Rene on 9-9-2016.
 */
public class Student {

    private String name;
    private int id;
    private char gender;
    private int points;

    public Student(String name, int id, char gender, int points) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

