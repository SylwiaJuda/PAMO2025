package pl.pjatk.s25373;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ShoppingFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.shopping_recycler);

        List<ShoppingItem> items = new ArrayList<>();
        items.add(new ShoppingItem("Banana"));
        items.add(new ShoppingItem("Yogurt"));
        items.add(new ShoppingItem("Oats"));
        items.add(new ShoppingItem("Honey"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ShoppingAdapter(items));

        return view;
    }
}