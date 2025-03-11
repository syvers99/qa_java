package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static com.example.ConfigConst.*;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class LionTest  {

    @Mock
    Feline feline;
    Lion lion;
    @Before
    public void setUp () throws Exception {
        lion = Mockito.spy(new Lion(MALE, feline));
    }



    @Test
    public void getKittensTest() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1,lion.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }



    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(feline.getFood(PREDATOR)).thenReturn(PREDATOR_FOOD);
        assertEquals(PREDATOR_FOOD, lion.getFood());
        Mockito.verify(feline, Mockito.times(1)).getFood(PREDATOR);

    }


}