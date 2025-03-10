package com.example;

import org.junit.Before;
import org.junit.Test;


import static com.example.ConfigConst.FELINE;
import static com.example.ConfigConst.PREDATOR_FOOD;
import static org.junit.Assert.*;

public class FelineTest {

    Feline feline;
    @Before
    public void setUp () {
        feline = new Feline();}

    @Test
    public void eatMeatTest() throws Exception {
        assertEquals(PREDATOR_FOOD,feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        assertEquals(FELINE,feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        assertEquals(1,feline.getKittens());
    }

    @Test
    public void getKittensWithArgumentTest() {
        assertEquals(10,feline.getKittens(10));
    }
}