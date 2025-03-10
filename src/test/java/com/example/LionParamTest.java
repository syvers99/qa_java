package com.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static com.example.ConfigConst.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionParamTest {
    private final String sex;
    private final String nonSuitableSex;
    public LionParamTest(String sex, String nonSuitableSex) {
        this.sex = sex;
        this.nonSuitableSex = nonSuitableSex;

    }

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {MALE,EMPTY_VALUE},
                {FEMALE,NULL_VALUE}
        };
    }
    Feline feline = mock(Feline.class, CALLS_REAL_METHODS);
    Lion lion;
    @Before
    public void setUp () throws Exception {
        lion = Mockito.spy(new Lion(sex, feline));}


    @Test
    public void doesHaveManeTest() {
        if (sex.equals(MALE)) {
            assertTrue(lion.doesHaveMane());
        } else {
            assertFalse(lion.doesHaveMane());
        }
        Mockito.verify(lion, Mockito.times(1)).doesHaveMane();
    }



    @Test
    public void constructorTest()  {
        Exception exception = assertThrows(Exception.class, () -> new Lion(nonSuitableSex, feline));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(MANE_EXCEPTION_MESSAGE));
    }
}
