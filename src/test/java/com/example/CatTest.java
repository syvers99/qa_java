package com.example;


import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;



import static com.example.ConfigConst.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    Feline feline = mock(Feline.class, CALLS_REAL_METHODS);
    Cat cat;

    @Before
    public void setUp() throws Exception {
        cat = Mockito.spy(new Cat(feline));
    }


    @Test
    public void getSoundTest() {
        assertEquals(CAT_SOUND, cat.getSound());
        Mockito.verify(cat, Mockito.times(1)).getSound();
    }

    @Test
    public void getFoodTest() throws Exception {
        assertEquals(PREDATOR_FOOD, cat.getFood());
        Mockito.verify(cat, Mockito.times(1)).getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}