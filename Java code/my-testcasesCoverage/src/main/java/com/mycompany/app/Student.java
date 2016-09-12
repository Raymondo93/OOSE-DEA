package com.mycompany.app;

/**
 * Created by Rene on 12-9-2016.
 */
public class Student {

    private String name;

    public void setName(String name) throws IllegalArgumentException{
        if(name == null || name == "")
            throw new IllegalArgumentException("The string was null or empty");

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double calculateAverageMark(double[] marks) {
        double totalMark = 0;

        for (double mark: marks) {
            totalMark += mark;
        }

        double average = totalMark / marks.length;

        return average;
    }
}
