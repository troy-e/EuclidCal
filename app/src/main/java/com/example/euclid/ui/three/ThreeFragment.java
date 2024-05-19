package com.example.euclid.ui.three;

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

public class ThreeFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_three);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // Set the adapter
        recyclerView.setAdapter(new ShapeAdapter(get3DShapes(), getContext()));
        return view;
    }

    private List<Shape> get3DShapes() {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Shape("Sphere"));
        shapes.add(new Shape("Cube"));
        shapes.add(new Shape("Cylinder"));
        // Add more 3D shapes as needed
        return shapes;
    }
}
