package com.example.first_android;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textMain;
    private TextView textResult;
    private char op;
    private int n1;
    private int n2;
    private float res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textMain = findViewById(R.id.textMain);
        textResult = findViewById(R.id.textResult);
        op='n';
        n1 = 0;
        n2 = 0;
        res = 0;

    }

    public void handleClickDel(View view) {
        if(!textMain.getText().toString().isEmpty()) {
            String str = textMain.getText().toString().substring(0, textMain.getText().toString().length() - 1);
            textMain.setText(str);
        }
    }

    public void handleClick(View view) {
        Button btn = (Button) view;
        textMain.setText(textMain.getText().toString() + btn.getText().toString());
    }

    public void handleClickOperation(View view) {
        Button btn = (Button) view;
        if(!textMain.getText().toString().isEmpty() && op == 'n') {
            op = btn.getText().toString().charAt(0);
            n1 = Integer.parseInt(textMain.getText().toString());
            textResult.setText(textMain.getText().toString() + " " + op);
            textMain.setText("");
        }
    }

    public void handleClickSum(View view) {
        Button btn = (Button) view;
        if(!textMain.getText().toString().isEmpty() && op != 'n') {
            n2 = Integer.parseInt(textMain.getText().toString());
            switch (op) {
                case '/':
                    res = (float)n1/n2;
                    break;
                case '*':
                    res = (float)n1*n2;
                    break;
                case '-':
                    res = (float)n1-n2;
                    break;
                case '+':
                    res = (float)n1+n2;
                    break;
            }

            textResult.setText(textResult.getText().toString() + " " + n2 + " = " + res);
            textMain.setText("");
            op = 'n';
        }
    }

    public void handleClickClean(View view) {
        textMain.setText("");
        textResult.setText("");
        op='n';
    }

}