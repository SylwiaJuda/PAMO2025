package pl.pjatk.s25373;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.widget.NestedScrollView;
import pl.pjatk.s25373.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private static final String TAG = "FirstFragment";  // Tag for logging

    @Nullable
    @Override
    public NestedScrollView onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout using ViewBinding
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        // Debug log to check if onCreateView is called
        Log.d(TAG, "onCreateView is called");



        Log.d(TAG, "View created and button listener set.");
        return binding.getRoot();
    }

    void calculateBMI() {
        Log.d(TAG, "Button clicked. Proceeding with BMI calculation...");

        // Get the input values from EditText fields
        String weightStr = binding.editTextWeight.getText().toString();
        String heightStr = binding.editTextHeight.getText().toString();

        // Check if either of the fields is empty
        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            Log.e(TAG, "Input fields are empty.");
            binding.textViewResult.setText("Error: Empty fields");
            return;
        }

        try {
            // Convert the input to double values
            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr);

            // Log the input values for debugging
            Log.d(TAG, "Weight: " + weight + ", Height: " + height);

            // Get the selected unit (metric or imperial)
            int selectedId = binding.radioGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Log.e(TAG, "No unit selected.");
                binding.textViewResult.setText("Error: Select a unit");
                return;
            }

            // Determine if metric or imperial units are selected
            boolean isMetric = selectedId == R.id.rb1;
            Log.d(TAG, "Is Metric: " + isMetric);

            // Convert units if necessary
            if (isMetric) {
                height /= 100; // Convert height from cm to meters
                Log.d(TAG, "Metric selected. Height converted to meters: " + height);
            } else {
                weight *= 0.453592; // Convert weight from pounds to kilograms
                height *= 0.3048;  // Convert height from feet to meters
                Log.d(TAG, "Imperial selected. Weight converted to kg: " + weight + ", Height converted to meters: " + height);
            }

            // Check if the height and weight are valid
            if (height <= 0 || weight <= 0) {
                Log.e(TAG, "Invalid values. Height or weight is zero or negative.");
                binding.textViewResult.setText("Error: Invalid values");
                return;
            }

            // Calculate BMI
            double bmi = weight / (height * height);
            Log.d(TAG, "Calculated BMI: " + bmi);

            // Get the BMI category based on the calculated value
            String resultText = getBMIResult(bmi);

            // Display the result (BMI value and category)
            String result = String.format("BMI: %.2f\n%s", bmi, resultText);
            binding.textViewResult.setText(result);  // This is the line where the result is set

            Log.d(TAG, "BMI result displayed: " + result);

        } catch (NumberFormatException e) {
            Log.e(TAG, "Invalid input format", e);
            binding.textViewResult.setText("Error: Invalid input");
        }
    }

    // Determine the BMI category based on the BMI value
    private String getBMIResult(double bmi) {
        if (bmi < 18.5) {
            Log.d(TAG, "BMI category: Underweight");
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            Log.d(TAG, "BMI category: Normal weight");
            return "Normal weight";
        } else if (bmi >= 25 && bmi <= 29.9) {
            Log.d(TAG, "BMI category: Overweight");
            return "Overweight";
        } else {
            Log.d(TAG, "BMI category: Obese");
            return "Obese";
        }
    }

    @java.lang.Override
    public void onViewCreated(@NonNull android.view.View view, @Nullable android.os.Bundle savedInstanceState) {
        // Set up the button click listener
        binding.buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Button clicked!");
                calculateBMI();
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Avoid memory leaks
        Log.d(TAG, "View destroyed, binding set to null.");
    }
}
