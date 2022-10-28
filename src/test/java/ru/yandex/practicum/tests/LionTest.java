package ru.yandex.practicum.tests;

import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensStubReturnsCorrectValue() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getKittens()).thenReturn(2);
        assertEquals("A lion should have as many kittens as a feline",2, lion.getKittens());
    }

    @Test
    public void lionConstructorThrowsException() {
        Exception expectedException = new Exception("Используйте допустимые значения пола животного - самец или самка");
        try {
            Predator predator = new Feline();
            new Lion(predator, "Мясо");
        } catch (Exception actualException) {
            assertEquals("The exception message should show how to choose the sex of the lion",
                    expectedException.getMessage(), actualException.getMessage());
        }
    }

    @Test
    public void getKittensReturnsCorrectMethod() throws Exception {
        Predator predator = new Feline();
        Lion lion = new Lion(predator, "Самец");
        int expectedLionKittens = predator.getKittens();
        int actualLionKittens = lion.getKittens();
        assertEquals("A lion should have as many kittens as a predator", expectedLionKittens, actualLionKittens);
    }

    @Test
    public void doesHaveManeReturnsCorrectField() throws Exception {
        Predator predator = new Feline();
        Lion lion = new Lion(predator, "Самка");
        boolean expectedLionMane = false;
        boolean actualLionMane = lion.doesHaveMane();
        assertEquals("A lion does not have a mane by default", expectedLionMane, actualLionMane);
    }

    @Test
    public void getFoodReturnsCorrectMethod() throws Exception {
        Predator predator = new Feline();
        Lion lion = new Lion(predator, "Самец");
        List<String> expectedLionFood = predator.eatMeat();
        List<String> actualLionFood = lion.getFood();
        assertEquals("A lion should eat the same food as a predator", expectedLionFood, actualLionFood);
    }
}
