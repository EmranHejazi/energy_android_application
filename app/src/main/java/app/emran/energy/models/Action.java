package app.emran.energy.models;

import java.util.Optional;

/**
 * Represents an action which contains a title, an optional image resource,
 * and optional content.
 */
public class Action {
    // Optional title resource ID of the action
    private final Optional<Integer> title;
    // Optional image resource ID of the action
    private final Optional<Integer> imageResource;
    // Optional content resource ID of the action
    private final Optional<Integer> content;

    /**
     * Constructs an Action with the specified title, image resource, and content.
     *
     * @param title Optional title resource ID of the action
     * @param imageResource Optional image resource ID of the action
     * @param content Optional content resource ID of the action
     */
    public Action(Optional<Integer> title, Optional<Integer> imageResource, Optional<Integer> content) {
        this.title = title;
        this.imageResource = imageResource;
        this.content = content;
    }

    /**
     * Gets the title resource ID of the action.
     *
     * @return Optional title resource ID
     */
    public Optional<Integer> getTitle() {
        return title;
    }

    /**
     * Gets the image resource ID of the action.
     *
     * @return Optional image resource ID
     */
    public Optional<Integer> getImageResource() {
        return imageResource;
    }

    /**
     * Gets the content resource ID of the action.
     *
     * @return Optional content resource ID
     */
    public Optional<Integer> getContent() {
        return content;
    }
}