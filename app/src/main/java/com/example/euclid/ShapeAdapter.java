package com.example.euclid;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.euclid.Shape.Shape;

import java.util.List;

public class ShapeAdapter extends RecyclerView.Adapter<ShapeAdapter.ShapeViewHolder> {

    private List<Shape> shapes;
    private Context context;

    public ShapeAdapter(List<Shape> shapes, Context context) {
        this.shapes = shapes;
        this.context = context;
    }

    @NonNull
    @Override
    public ShapeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shape_item, parent, false);
        return new ShapeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShapeViewHolder holder, int position) {
        Shape shape = shapes.get(position);
        holder.shapeName.setText(shape.getName());

        // Set the appropriate image for the shape in the list
        switch (shape.getName()) {
            case "Circle":
                holder.shapeImage.setImageResource(R.drawable.circle); // Replace with your drawable resource
                break;
            case "Square":
                holder.shapeImage.setImageResource(R.drawable.square); // Replace with your drawable resource
                break;
            case "Rectangle":
                holder.shapeImage.setImageResource(R.drawable.rectangle); // Replace with your drawable resource
                break;
            case "Triangle":
                holder.shapeImage.setImageResource(R.drawable.triangle); // Replace with your drawable resource
                break;
            case "Parallelogram":
                holder.shapeImage.setImageResource(R.drawable.parallelogam); // Replace with your drawable resource
                break;
            case "Trapezoid":
                holder.shapeImage.setImageResource(R.drawable.trapezoid); // Replace with your drawable resource
                break;

            //*******************3D SHAPES GOES HERE******************************
            case "Sphere":
                holder.shapeImage.setImageResource(R.drawable.sphere); // Replace with your drawable resource
                break;
            case "Cube":
                holder.shapeImage.setImageResource(R.drawable.cube); // Replace with your drawable resource
                break;
            case "Cylinder":
                holder.shapeImage.setImageResource(R.drawable.cylinder); // Replace with your drawable resource
                break;
            case "Prism":
                holder.shapeImage.setImageResource(R.drawable.hexprism); // Replace with your drawable resource
                break;
            case "Pyramid":
                holder.shapeImage.setImageResource(R.drawable.pyramid); // Replace with your drawable resource
                break;
            case "Cuboid":
                holder.shapeImage.setImageResource(R.drawable.cuboid); // Replace with your drawable resource
                break;
            // Add more cases for other shapes if needed
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalculationDialog(shape);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shapes.size();
    }

    public static class ShapeViewHolder extends RecyclerView.ViewHolder {
        TextView shapeName;
        ImageView shapeImage;

        public ShapeViewHolder(@NonNull View itemView) {
            super(itemView);
            shapeName = itemView.findViewById(R.id.shape_name);
            shapeImage = itemView.findViewById(R.id.shape_image_list);
        }
    }

    private void showCalculationDialog(Shape shape) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.dialog_calculate, null);
        builder.setView(dialogView);

        EditText input1 = dialogView.findViewById(R.id.input1);
        EditText input2 = dialogView.findViewById(R.id.input2);
        EditText input3 = dialogView.findViewById(R.id.input3);
        TextView result = dialogView.findViewById(R.id.result);
        Button backButton = dialogView.findViewById(R.id.back_button);
        ImageView shapeImage = dialogView.findViewById(R.id.shape_image);

        // Set the appropriate image for the shape in the dialog
        switch (shape.getName()) {
            case "Circle":
                input2.setVisibility(View.GONE);
                input3.setVisibility(View.GONE);
                shapeImage.setImageResource(R.drawable.circle); // Replace with your drawable resource
                break;
            case "Square":
                input2.setVisibility(View.GONE);
                input3.setVisibility(View.GONE);
                shapeImage.setImageResource(R.drawable.square); // Replace with your drawable resource
                break;
            case "Rectangle":
                input2.setVisibility(View.VISIBLE);
                input3.setVisibility(View.GONE);
                shapeImage.setImageResource(R.drawable.rectangle); // Replace with your drawable resource
                break;
            case "Trapezoid":
                input2.setVisibility(View.VISIBLE);
                input3.setVisibility(View.VISIBLE);
                shapeImage.setImageResource(R.drawable.trapezoid); // Replace with your drawable resource
                break;
            case "Parallelogram":
                input2.setVisibility(View.VISIBLE);
                input3.setVisibility(View.GONE);
                shapeImage.setImageResource(R.drawable.parallelogam); // Replace with your drawable resource
                break;
            case "Triangle":
                input2.setVisibility(View.VISIBLE);
                input3.setVisibility(View.VISIBLE);
                shapeImage.setImageResource(R.drawable.triangle); // Replace with your drawable resource
                break;


            //**************************3D SHAPE GOES HERE!!!
            case "Sphere":
                input2.setVisibility(View.GONE);
                input3.setVisibility(View.GONE);
                shapeImage.setImageResource(R.drawable.sphere); // Replace with your drawable resource
                break;
            case "Cube":
                input2.setVisibility(View.GONE);
                input3.setVisibility(View.GONE);
                shapeImage.setImageResource(R.drawable.cube); // Replace with your drawable resource
                break;
            case "Prism":
                input2.setVisibility(View.VISIBLE);
                input3.setVisibility(View.GONE);
                shapeImage.setImageResource(R.drawable.hexprism); // Replace with your drawable resource
                break;
            case "Cuboid":
                input2.setVisibility(View.VISIBLE);
                input3.setVisibility(View.VISIBLE);
                shapeImage.setImageResource(R.drawable.cuboid); // Replace with your drawable resource
                break;
            case "Pyramid":
                input2.setVisibility(View.VISIBLE);
                input3.setVisibility(View.GONE);
                shapeImage.setImageResource(R.drawable.pyramid); // Replace with your drawable resource
                break;
            case "Cylinder":
                input2.setVisibility(View.VISIBLE);
                input3.setVisibility(View.GONE);
                shapeImage.setImageResource(R.drawable.cylinder); // Replace with your drawable resource
                break;
            // Add more cases for other shapes if needed
        }

        AlertDialog dialog = builder.create();

        dialogView.findViewById(R.id.calculate_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double value1 = Double.parseDouble(input1.getText().toString());
                    double value2 = input2.getVisibility() == View.VISIBLE ? Double.parseDouble(input2.getText().toString()) : 0;
                    double value3 = input3.getVisibility() == View.VISIBLE ? Double.parseDouble(input2.getText().toString()) : 0;
                    double area = 0;

                    switch (shape.getName()) {
                        case "Circle":
                            area = Math.PI * value1 * value1;
                            break;
                        case "Square":
                            area = value1 * value1;
                            break;
                        case "Rectangle":
                            area = value1 * value2;
                            break;
                        case "Triangle":
                            area = 0.5 * value1 * value2; // Assuming value1 is base and value2 is height
                            break;
                        case "Trapezoid":
                            area = 0.5 * (value1 + value2) * value3; // Assuming value1 is base1, value2 is base2, and value3 is height
                            break;
                        case "Parallelogram":
                            area = value1 * value2;
                            break;
                        //*************3D SHAPE GOES HERE
                        case "Cuboid":
                            area = value1 * value2 * value3;
                            break;
                        case "Cube":
                            area = value1 * value1 * value1;
                            break;
                        case "Prism":
                            area = value1 * value2;
                            break;
                        case "Pyramid":
                            area = 0.33 * value1 * value2;
                            break;
                        case "Cylinder":
                            area = Math.PI * value1 * value1 * value2;
                            break;
                        case "Sphere":
                            area = 1.33 * Math.PI * value1 * value1 * value1;
                            break;

                    }

                    String formattedResult = String.format("%.2f", area);
                    result.setText("Area: " + formattedResult);
                } catch (NumberFormatException e) {
                    Toast.makeText(context, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

        // Set dialog to full-screen
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.setStatusBarColor(context.getResources().getColor(android.R.color.transparent));
            }
        }
    }
}
