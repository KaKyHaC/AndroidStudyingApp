package com.example.dima.studyingapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.text_view);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == button) {
            String text = editText.getText().toString();
            textView.setText(text);
        }
    }
}