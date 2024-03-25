package com.example.pr4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void Button_Listener3(View v){
        Intent intent = new Intent();
        EditText EditText3 = findViewById(R.id.EditText3);
        EditText EditText4 = findViewById(R.id.EditText4);
        intent.putExtra(SecondActivity.ACCESS, EditText3.getText().toString());
        intent.putExtra(SecondActivity.ACCESS2, EditText4.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }


}
