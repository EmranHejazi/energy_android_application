package app.emran.energy.activities;

import static app.emran.energy.data.Constants.DEFAULT_FONT_SIZE;
import static app.emran.energy.data.Constants.PREFS_NAME;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import app.emran.energy.R;

/**
 * AboutActivity displays information about the application.
 */
public class AboutActivity extends AppCompatActivity {

    /**
     * Called when the activity is starting. This is where most initialization should go.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied
     */
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display with dark system bar styles
        EdgeToEdge.enable(this, SystemBarStyle.dark(Color.TRANSPARENT), SystemBarStyle.dark(Color.TRANSPARENT));

        // Set the content view to the layout associated with the about activity
        setContentView(R.layout.activity_about);

        // Apply padding to the main view based on system bar insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get font size from shared preferences
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        float fontSize = prefs.getFloat("fontSize", DEFAULT_FONT_SIZE);

        // Find views
        ImageButton backButton = findViewById(R.id.button_back);
        TextView content = findViewById(R.id.text_about);

        // Set text size based on font size preference
        content.setTextSize(fontSize);

        // Handle back button click event to finish the activity
        backButton.setOnClickListener(view -> {
            finish();
        });
    }
}