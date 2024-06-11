package app.emran.energy.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import app.emran.energy.R;
import app.emran.energy.adapters.ExercisesAdapter;
import app.emran.energy.data.ExercisesData;

/**
 * MainActivity displays a list of exercises and provides navigation to settings and about pages.
 */
public class MainActivity extends AppCompatActivity {

    // RecyclerView to display exercises
    RecyclerView exerciseRecyclerView;
    // Adapter for the exercises RecyclerView
    ExercisesAdapter exerciseAdapter;

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

        // Set the content view to the layout associated with the main activity
        setContentView(R.layout.activity_main);

        // Define views
        DrawerLayout drawerLayoutMenu = findViewById(R.id.drawer_layout);
        ImageButton buttonOpenDrawer = findViewById(R.id.button_menu);
        LinearLayout menuItemSettings = findViewById(R.id.menu_item_settings);
        LinearLayout menuItemAbout = findViewById(R.id.menu_item_about);

        // Apply padding to the main view based on system bar insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set onClick action for the menu button to open/close the drawer
        buttonOpenDrawer.setOnClickListener(view -> {
            if (drawerLayoutMenu.isDrawerOpen(findViewById(R.id.navigation_drawer))) {
                drawerLayoutMenu.closeDrawer(findViewById(R.id.navigation_drawer));
            } else {
                drawerLayoutMenu.openDrawer(findViewById(R.id.navigation_drawer));
            }
        });

        // Set onClick action for the settings menu item to navigate to the SettingsActivity
        menuItemSettings.setOnClickListener(view -> {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        });

        // Set onClick action for the about menu item to navigate to the AboutActivity
        menuItemAbout.setOnClickListener(view -> {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        });

        // Initialize RecyclerView
        exerciseRecyclerView = findViewById(R.id.recycler_view_exercises);
        exerciseRecyclerView.setHasFixedSize(true); // Improve performance assuming fixed size

        // Create and set adapter for the RecyclerView
        exerciseAdapter = new ExercisesAdapter(ExercisesData.getExercises(), position -> {
            // On click of an exercise, navigate to the ActionsActivity
            Intent intent = new Intent(this, ActionsActivity.class);
            intent.putExtra("exercise_index", position); // Pass the selected exercise index
            startActivity(intent);
        });

        // Set the adapter and layout manager for the RecyclerView
        exerciseRecyclerView.setAdapter(exerciseAdapter);
        exerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}