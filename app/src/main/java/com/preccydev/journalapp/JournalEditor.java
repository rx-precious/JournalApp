package com.preccydev.journalapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.preccydev.journalapp.data.JournalDbHelper;

import static com.preccydev.journalapp.data.JournalContract.COLUMN_JOURNAL;
import static com.preccydev.journalapp.data.JournalContract.COLUMN_NOTE;
import static com.preccydev.journalapp.data.JournalContract.TABLE_NAME;

public class JournalEditor extends AppCompatActivity {

    private EditText mJournal, mNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_editor);

        mJournal = findViewById(R.id.journal_editor);
        mNote = findViewById(R.id.note_editor);
    }

    public void insertData() {
        String Journal = mJournal.getText().toString().trim();
        String Note = mNote.getText().toString().trim();


        if (Journal.length() > 0 || Note.length() > 0) {
            //Initialize Database
            JournalDbHelper directoryDbHelper = new JournalDbHelper(this);
            SQLiteDatabase db = directoryDbHelper.getWritableDatabase();

            //Add to Database using Content Values

            ContentValues values = new ContentValues();
            values.put(COLUMN_JOURNAL, Journal);
            values.put(COLUMN_NOTE, Note);


            db.insert(TABLE_NAME, null, values);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.entry_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.save:
                // insert entry
                insertData();
                finish();
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
