package com.example;


import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;

import org.mockito.junit.MockitoJUnitRunner;



import static com.example.ConfigMap.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Spy
    Feline feline;


    @Test
    public void getSoundTest() {
        Cat cat = new Cat( feline );
        assertEquals(CAT_SOUND,cat.getSound());
    }

    @Test
    public void getFoodTest() throws Exception{
        Cat cat = new Cat( feline );
        assertEquals(PREDATOR_FOOD,cat.getFood());
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
    @Test
    public void constructorTest()  {
        Cat cat = new Cat( null);
        assertThrows(Exception.class, cat::getFood);
    }
}