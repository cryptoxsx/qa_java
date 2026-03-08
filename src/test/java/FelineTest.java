package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FelineTest {

    private final Feline feline = new Feline();

    @Test
    public void testEatMeatReturnsPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFamilyReturnsCatFamily() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetKittensNoParamsReturnsOne() {
        int actual = feline.getKittens();
        assertEquals(1, actual);
    }

    @Test
    public void testGetKittensWithParamsReturnsPassedValue() {
        int kittensCount = 5;
        int actual = feline.getKittens(kittensCount);
        assertEquals(kittensCount, actual);
    }

    @Test
    public void testEatMeatOverridesAnimalMethod() throws Exception {
        Animal spyAnimal = spy(new Feline());
        Feline felineSpy = (Feline) spyAnimal;
        felineSpy.eatMeat();
        verify(spyAnimal).getFood("Хищник");
    }
}