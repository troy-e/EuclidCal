package com.example.euclid.ui.two;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.euclid.R;
import com.example.euclid.Shape.Shape;
import com.example.euclid.ShapeAdapter;

import java.util.ArrayList;
import java.util.List;

public class TwoFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_two);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // Set the adapter
        recyclerView.setAdapter(new ShapeAdapter(get2DShapes(), getContext()));
        return view;
    }

    private List<Shape> get2DShapes() {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Shape("Circle"));
        shapes.add(new Shape("Square"));
        shapes.add(new Shape("Rectangle"));
        shapes.add(new Shape("Triangle"));
        shapes.add(new Shape("Parallelogram"));
        shapes.add(new Shape("Trapezoid"));
        // Add more 2D shapes as needed
        return shapes;
    }
}
