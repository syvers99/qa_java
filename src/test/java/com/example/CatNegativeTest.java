package com.example;


import org.junit.Test;

import static org.junit.Assert.*;



public class CatNegativeTest {


    @Test
    public void constructorTest()  {
        Cat cat = new Cat( null);
        assertThrows(Exception.class, cat::getFood);
    }
}