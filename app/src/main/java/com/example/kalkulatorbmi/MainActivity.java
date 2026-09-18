package com.example.kalkulatorbmi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView appTitle;

    private EditText etHeight;

    private EditText etWeight;

    private Button btSum;

    private TextView tvResultTitle;

    private TextView tvResultValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        appTitle = findViewById(R.id.appTitle);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btSum = findViewById(R.id.btSum);
        tvResultTitle = findViewById(R.id.tvResultTitle);
        tvResultValue = findViewById(R.id.tvResultValue);

        btSum.setOnClickListener(v -> sum());
    }
    private void sum(){
        String heightString = etHeight.getText().toString().trim();
        String weightString = etWeight.getText().toString().trim();

        if((heightString.isEmpty() || weightString.isEmpty()) || (!heightString.matches("\\d+") || !weightString.matches("\\d+"))){
            Toast.makeText(this, R.string.error_empty_values, Toast.LENGTH_SHORT).show();
            return;
        }

        double height = Double.parseDouble(heightString);
        int weight = Integer.parseInt(weightString);
        height = height / 100.0;

        double bmi = weight / (height * height);

        String resultText;
        if (bmi < 16.0) {
            resultText = "Wygłodzenie";
        } else if (bmi >= 16.0 && bmi < 17.0) {
            resultText = "Wychudzenie";
        } else if (bmi >= 17.0 && bmi < 18.5) {
            resultText = "Niedowaga";
        } else if (bmi >= 18.5 && bmi < 25.0) {
            resultText = "Wartość prawidłowa (Norma)";
        } else if (bmi >= 25.0 && bmi < 30.0) {
            resultText = "Nadwaga";
        } else if (bmi >= 30.0 && bmi < 35.0) {
            resultText = "Otyłość I stopnia";
        } else if (bmi >= 35.0 && bmi < 40.0) {
            resultText = "Otyłość II stopnia (kliniczna)";
        } else {
            resultText = "Otyłość III stopnia (skrajna)";
        }

        tvResultValue.setText(getString(R.string.result_value, height, weight, bmi, resultText));
    }
}