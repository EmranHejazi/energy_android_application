package app.emran.energy.activities;

import static app.emran.energy.data.Constants.DEFAULT_FONT_SIZE;
import static app.emran.energy.data.Constants.PREFS_NAME;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import app.emran.energy.R;

/**
 * SettingsActivity allows the user to adjust application settings such as font size.
 */
public class SettingsActivity extends AppCompatActivity {

    /**
     * Called when the activity is starting. This is where most initialization should go.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display with dark system bar styles
        EdgeToEdge.enable(this, SystemBarStyle.dark(Color.TRANSPARENT), SystemBarStyle.dark(Color.TRANSPARENT));

        // Set the content view to the layout associated with the settings activity
        setContentView(R.layout.activity_settings);

        // Apply padding to the main view based on system bar insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find views
        SeekBar fontSizeSeekBar = findViewById(R.id.seek_bar_font_size);
        ImageButton backButton = findViewById(R.id.button_back);

        // Load the current font size value from SharedPreferences
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        float fontSize = prefs.getFloat("fontSize", DEFAULT_FONT_SIZE); // Provide a default font size if not found
        fontSizeSeekBar.setProgress((int) fontSize); // Set the progress of the SeekBar to the retrieved value

        // Set up a listener for changes in the SeekBar
        fontSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update font size based on SeekBar progress
                // Save the updated font size to SharedPreferences
                SharedPreferences.Editor editor = prefs.edit();
                editor.putFloat("fontSize", (float) progress);
                editor.apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Not needed for this example
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Not needed for this example
            }
        });

        // Handle back button click event to finish the activity
        backButton.setOnClickListener(view -> {
            finish();
        });
    }
}