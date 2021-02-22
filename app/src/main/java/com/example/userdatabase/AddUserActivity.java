package com.example.userdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddUserActivity extends AppCompatActivity {
    EditText username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        username = findViewById(R.id.usernameInput);

        Button backBtn = findViewById(R.id.addUserBackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddUserActivity.this,MainActivity.class));
            }
        });



        Button btn = findViewById(R.id.saveUserButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameValue = username.getText().toString();
                ContentValues values = new ContentValues();
                values.put("username", userNameValue);

                Database db = new Database(getApplicationContext());
                long success = db.addUser(values);
                if(success==-1) {
                }
//                startActivity(new Intent(AddUserActivity.this,ListUserActivity.class));
            }
        });

    }
}