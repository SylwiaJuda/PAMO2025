package pl.pjatk.s25373;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import pl.pjatk.s25373.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        // Ustawienie opcji w Spinnerze
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.activity_levels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerActivity.setAdapter(adapter);

        // Obsługa kliknięcia przycisku
        binding.buttonCalculateCalories.setOnClickListener(v -> calculateCalories());

        return binding.getRoot();
    }

    private void calculateCalories() {
        String ageStr = binding.editTextAge.getText().toString();
        String weightStr = binding.editTextWeight.getText().toString();
        String heightStr = binding.editTextHeight.getText().toString();

        if (ageStr.isEmpty() || weightStr.isEmpty() || heightStr.isEmpty()) {
            binding.textViewResult.setText("Wypełnij wszystkie pola!");
            return;
        }

        try {
            int age = Integer.parseInt(ageStr);
            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr);

            boolean isMale = ((RadioButton) binding.radioGroupGender.findViewById(R.id.radioButtonMale)).isChecked();

            // Wzór Benedicta-Harrisa
            double bmr;
            if (isMale) {
                bmr = 88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age);
            } else {
                bmr = 447.6 + (9.2 * weight) + (3.1 * height) - (4.3 * age);
            }

            // Pobranie poziomu aktywności fizycznej
            double activityFactor = getActivityFactor(binding.spinnerActivity.getSelectedItemPosition());

            double dailyCalories = bmr * activityFactor;
            binding.textViewResult.setText(String.format("Dzienne zapotrzebowanie: %.2f kcal", dailyCalories));

        } catch (NumberFormatException e) {
            binding.textViewResult.setText("Nieprawidłowe dane!");
        }
    }

    private double getActivityFactor(int position) {
        switch (position) {
            case 0: return 1.2;  // Siedzący tryb życia
            case 1: return 1.375; // Lekka aktywność
            case 2: return 1.55;  // Średnia aktywność
            case 3: return 1.725; // Duża aktywność
            case 4: return 1.9;   // Bardzo duża aktywność
            default: return 1.2;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Uniknięcie wycieków pamięci
    }
}
