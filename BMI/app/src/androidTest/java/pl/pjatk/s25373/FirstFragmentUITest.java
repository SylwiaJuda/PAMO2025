package pl.pjatk.s25373;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class FirstFragmentUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testBMICalculation_DisplaysCorrectResult() {
        // Wpisanie wartości
        onView(withId(R.id.editTextWeight)).perform(typeText("70"), closeSoftKeyboard());
        onView(withId(R.id.editTextHeight)).perform(typeText("175"), closeSoftKeyboard());

        // Zaznaczenie opcji "Metric"
        onView(withId(R.id.rb1)).perform(click());

        // Kliknięcie przycisku
        onView(withId(R.id.buttonCalculate)).perform(click());

        // Sprawdzenie, czy wynik zawiera "BMI"
        onView(withId(R.id.textViewResult)).check(matches(withSubstring("BMI")));
    }
}
