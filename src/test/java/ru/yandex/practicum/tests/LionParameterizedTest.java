package ru.yandex.practicum.tests;

import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String lionGender;
    private final boolean expectedHasMane;

    public LionParameterizedTest(String lionGender, boolean expectedHasMane) {
        this.lionGender = lionGender;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {

        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void lionConstructorInitializesManeField() throws Exception {
            Predator predator = new Feline();
            Lion lion = new Lion(predator, lionGender);
            boolean actualHasMane = lion.doesHaveMane();
            assertEquals("The mane presence should be set by the sex of the lion",
                    expectedHasMane, actualHasMane);
    }
}
