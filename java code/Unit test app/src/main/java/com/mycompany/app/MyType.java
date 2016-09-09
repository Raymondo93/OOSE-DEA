package com.mycompany.app;

/**
 * Created by Rene on 8-9-2016.
 */
public class MyType {

    public long MyLong = 0;

    public MyType(int i)
    {
        MyLong = i;
    }

    public void increase()
    {
        MyLong++;
    }

    public long getMyLong()
    {
        return MyLong;
    }

}
