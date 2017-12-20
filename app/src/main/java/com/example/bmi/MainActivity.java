package com.example.bmi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result,addtionalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.textViewResult);
        result.setText("");

        addtionalResult = (TextView) findViewById(R.id.textViewResult2);
        addtionalResult.setText("");

    }

    public void calculate(View view){
        float heightVal,weightVal,bmi;

        EditText height = (EditText) findViewById(R.id.editTextHeight);
        EditText weight = (EditText)findViewById(R.id.editTextWeight);

        result =(TextView) findViewById(R.id.textViewResult);
        addtionalResult =(TextView) findViewById(R.id.textViewResult2);


        heightVal= Float.parseFloat(height.getText().toString());
        weightVal= Float.parseFloat(weight.getText().toString());


        if(heightVal==0||weightVal==0){
            result.setText("Error");
            addtionalResult.setText("");
        }
        else {
            bmi = weightVal/(heightVal*heightVal);
            result.setText(String.format("%.02f",bmi));

            if(bmi<16)
                addtionalResult.setText("Severe Thinness");
            else if(bmi<17)
                addtionalResult.setText("Moderate Thinness");
            else if(bmi<18.5)
                addtionalResult.setText("Mild Thinness");
            else if(bmi<25)
                addtionalResult.setText("Normal");
            else if(bmi<30)
                addtionalResult.setText("Overweight");
            else if(bmi<35)
                addtionalResult.setText("Obese Class I");
            else if(bmi<40)
                addtionalResult.setText("Obese Class II");
            else if(bmi>17)
                addtionalResult.setText("Obese Class III");
        }
    }

}
