package com.example.userdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Database extends DatabaseHelper {
    public Database(@Nullable Context context) {
        super(context);
    }

    public long addUser(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("user",null,values);
    }

    /**
     * zxcsacascasdc
     * @return Cursor list of results
     */
    public Cursor getUserList() {
        SQLiteDatabase db = getReadableDatabase();
        String table = "user";
        String[] columns = {"username"};
        String selection = "";
        String[] selectionArgs = {};
        String groupBy = null;
        String having = null;
        String orderBy = "username DESC";
        String limit = "100";


        Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
        return cursor;
    }

    public int deleteUser(String username) {
        SQLiteDatabase db = getWritableDatabase();
        String column = "username=?";
        String[] user = {username};

        return db.delete("user",column, user);
    }

    public int saveUser(String search, String newValue) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",newValue);
        String[] searches = {search};

        return db.update("user",values,"username=?",searches);
    }




}
