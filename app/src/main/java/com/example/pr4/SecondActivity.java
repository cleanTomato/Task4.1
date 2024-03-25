package com.example.pr4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;



public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle arguments = getIntent().getExtras();
        if (arguments != null){
            TextView editText2 = findViewById(R.id.EditText2);
            String name = arguments.get("name_tag").toString();
            editText2.setText(name);
        }

    }
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult
            (new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == Activity.RESULT_OK) {
                                Intent intent = result.getData();
                                String dateMessage = intent.getStringExtra(ACCESS);
                                String commentMessage = intent.getStringExtra(ACCESS2);
                                Toast.makeText(getApplicationContext(), dateMessage, Toast.LENGTH_LONG).show();
                                Toast.makeText(getApplicationContext(), commentMessage, Toast.LENGTH_LONG).show();

                            }
                        }
                    });
    public void Button_Listener2(View v){
        Intent intent = new Intent(this, ThirdActivity.class);
        mStartForResult.launch(intent);
    }

    static final String ACCESS = "KEY";
    static final String ACCESS2 = "KEY2";

}
