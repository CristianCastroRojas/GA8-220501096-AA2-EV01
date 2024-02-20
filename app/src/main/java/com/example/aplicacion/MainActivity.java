package com.example.aplicacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        textViewResult = findViewById(R.id.textViewResult);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        Button buttonReset = findViewById(R.id.buttonReset);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    private void calculate() {
        try {
            int number1 = Integer.parseInt(editTextNumber1.getText().toString());
            int number2 = Integer.parseInt(editTextNumber2.getText().toString());

            int sum = number1 + number2;
            int subtraction = number1 - number2;
            int multiplication = number1 * number2;
            double division = (double) number1 / number2;

            textViewResult.setText("Suma: " + sum + "\n"
                    + "Resta: " + subtraction + "\n"
                    + "Multiplicación: " + multiplication + "\n"
                    + "División: " + division);
        } catch (NumberFormatException e) {
            textViewResult.setText("Por favor, ingrese números válidos.");
        } catch (ArithmeticException e) {
            textViewResult.setText("No se puede dividir entre cero.");
        }
    }

    private void reset() {
        editTextNumber1.setText("");
        editTextNumber2.setText("");
        textViewResult.setText("");
    }
}
