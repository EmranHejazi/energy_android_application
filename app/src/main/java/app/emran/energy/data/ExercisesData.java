package app.emran.energy.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import app.emran.energy.R;
import app.emran.energy.models.Action;
import app.emran.energy.models.Exercise;

/**
 * Provides data for exercises, including a list of exercises and their associated actions.
 */
public class ExercisesData {

    /**
     * Retrieves a list of exercises with their associated actions.
     *
     * @return List of exercises
     */
    public static List<Exercise> getExercises() {
        // Initialize the list of exercises
        List<Exercise> exercises = new ArrayList<>();

        // Add exercise with associated actions
        exercises.add(new Exercise(
                Optional.of(R.string.exercise_name_chest),
                Optional.of(R.drawable.image_exercise_chest),
                new ArrayList<>()
        ));
        exercises.add(new Exercise(
                Optional.of(R.string.exercise_name_arms),
                Optional.of(R.drawable.image_exercise_arms),
                new ArrayList<>()
        ));
        exercises.add(new Exercise(
                Optional.of(R.string.exercise_name_legs),
                Optional.of(R.drawable.image_exercise_legs),
                new ArrayList<>()
        ));

        // Add actions for chest exercise
        exercises.get(0).getActions().add(new Action(
                Optional.of(R.string.action_title_barbell_chest_press),
                Optional.of(R.drawable.image_action_barbell_chest_press),
                Optional.of(R.string.action_content_barbell_chest_press)
        ));
        exercises.get(0).getActions().add(new Action(
                Optional.of(R.string.action_title_barbell_up_chest_press),
                Optional.empty(),
                Optional.empty()
        ));
        exercises.get(0).getActions().add(new Action(
                Optional.of(R.string.action_title_dumbbell_chest_press),
                Optional.empty(),
                Optional.empty()
        ));
        exercises.get(0).getActions().add(new Action(
                Optional.of(R.string.action_title_fly_device),
                Optional.empty(),
                Optional.empty()
        ));

        return exercises;
    }
}