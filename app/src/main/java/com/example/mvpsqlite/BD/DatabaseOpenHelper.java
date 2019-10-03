package com.example.mvpsqlite.BD;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "BDPRUEBA";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USER = "usuarios";

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios(_id integer primary key autoincrement, "
                +"nombre text not null, login not null, clave text not null)");
        db.execSQL("insert into usuarios(nombre, login, clave) values('David Reyna', 'dreyna', '123')");
        db.execSQL("insert into usuarios(nombre, login, clave) values('Vasti Reyna', 'vasti', '321')");
        db.execSQL("insert into usuarios(nombre, login, clave) values('Cesia Reyna', 'cesia', '456')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }
}
