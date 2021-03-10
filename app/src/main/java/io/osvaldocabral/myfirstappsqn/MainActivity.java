package io.osvaldocabral.myfirstappsqn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber1;
    EditText editTextNumber2;

    Button buttonSum;
    Button buttonSubtract;
    Button buttonMultiplic;
    Button buttonDivided;

    TextView textViewResult;

    int valor1;
    int valor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);

        editTextNumber1.addTextChangedListener(onTextChanged());
        editTextNumber2.addTextChangedListener(onTextChanged());

        buttonSum = findViewById(R.id.buttonSum);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiplic = findViewById(R.id.buttonMultiplic);
        buttonDivided = findViewById(R.id.buttonDivided);

        textViewResult = findViewById(R.id.textViewResult);

    }

    public Integer getIntegerValue(EditText editText) {
        String util = editText.getText().toString();
        if(util.isEmpty()) return 0;
        return Integer.parseInt(util);
    }

    public void fillValues() {
        valor1 = getIntegerValue(editTextNumber1);
        valor2 = getIntegerValue(editTextNumber2);
    }

    public TextWatcher onTextChanged() {
        return new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                fillValues();
            }
        };
    }

    public void fillResult(int result) {
        textViewResult.setText("Result: " + String.valueOf(result));
    }

    public void buttonSumClicked(View view) {
        int sum = valor1 + valor2;
        fillResult(sum);
    }

    public void setButtonSubtractClicked(View view) {
        int sum = valor1 - valor2;
        fillResult(sum);
    }

    public void buttonMultiplicClicked(View view) {
        int sum = valor1 * valor2;
        fillResult(sum);
    }

    public void buttonDividedClicked(View view) {
        if(valor2 != 0) {
            Toast.makeText(MainActivity.this, "A divisão é infinita!", Toast.LENGTH_SHORT).show();
            return;
        }
        int sum = valor1 / valor2;
        fillResult(sum);
    }

}