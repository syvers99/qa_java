package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


import static com.example.ConfigMap.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest  {


    @Spy
    Feline feline;
    Lion lion;
    @Before
    public void setUp () throws Exception {
        lion = new Lion(MALE, feline);}



    @Test
    public void getKittensTest() {
        assertEquals(1, lion.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }



    @Test
    public void getFoodTest() throws Exception {
        assertEquals(PREDATOR_FOOD, lion.getFood());
        Mockito.verify(feline, Mockito.times(1)).getFood(PREDATOR);
    }



}