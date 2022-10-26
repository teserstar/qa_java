package ru.yandex.practicum.tests;

import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {

    @Test
    public void getSoundReturnsCorrectValue() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String expectedCatSound = "Мяу";
        String actualCatSound = cat.getSound();
        assertEquals("The cat sound does not match the expected result", expectedCatSound, actualCatSound);
    }

    @Test
    public void getFoodReturnsCorrectMethod() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        Predator predator = new Feline();
        List<String> expectedCatFood = predator.eatMeat();
        List<String> actualCatFood = cat.getFood();
        assertEquals("A cat must eat the same food as a predator", expectedCatFood, actualCatFood);
    }
}
