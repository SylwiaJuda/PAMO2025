package pl.pjatk.s25373;

import org.junit.Test;
import static org.junit.Assert.*;

public class FirstFragmentLogicTest {

    private double calculateBMI(double weight, double height, boolean isMetric) {
        if (isMetric) {
            height /= 100.0; // cm to meters
        } else {
            weight *= 0.453592; // pounds to kilograms
            height *= 0.3048;   // feet to meters
        }

        if (height <= 0 || weight <= 0) {
            throw new IllegalArgumentException("Invalid weight or height");
        }

        return weight / (height * height);
    }

    private String getBMIResult(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    @Test
    public void testMetricBMI() {
        double bmi = calculateBMI(70, 175, true); // 70kg, 175cm
        assertEquals(22.86, bmi, 0.01);
        assertEquals("Normal weight", getBMIResult(bmi));
    }

    @Test
    public void testImperialBMI() {
        double bmi = calculateBMI(154, 5.74, false); // 154 lbs, 5.74 feet (~175cm)
        assertEquals(22.86, bmi, 0.2); // Tolerancja konwersji
        assertEquals("Normal weight", getBMIResult(bmi));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInputThrows() {
        calculateBMI(-1, 0, true);
    }

    @Test
    public void testCategories() {
        assertEquals("Underweight", getBMIResult(17));
        assertEquals("Normal weight", getBMIResult(22));
        assertEquals("Overweight", getBMIResult(27));
        assertEquals("Obese", getBMIResult(33));
    }
}
