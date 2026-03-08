package com.example;

import org.junit.Test;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterizedFelineTest {

    private final Feline feline = new Feline();
    private int inputKittens;
    private int expectedKittens;

    public ParameterizedFelineTest(int inputKittens, int expectedKittens) {
        this.inputKittens = inputKittens;
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getKittensData() {
        return Arrays.asList(new Object[][]{
                {0, 0}, {1, 1}, {3, 3}, {10, 10}
        });
    }

    @Test
    public void testGetKittensWithParamsReturnsPassedValue() {
        int actual = feline.getKittens(inputKittens);
        assertEquals(expectedKittens, actual);
    }
}
