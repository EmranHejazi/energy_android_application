package app.emran.energy.models;

import java.util.List;
import java.util.Optional;

/**
 * Represents an exercise which contains a name, an optional image resource,
 * and a list of associated actions.
 */
public class Exercise {
    // Optional name resource ID of the exercise
    private final Optional<Integer> name;
    // Optional image resource ID of the exercise
    private final Optional<Integer> imageResource;
    // List of actions associated with the exercise
    private final List<Action> actions;

    /**
     * Constructs an Exercise with the specified name, image resource, and actions.
     *
     * @param name          Optional name resource ID of the exercise
     * @param imageResource Optional image resource ID of the exercise
     * @param actions       List of actions associated with the exercise
     */
    public Exercise(Optional<Integer> name, Optional<Integer> imageResource, List<Action> actions) {
        this.name = name;
        this.imageResource = imageResource;
        this.actions = actions;
    }

    /**
     * Gets the name resource ID of the exercise.
     *
     * @return Optional name resource ID
     */
    public Optional<Integer> getName() {
        return name;
    }

    /**
     * Gets the image resource ID of the exercise.
     *
     * @return Optional image resource ID
     */
    public Optional<Integer> getImageResource() {
        return imageResource;
    }

    /**
     * Gets the list of actions associated with the exercise.
     *
     * @return List of actions
     */
    public List<Action> getActions() {
        return actions;
    }
}