package com.mycompany.app;

import junit.framework.TestCase;
import org.junit.Test;

//Extend the class with TestCase so you can use the assert functionality
public class MyTypeTest extends TestCase {

    //Annotation to indicate that the function is a test
    //Also the name has to start with test
    @Test
    public void testIncreaseMyLong()
    {
        //initialize variables to test with
        MyType myLong = new MyType(3);

        //The function that you want to execute
        myLong.increase();

        //Check if the execution was successfull
        assertEquals(4, myLong.getMyLong());
    }
}
