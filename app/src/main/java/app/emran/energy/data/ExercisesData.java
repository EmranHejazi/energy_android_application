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

        // Add exercises with associated actions
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
                Optional.of(R.drawable.image_action_barbell_up_chest_press),
                Optional.of(R.string.action_content_barbell_up_chest_press)
        ));
        exercises.get(0).getActions().add(new Action(
                Optional.of(R.string.action_title_dumbbell_chest_press),
                Optional.of(R.drawable.image_action_dumbbell_chest_press),
                Optional.of(R.string.action_content_dumbbell_chest_press)
        ));
        exercises.get(0).getActions().add(new Action(
                Optional.of(R.string.action_title_fly_device),
                Optional.of(R.drawable.image_action_fly_device),
                Optional.of(R.string.action_content_fly_device)
        ));

        // Add actions for arms exercise
        exercises.get(1).getActions().add(new Action(
                Optional.of(R.string.action_title_triceps_cable_pushdown),
                Optional.of(R.drawable.image_action_triceps_cable_pushdown),
                Optional.of(R.string.action_content_triceps_cable_pushdown)
        ));
        exercises.get(1).getActions().add(new Action(
                Optional.of(R.string.action_title_triceps_bar_press),
                Optional.of(R.drawable.image_action_triceps_bar_press),
                Optional.of(R.string.action_content_triceps_bar_press)
        ));
        exercises.get(1).getActions().add(new Action(
                Optional.of(R.string.action_title_biceps_preacher_curl),
                Optional.of(R.drawable.image_action_biceps_preacher_curl),
                Optional.of(R.string.action_content_biceps_preacher_curl)
        ));
        exercises.get(1).getActions().add(new Action(
                Optional.of(R.string.action_title_biceps_cable_curl),
                Optional.of(R.drawable.image_action_biceps_cable_curl),
                Optional.of(R.string.action_content_biceps_cable_curl)
        ));

        // Add actions for legs exercise
        exercises.get(2).getActions().add(new Action(
                Optional.of(R.string.action_title_leg_extension),
                Optional.of(R.drawable.image_action_leg_extension),
                Optional.of(R.string.action_content_leg_extension)
        ));
        exercises.get(2).getActions().add(new Action(
                Optional.of(R.string.action_title_leg_curl),
                Optional.of(R.drawable.image_action_leg_curl),
                Optional.of(R.string.action_content_leg_curl)
        ));
        exercises.get(2).getActions().add(new Action(
                Optional.of(R.string.action_title_smith_squat),
                Optional.of(R.drawable.image_action_smith_squat),
                Optional.of(R.string.action_content_smith_squat)
        ));
        exercises.get(2).getActions().add(new Action(
                Optional.of(R.string.action_title_calf_raise_machine),
                Optional.of(R.drawable.image_action_calf_raise_machine),
                Optional.of(R.string.action_content_calf_raise_machine)
        ));

        return exercises;
    }
}