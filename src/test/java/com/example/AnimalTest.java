package com.example;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.List;

import static com.example.ConfigMap.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalTest {
    private final String animalKind;
    private final List<String> food;


    public AnimalTest(String animalKind, List<String> food) {
        this.animalKind = animalKind;
        this.food = food;

    }
    Animal animal;
    @Before
    public void setUp () {
        animal = new Animal();}

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {PREDATOR,PREDATOR_FOOD},
                {HERBIVORE,HERBIVORE_FOOD},
                {INSECT,NULL_VALUE},
                {EMPTY_VALUE,NULL_VALUE},
                {NULL_VALUE,NULL_VALUE},

        };
    }

    @Test
    public void getFamilyTest() {
        assertEquals(FAMILY,animal.getFamily());
    }

    @Test
    public void getFoodTest() throws Exception{
        if (PREDATOR.equals(animalKind)||HERBIVORE.equals(animalKind)){
        assertEquals(food,animal.getFood(animalKind));}
        else {
            Exception exception = assertThrows(Exception.class, () -> animal.getFood(animalKind));
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(ANIMAL_EXCEPTION_MESSAGE));
        }
    }
}