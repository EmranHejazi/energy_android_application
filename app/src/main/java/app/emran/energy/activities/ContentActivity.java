package app.emran.energy.activities;

import static app.emran.energy.data.Constants.DEFAULT_FONT_SIZE;
import static app.emran.energy.data.Constants.PREFS_NAME;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import app.emran.energy.R;
import app.emran.energy.data.ExercisesData;
import app.emran.energy.models.Action;
import app.emran.energy.models.Exercise;

/**
 * ContentActivity displays detailed information about a specific action.
 */
public class ContentActivity extends AppCompatActivity {

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

        // Set the content view to the layout associated with the content activity
        setContentView(R.layout.activity_content);

        // Apply padding to the main view based on system bar insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get action index and exercise index from intent extras
        Intent currentIntent = getIntent();
        int indexAction = currentIntent.getIntExtra("action_index", -1);
        int indexExercise = currentIntent.getIntExtra("exercise_index", -1);
        Exercise exercise = ExercisesData.getExercises().get(indexExercise);
        Action action = exercise.getActions().get(indexAction);

        // Find views
        ImageButton backButton = findViewById(R.id.button_back);
        TextView title = findViewById(R.id.title);
        TextView content = findViewById(R.id.content);
        ImageView image = findViewById(R.id.image);

        // Get font size from shared preferences
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        float fontSize = prefs.getFloat("fontSize", DEFAULT_FONT_SIZE);

        // Set data to views
        if (action.getTitle().isPresent()) {
            title.setText(getString(action.getTitle().get()));
        } else {
            title.setText(getString(R.string.undefined_name));
        }

        if (action.getContent().isPresent()) {
            content.setTextSize(fontSize);
            content.setText(getString(action.getContent().get()));
        } else {
            content.setText(getString(R.string.undefined_name));
        }

        if (action.getImageResource().isPresent()) {
            image.setImageResource(action.getImageResource().get());
        } else {
            image.setImageResource(R.drawable.ic_no_image);
            image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }

        // Handle back button click event to finish the activity
        backButton.setOnClickListener(view -> {
            finish();
        });
    }
}