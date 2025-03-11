package com.example;

import org.junit.Before;
import org.junit.Test;

import static com.example.ConfigConst.FAMILY;
import static org.junit.Assert.assertEquals;

public class AnimalTest {

    Animal animal;
    @Before
    public void setUp () {
        animal = new Animal();}

    @Test
    public void getFamilyTest() {
        assertEquals(FAMILY,animal.getFamily());
    }
}
