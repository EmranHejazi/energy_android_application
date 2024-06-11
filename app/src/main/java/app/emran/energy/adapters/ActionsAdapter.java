package app.emran.energy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.emran.energy.R;
import app.emran.energy.models.Action;

/**
 * Adapter for displaying a list of actions in a RecyclerView.
 */
public class ActionsAdapter extends RecyclerView.Adapter<ActionsAdapter.ViewHolder> {

    // List of actions to display
    private final List<Action> actionsList;
    // Listener for handling action item clicks
    private final OnActionClickListener onActionClickListener;

    /**
     * Constructs an ActionsAdapter with the specified list of actions and click listener.
     *
     * @param actionsList           List of actions to display
     * @param onActionClickListener Listener for handling action item clicks
     */
    public ActionsAdapter(List<Action> actionsList, OnActionClickListener onActionClickListener) {
        this.actionsList = actionsList;
        this.onActionClickListener = onActionClickListener;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_action, parent, false);
        return new ViewHolder(view, onActionClickListener);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the item at the given position
     * @param position The position of the item within the adapter's data set
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Action action = actionsList.get(position);

        // Set action title if available, otherwise set default text
        if (action.getTitle().isPresent()) {
            holder.textViewName.setText(action.getTitle().get());
        } else {
            holder.textViewName.setText(R.string.undefined_name);
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter
     */
    @Override
    public int getItemCount() {
        return actionsList.size();
    }

    /**
     * ViewHolder class that represents each action item.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName;
        OnActionClickListener onActionClickListener;

        /**
         * Constructs a ViewHolder.
         *
         * @param itemView              The View representing the action item
         * @param onActionClickListener Listener for handling action item clicks
         */
        public ViewHolder(@NonNull View itemView, OnActionClickListener onActionClickListener) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_action_name);
            this.onActionClickListener = onActionClickListener;
            itemView.setOnClickListener(this);
        }

        /**
         * Handles click events for the action item.
         *
         * @param v The View that was clicked
         */
        @Override
        public void onClick(View v) {
            onActionClickListener.onActionClick(getAdapterPosition());
        }
    }

    /**
     * Interface for handling clicks on action items.
     */
    public interface OnActionClickListener {
        void onActionClick(int position);
    }
}