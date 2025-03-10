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
public class LionTest  {


    Feline feline = mock(Feline.class, CALLS_REAL_METHODS);
    Lion lion;
    @Before
    public void setUp () throws Exception {
        lion = Mockito.spy(new Lion(MALE, feline));
    }



    @Test
    public void getKittensTest() {
        assertEquals(1, lion.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        Mockito.verify(lion, Mockito.times(1)).getKittens();
    }



    @Test
    public void getFoodTest() throws Exception {
        assertEquals(PREDATOR_FOOD, lion.getFood());
        Mockito.verify(feline, Mockito.times(1)).getFood(PREDATOR);
        Mockito.verify(lion, Mockito.times(1)).getFood();

    }



}