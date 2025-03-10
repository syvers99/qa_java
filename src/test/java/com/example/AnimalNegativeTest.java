package com.example;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.List;

import static com.example.ConfigConst.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalNegativeTest {
    private final String animalKind;
    private final List<String> food;


    public AnimalNegativeTest(String animalKind, List<String> food) {
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
                {INSECT,NULL_VALUE},
                {EMPTY_VALUE,NULL_VALUE},
                {NULL_VALUE,NULL_VALUE},

        };
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
