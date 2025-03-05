package com.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static com.example.ConfigMap.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParamTest {
    private final String sex;
    private final String non_suitableSex;
    public LionParamTest(String sex, String non_suitableSex) {
        this.sex = sex;
        this.non_suitableSex = non_suitableSex;

    }

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @Spy
    Feline feline;


    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {MALE,EMPTY_VALUE},
                {FEMALE,NULL_VALUE}
        };
    }
    Lion lion;
    @Before
    public void setUp () throws Exception {
        lion = new Lion(sex, feline);}


    @Test
    public void doesHaveManeTest() {
        if (sex.equals(MALE)) {
            assertTrue(lion.doesHaveMane());
        } else {
            assertFalse(lion.doesHaveMane());
        }
    }



    @Test
    public void constructorTest()  {
        Exception exception = assertThrows(Exception.class, () -> new Lion(non_suitableSex, feline));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(MANE_EXCEPTION_MESSAGE));
    }
}
