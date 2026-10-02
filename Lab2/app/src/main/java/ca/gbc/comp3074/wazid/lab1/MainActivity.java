package ca.gbc.comp3074.wazid.lab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewCounter;

    private int counter = 0;
    private int step = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCounter = findViewById(R.id.textViewCounter);

        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonReset = findViewById(R.id.buttonReset);
        Button buttonStep = findViewById(R.id.buttonStep);

        // Add button
        buttonAdd.setOnClickListener(v -> {
            counter = counter + step;
            textViewCounter.setText(String.valueOf(counter));
        });

        // Subtract button
        buttonSubtract.setOnClickListener(v -> {
            counter = counter - step;
            textViewCounter.setText(String.valueOf(counter));
        });

        // Reset button
        buttonReset.setOnClickListener(v -> {
            counter = 0;
            step = 1;
            textViewCounter.setText(String.valueOf(counter));
        });

        // Step button
        buttonStep.setOnClickListener(v -> {
            if (step == 1) {
                step = 2;
            } else {
                step = 1;
            }
        });
    }
}