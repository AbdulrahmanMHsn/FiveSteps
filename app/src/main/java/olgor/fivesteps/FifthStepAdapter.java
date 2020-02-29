package olgor.fivesteps;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FifthStepAdapter extends RecyclerView.Adapter<FifthStepAdapter.ViewHolder> {
    private ArrayList<String> list = new ArrayList<>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final String fruit = list.get(position);
        holder.fruitName.setText(fruit);

        holder.delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,list.size());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList<String> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView fruitName;
        Button delButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitName = itemView.findViewById(R.id.fruitName);
            delButton = itemView.findViewById(R.id.delButton);
        }
    }
}
