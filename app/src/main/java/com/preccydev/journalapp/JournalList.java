package com.preccydev.journalapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.preccydev.journalapp.data.JournalDbHelper;
import com.preccydev.journalapp.model.JournalAdapter;

import static com.preccydev.journalapp.data.JournalContract.TABLE_NAME;
import static com.preccydev.journalapp.data.JournalContract._ID;

public class JournalList extends AppCompatActivity implements JournalAdapter.JournalItemClickListener {

    JournalAdapter mAdapter;
    RecyclerView mDirectoryList;
    SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_list);
        mDirectoryList = findViewById(R.id.all_journal_list_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mDirectoryList.setLayoutManager(layoutManager);
        mDirectoryList.setHasFixedSize(true);

        JournalDbHelper directoryDbHelper = new JournalDbHelper(this);

        mDb = directoryDbHelper.getReadableDatabase();

        Cursor cursor = getAllDirectory();

        mAdapter = new JournalAdapter(this, cursor, this);
        mAdapter = new JournalAdapter(this, cursor);

        mDirectoryList.setAdapter(mAdapter);


        // Setup FAB to open EditorActivity
        FloatingActionButton fab = findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JournalList.this, JournalEditor.class);
                startActivity(intent);


            }
        });
    }


    public Cursor getAllDirectory() {
        return mDb.query(
                TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                _ID);
    }

    @Override
    public void onJournalItemClick(int ClickedItemIndex) {

    }
}
