package com.preccydev.journalapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.preccydev.journalapp.data.JournalContract.COLUMN_JOURNAL;
import static com.preccydev.journalapp.data.JournalContract.COLUMN_NOTE;
import static com.preccydev.journalapp.data.JournalContract.TABLE_NAME;
import static com.preccydev.journalapp.data.JournalContract._ID;

public class JournalDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "journal";
    public static final int DATABASE_VERSION = 1;

    public JournalDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createDb = "CREATE TABLE " + TABLE_NAME + " ( " +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_JOURNAL + " TEXT NOT NULL, " +
                COLUMN_NOTE + " TEXT NOT NULL );";
        sqLiteDatabase.execSQL(createDb);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);


    }
}
