package com.example.adil.taskmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Adil on 26-Sep-15.
 */
public class SecurityScreen extends Activity{

    private EditText passwordText;
    private Button secureLoginButton;
    private TextView passswordValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.security);
        setUpViews();
    }

    private void setUpViews() {

        passwordText = (EditText)findViewById(R.id.passwordText);
        secureLoginButton =(Button) findViewById(R.id.secureLoginButton);
        passswordValue = (TextView)findViewById(R.id.text);
        secureLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passwordText.getText().toString().contentEquals("A")){
                    Intent intent = new Intent(SecurityScreen.this,TasksSelectActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{

                    passswordValue.setText(passwordText.getText().toString() + ": Sorry" +
                            "That\'s not the pass key");
                }


            }
        });
    }


}
