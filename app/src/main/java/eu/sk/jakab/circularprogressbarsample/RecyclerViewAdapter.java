package eu.sk.jakab.circularprogressbarsample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jakab on 7/11/2019.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_EMPTY = 0;
    private static final int TYPE_MACHINE = 1;

    private final RecyclerViewAdapterInterface callback;
    private List<Machine> items;

    public interface RecyclerViewAdapterInterface {

        void openMachine(Machine machine);
    }

    public RecyclerViewAdapter(List<Machine> machines, RecyclerViewAdapterInterface callback) {
        this.callback = callback;
        this.items = machines;
    }

    @Override
    public int getItemViewType(int position) {
        if (items==null || items.isEmpty()) {
            return TYPE_EMPTY;
        }
        return TYPE_MACHINE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case TYPE_EMPTY:
                return new EmptyViewHolder(inflater.inflate(R.layout.row_empty, parent, false));
            case TYPE_MACHINE:
                return new MachineViewHolder(inflater.inflate(R.layout.row_machine, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_MACHINE:
                Machine machine = items.get(position);
                ((MachineViewHolder) holder).bind(machine, callback);
                break;
        }
    }

    @Override
    public int getItemCount() {
        if (items==null || items.isEmpty()) {
            return 1;
        }
        return items.size();
    }

    private static class EmptyViewHolder extends RecyclerView.ViewHolder {
        EmptyViewHolder(View view) {
            super(view);
        }
    }

    private static class MachineViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private LinearLayout layout;

        public MachineViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txt_name);
            layout = itemView.findViewById(R.id.layout);
        }

        public void bind(final Machine machine, final RecyclerViewAdapterInterface callback) {
            txtName.setText(machine.getName());
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.openMachine(machine);
                }
            });
        }
    }
}
