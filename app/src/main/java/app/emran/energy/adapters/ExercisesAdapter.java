package app.emran.energy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.emran.energy.R;
import app.emran.energy.models.Exercise;

/**
 * Adapter for displaying a list of exercises in a RecyclerView.
 */
public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ViewHolder> {

    // List of exercises to display
    private final List<Exercise> exerciseList;
    // Listener for handling exercise item clicks
    private final OnExerciseClickListener onExerciseClickListener;

    /**
     * Constructs an ExercisesAdapter with the specified list of exercises and click listener.
     *
     * @param exerciseList            List of exercises to display
     * @param onExerciseClickListener Listener for handling exercise item clicks
     */
    public ExercisesAdapter(List<Exercise> exerciseList, OnExerciseClickListener onExerciseClickListener) {
        this.exerciseList = exerciseList;
        this.onExerciseClickListener = onExerciseClickListener;
    }

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to represent an item.
     *
     * @param parent   The ViewGroup into which the new View will be added
     * @param viewType The view type of the new View
     * @return A new ViewHolder that holds a View of the given view type
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_exercises, parent, false);
        return new ViewHolder(view, onExerciseClickListener);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the item at the given position
     * @param position The position of the item within the adapter's data set
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Exercise exercise = exerciseList.get(position);
        // Set background gradient direction based on position
        if (position % 2 == 0) {
            // Even position, gradient from left to right
            holder.itemView.setBackgroundResource(R.drawable.gradient_left_to_right);
        } else {
            // Odd position, gradient from right to left and change the direction to RTL
            holder.itemView.setBackgroundResource(R.drawable.gradient_right_to_left);
            holder.itemView.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }

        // Set exercise name if available, otherwise set default text
        if (exercise.getName().isPresent()) {
            holder.textViewName.setText(exercise.getName().get());
        } else {
            holder.textViewName.setText(R.string.undefined_name);
        }

        // Set exercise image if available, otherwise set default image
        if (exercise.getImageResource().isPresent()) {
            holder.imageViewExercise.setImageResource(exercise.getImageResource().get());
        } else {
            holder.imageViewExercise.setImageResource(R.drawable.ic_no_image);
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter
     */
    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    /**
     * ViewHolder class that represents each exercise item.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName;
        ImageView imageViewExercise;
        OnExerciseClickListener onExerciseClickListener;

        /**
         * Constructs a ViewHolder.
         *
         * @param itemView                The View representing the exercise item
         * @param onExerciseClickListener Listener for handling exercise item clicks
         */
        public ViewHolder(@NonNull View itemView, OnExerciseClickListener onExerciseClickListener) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_exercise_name);
            imageViewExercise = itemView.findViewById(R.id.image_view_exercise);
            this.onExerciseClickListener = onExerciseClickListener;
            itemView.setOnClickListener(this);
        }

        /**
         * Handles click events for the exercise item.
         *
         * @param v The View that was clicked
         */
        @Override
        public void onClick(View v) {
            onExerciseClickListener.onExerciseClick(getAdapterPosition());
        }
    }

    /**
     * Interface for handling clicks on exercise items.
     */
    public interface OnExerciseClickListener {
        void onExerciseClick(int position);
    }
}