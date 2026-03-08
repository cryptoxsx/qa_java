package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;
    private Lion lion;

    @Test
    public void testLionMaleHasMane() throws Exception {
        lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionFemaleNoMane() throws Exception {
        lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы"));
        lion = new Lion("Самец", feline);
        assertEquals(List.of("Животные", "Птицы"), lion.getFood());
        verify(feline).eatMeat();
    }

    @Test
    public void testGetKittens() throws Exception {
        when(feline.getKittens()).thenReturn(3);
        lion = new Lion("Самец", feline);
        assertEquals(3, lion.getKittens());
        verify(feline).getKittens();
    }

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        new Lion("Неверный", feline);
    }
}