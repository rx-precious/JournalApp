package com.preccydev.journalapp.data;

import android.provider.BaseColumns;

public class JournalContract implements BaseColumns {
    public static final String TABLE_NAME = "journal";
    public static final String _ID = BaseColumns._ID;
    public static final String COLUMN_JOURNAL = "journalTitle";
    public static final String COLUMN_NOTE = "journalNote";


}
