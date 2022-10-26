package ru.yandex.practicum.tests;

import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {

    private final String lionGender;
    private final boolean expectedHasMane;

    public LionTest(String lionGender, boolean expectedHasMane) {
        this.lionGender = lionGender;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {

        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"Мясо", false}
        };
    }

    @Test
    public void lionConstructorInitializesManeField() throws Exception {
        Exception expectedException = new Exception("Используйте допустимые значения пола животного - самец или самка");
        try {
            Lion lion = new Lion(lionGender);
            boolean actualHasMane = lion.doesHaveMane();
            assertEquals("The mane presence should be set by the sex of the lion",
                    expectedHasMane, actualHasMane);
        } catch (Exception actualException) {
            assertEquals("The exception message should show how to choose the sex of the lion",
                    expectedException.getMessage(), actualException.getMessage());
        }

    }

    @Test
    public void getKittensReturnsCorrectMethod() {
        Predator predator = new Feline();
        Lion lion = new Lion(predator);
        int expectedLionKittens = predator.getKittens();
        int actualLionKittens = lion.getKittens();
        assertEquals("A lion should have as many kittens as a predator", expectedLionKittens, actualLionKittens);
    }

    @Test
    public void doesHaveManeReturnsCorrectField() {
        Predator predator = new Feline();
        Lion lion = new Lion(predator);
        boolean expectedLionMane = false;
        boolean actualLionMane = lion.doesHaveMane();
        assertEquals("A lion does not have a mane by default", expectedLionMane, actualLionMane);
    }

    @Test
    public void getFoodReturnsCorrectMethod() throws Exception {
        Predator predator = new Feline();
        Lion lion = new Lion(predator);
        List<String> expectedLionFood = predator.eatMeat();
        List<String> actualLionFood = lion.getFood();
        assertEquals("A lion should eat the same food as a predator", expectedLionFood, actualLionFood);
    }
}
