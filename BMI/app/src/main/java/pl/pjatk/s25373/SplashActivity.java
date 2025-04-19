package pl.pjatk.s25373;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 2000; // Czas trwania ekranu startowego (2 sekundy)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Przekierowanie do MainActivity po 2 sekundach
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Zamykamy SplashActivity, żeby użytkownik nie wracał do niego po kliknięciu "Wstecz"
        }, SPLASH_TIME_OUT);
    }
}
