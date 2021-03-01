package com.example.userdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        String name = getIntent().getStringExtra("name");
        Database db = new Database(this);

        Button save = findViewById(R.id.saveUserButton);
        Button back = findViewById(R.id.addUserBackBtn);
        EditText text = findViewById(R.id.usernameInput);

        text.setText(name);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = text.getText().toString();


                int success = db.saveUser(name,newName);
            }
        });




    }
}