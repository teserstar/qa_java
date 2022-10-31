package ru.yandex.practicum.tests;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Feline feline;

    @Test
    public void getFoodCallsWithCorrectParameter() throws Exception {
        feline.getFood("Хищник");
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void eatMeatReturnsCorrectMethod() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFelineFood = feline.getFood("Хищник");
        List<String> actualFelineFood = feline.eatMeat();
        assertEquals("The feline should eat the predator food", expectedFelineFood, actualFelineFood);
    }

    @Test
    public void getFamilyReturnsCorrectValue() {
        Feline feline = new Feline();
        String expectedFamilyType = "Кошачьи";
        String actualFamilyType = feline.getFamily();
        assertEquals("The feline type does not match the expected result", expectedFamilyType, actualFamilyType);
    }

    @Test
    public void getKittensCallsWithCorrectParameter() {
        feline.getKittens(1);
        Mockito.verify(feline).getKittens(1);
    }

    @Test
    public void getKittensReturnsCorrectMethod() {
        Feline feline = new Feline();
        int expectedFelineKittens = feline.getKittens(1);
        int actualFelineKittens = feline.getKittens();
        assertEquals("A feline should have only one kitten", expectedFelineKittens, actualFelineKittens);
    }
}
