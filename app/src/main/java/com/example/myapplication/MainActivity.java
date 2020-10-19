package com.example.myapplication;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         button = (Button) findViewById(R.id.btnCalculateBMI);
         myButtonListenerMethod();
    }

    public void myButtonListenerMethod() {

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
          // code those will be run when the button‟s clicked
                final EditText heightText = (EditText)
                        findViewById(R.id.etHeight);
                String heightStr = heightText.getText().toString();
                double height = Double.parseDouble(heightStr);
                final EditText weightText = (EditText)
                        findViewById(R.id.etWeight);
                String weightStr = weightText.getText().toString();
                double weight = Double.parseDouble(weightStr);
                double BMI = (weight)/(height*height);
                final EditText BMIResult = (EditText)
                        findViewById(R.id.etShowBmi);
                BMIResult.setText(Double.toString(BMI));
                String BMI_Cat;
                if (BMI < 15)
                    BMI_Cat = "Very severely underweight";
                else if (BMI < 16)
                    BMI_Cat = "Severely underweight";
                else if (BMI < 18.5)
                    BMI_Cat = "Underweight";
                else if (BMI < 25)
                    BMI_Cat = "Normal";
                else if (BMI < 30)
                    BMI_Cat = "Overweight";
                else if (BMI < 35)
                    BMI_Cat = "Obese Class 1 – Moderately Obese";
                else if (BMI < 40)
                    BMI_Cat = "Obese Class 2 - Severely Obese";
                else
                    BMI_Cat = "Obese Class 3 - Very Severely Obese";
                final TextView BMICategory = (TextView)
                        findViewById(R.id.BMI_Cat);
                BMICategory.setText(BMI_Cat);
            }
        });
    }
}