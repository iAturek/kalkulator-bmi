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

        tvResultValue.setText(getString(R.string.result_value, height, weight));
    }
}