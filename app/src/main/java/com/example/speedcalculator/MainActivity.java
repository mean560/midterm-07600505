package com.example.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateBotton = findViewById(R.id.calculate_button);
        calculateBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText entermeterEditText = findViewById(R.id.entermeter_EditText);
                final String meterText = entermeterEditText.getText().toString();

                final EditText entersecondEditText = findViewById(R.id.entertime_textView);
                String secondText = entersecondEditText.getText().toString();

                if(meterText.isEmpty()&&meterText.isEmpty()){
                    Toast t = Toast.makeText(MainActivity.this, R.string.toast_empty, Toast.LENGTH_LONG);
                    t.show();
                } else if(secondText.equals("")) {
                    Toast t = Toast.makeText(MainActivity.this, R.string.toast_empty, Toast.LENGTH_LONG);
                    t.show();
                } else if(secondText.equals("0")) {
                    Toast t = Toast.makeText(MainActivity.this, R.string.Toast_zero, Toast.LENGTH_LONG);
                    t.show();
                } else{
                    double meter = Double.parseDouble(meterText);
                    double second = Double.parseDouble(secondText);

                    double calAnswer = (meter*18)/(second*5);
                    String str = String.format(Locale.getDefault(), "%.2f", calAnswer);

                    final TextView showAnswer = findViewById(R.id.answer_textView);
                    showAnswer.setText(str);

                    if(calAnswer>80){
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("SPEED CALCULATOR");
                        dialog.setMessage(R.string.dialog_limit);
                        dialog.setPositiveButton("OK", null);
                        dialog.show();
                    }


                    Button clearButton = findViewById(R.id.clear_button);
                    clearButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            entermeterEditText.setText("");
                            entersecondEditText.setText("");
                            showAnswer.setText("");
                        }
                    });
                }
            }
        });
    }
}