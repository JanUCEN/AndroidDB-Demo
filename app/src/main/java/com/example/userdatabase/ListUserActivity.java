package com.example.userdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ListUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        TableLayout container = findViewById(R.id.userTableLayout);

        Database db = new Database(getApplicationContext());
        Cursor userList = db.getUserList();
        userList.moveToFirst();

        do {
            TableRow row = new TableRow(this);

            String name = userList.getString(0);
            TextView textBox = new TextView(this);
            textBox.setText(name);
            textBox.setMinWidth(200);
            Button editBtn = new Button(this);
            editBtn.setText("Edit");
            editBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ListUserActivity.this, EditUserActivity.class);
                    intent.putExtra("name",name);
                    startActivity(intent);
                }
            });



            Button deleteBtn = new Button(this);
            deleteBtn.setText("Delete");
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int success = db.deleteUser(name);
                    if(success!=-1) {

                    }
                }
            });

            row.addView(textBox);
            row.addView(editBtn);
            row.addView(deleteBtn);


            container.addView(row);

        } while(userList.moveToNext());



        Button backBtn = findViewById(R.id.listUsersBackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListUserActivity.this,MainActivity.class));
            }
        });



    }
}