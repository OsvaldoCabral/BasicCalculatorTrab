package io.osvaldocabral.myfirstappsqn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewTitle;
    EditText editTextName;
    EditText editTextNumber;

    //TODO: fazer interface

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTitle = findViewById(R.id.textViewTitle);

        editTextName = findViewById(R.id.editTextTextName);
        editTextName.addTextChangedListener(onTextChanged());

        editTextNumber = findViewById(R.id.editTextNumber);

        textViewTitle.setText("Olá!");

        Log.d("MainActivity", "onCreate Called");
    }

    public void buttonOlaClicked(View view) {
        setValueTextViewByEditTextView(textViewTitle, editTextName);
        Toast.makeText(MainActivity.this,
                "Bem vindo",
                Toast.LENGTH_SHORT)
                .show();
    }

    public void buttonSomarClicked(View view) {
        String aux = editTextNumber.getText().toString();
        int num = Integer.parseInt(aux);

        num++;
        editTextNumber.setText(String.valueOf(num));
    }

    public TextWatcher onTextChanged() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setValueTextViewByEditTextView(textViewTitle, editTextName);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    public void setValueTextViewByEditTextView(TextView textView, EditText editText) {
        String name = editText.getText().toString();
        textView.setText(name);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart Called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onRestart Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy Called");
    }

    //TODO: Criar função de chamar outra tela
}