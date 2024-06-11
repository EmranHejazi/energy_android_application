package app.emran.energy.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import app.emran.energy.R;
import app.emran.energy.adapters.ActionsAdapter;
import app.emran.energy.data.ExercisesData;
import app.emran.energy.models.Exercise;

/**
 * ActionsActivity displays a list of actions for a specific exercise.
 */
public class ActionsActivity extends AppCompatActivity {

    // RecyclerView to display actions
    RecyclerView actionsRecyclerView;
    // Adapter for the actions RecyclerView
    ActionsAdapter actionsAdapter;

    /**
     * Called when the activity is starting. This is where most initialization should go.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied
     */
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display with dark system bar styles
        EdgeToEdge.enable(this, SystemBarStyle.dark(Color.TRANSPARENT), SystemBarStyle.dark(Color.TRANSPARENT));

        // Set the content view to the layout associated with the actions activity
        setContentView(R.layout.activity_actions);

        // Apply padding to the main view based on system bar insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get exercise index from intent extra
        Intent currentIntent = getIntent();
        int indexExercise = currentIntent.getIntExtra("exercise_index", -1);
        Exercise exercise = ExercisesData.getExercises().get(indexExercise);

        // Find views
        ImageButton backButton = findViewById(R.id.button_back);
        TextView title = findViewById(R.id.title);

        // Set title with exercise name
        if (exercise.getName().isPresent())
            title.setText(getString(R.string.title_activity_actions) + " " + getString(exercise.getName().get()));
        else
            title.setText(getString(R.string.undefined_name));

        // Initialize RecyclerView
        actionsRecyclerView = findViewById(R.id.recycler_view_actions);
        actionsRecyclerView.setHasFixedSize(true); // Assuming fixed size for better performance

        // Create and set adapter for the RecyclerView
        actionsAdapter = new ActionsAdapter(exercise.getActions(), position -> {
            // On click of an action, navigate to the ContentActivity
            Intent intent = new Intent(this, ContentActivity.class);
            intent.putExtra("action_index", position);
            intent.putExtra("exercise_index", indexExercise);
            startActivity(intent);
        });
        actionsRecyclerView.setAdapter(actionsAdapter);
        actionsRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // Set layout manager

        // Handle back button click event to finish the activity
        backButton.setOnClickListener(view -> {
            finish();
        });
    }
}