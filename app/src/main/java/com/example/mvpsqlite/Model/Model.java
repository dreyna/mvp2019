package com.example.mvpsqlite.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mvpsqlite.BD.DatabaseOpenHelper;
import com.example.mvpsqlite.View.IView;

import java.util.ArrayList;
import java.util.List;

public class Model implements IModel{

    private SQLiteDatabase database;
    public Model(IView iView) {
        database = new DatabaseOpenHelper((Context) iView).getWritableDatabase();
    }
    @Override
    public List<String> getListFromDatabase() {
        List<String> list = new ArrayList<>();
        String sqlQueryText = "SELECT nombre, login, clave FROM usuarios";
        Cursor cursor = this.database.rawQuery(sqlQueryText, null);
        while (cursor.moveToNext()) {
            list.add(cursor.getString(0)+"  "+cursor.getString(1)+"  "+cursor.getString(2));
        }
        return list;
    }
}
