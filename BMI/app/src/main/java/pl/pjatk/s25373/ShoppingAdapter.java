package pl.pjatk.s25373;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ViewHolder> {
    private List<ShoppingItem> shoppingList;

    public ShoppingAdapter(List<ShoppingItem> shoppingList) {
        this.shoppingList = shoppingList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShoppingItem item = shoppingList.get(position);
        holder.checkBox.setText(item.getName());
        holder.checkBox.setChecked(item.isChecked());
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> item.setChecked(isChecked));
    }

    @Override
    public int getItemCount() {
        return shoppingList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.shopping_checkbox);
        }
    }
}