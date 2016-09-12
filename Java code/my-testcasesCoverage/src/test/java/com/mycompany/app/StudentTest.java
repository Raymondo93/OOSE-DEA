package com.mycompany.app;

import junit.framework.TestCase;

/**
 * Created by Rene on 12-9-2016.
 */
public class StudentTest extends TestCase {

    public void testSetStudentName()
    {
        Student student = new Student();

        student.setName("Rene Buunk");

        assertEquals("Rene Buunk", student.getName());
    }

    public void testEmptyNameException()
    {
        Student student = new Student();

        try {
            student.setName("");
            fail("Expected the test to fail");
        }catch(IllegalArgumentException e) {
            assertEquals("The string was null or empty", e.getMessage());
        }
    }

    public void testCalculateAverageMark(){

        Student student = new Student();

        double[] marks = {8, 5, 3, 0, 4};

        double averageMark = student.calculateAverageMark(marks);

        assertEquals(4.0, averageMark);
    }

    public void testCalculateAverageWithZeroMark()
    {
        Student student = new Student();

        double[] marks = {0};

        double averageMark = student.calculateAverageMark(marks);

        assertEquals(0.0, averageMark);
    }

}
