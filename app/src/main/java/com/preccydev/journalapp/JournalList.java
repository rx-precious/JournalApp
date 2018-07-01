package com.preccydev.journalapp;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JournalList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_list);
        Snackbar.make(findViewById(R.id.layout), "Authentication Successful.", Snackbar.LENGTH_SHORT).show();
    }
}
