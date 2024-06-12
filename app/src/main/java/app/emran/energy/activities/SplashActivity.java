package app.emran.energy.activities;

import static app.emran.energy.data.Constants.SPLASH_SCREEN_DELAY;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import app.emran.energy.R;

/**
 * SplashActivity shows a splash screen for a specified duration and then navigates to the MainActivity.
 */
@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    /**
     * Called when the activity is starting. This is where most initialization should go.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display
        EdgeToEdge.enable(this);

        // Set the content view to the layout associated with the splash screen
        setContentView(R.layout.activity_splash);

        // Apply padding to the main view based on system bar insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Hide both the status bar and bottom navigation bar for full-screen experience
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN);

        // Find the views
        ImageView imageView = findViewById(R.id.logo);
        TextView textView = findViewById(R.id.app_name);

        // Load the animations
        Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);

        // Start the animations
        imageView.startAnimation(alpha);
        textView.startAnimation(alpha);

        // Simulate a splash screen delay using a Handler
        new Handler().postDelayed(() -> {
            // After the delay, navigate to the MainActivity
            Intent mainActivityIntent = new Intent(this, MainActivity.class); // Create an Intent to launch MainActivity
            startActivity(mainActivityIntent); // Start the MainActivity
            finish(); // Close the SplashActivity after launching the main one
        }, SPLASH_SCREEN_DELAY);
    }
}