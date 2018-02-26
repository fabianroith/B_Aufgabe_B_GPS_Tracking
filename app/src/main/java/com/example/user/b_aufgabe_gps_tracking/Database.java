package com.example.user.b_aufgabe_gps_tracking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Sebastian on 26.02.18.
 */

public class Database extends SQLiteOpenHelper {
    private static final String TABLE_ENTRY = "entries";
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "EntriesDB";
    private static final String KEY_ID = "id";
    private static final String KEY_ENTRY = "entry";
    private static final String[] COLUMNS = {KEY_ID,KEY_ENTRY};

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create entry table
        String CREATE_BOOK_TABLE = "CREATE table entries ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "entry TEXT NOT NULL " +")";

        // create entry table
        db.execSQL(CREATE_BOOK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older entries table if existed
        db.execSQL("DROP TABLE IF EXISTS books");

        // create fresh entries table
        this.onCreate(db);
    }

    public void addEntry(String entry){
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_ENTRY, entry);

        // 3. insert
        db.insert(TABLE_ENTRY,
                null,
                values);

        // 4. close
        db.close();
    }

    public String getEntry(int id){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_ENTRY,
                        COLUMNS,
                        " id = ?",
                        new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null);

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. get entry
        String entry = cursor.getString(1);


        // 5. return entry
        return entry;
    }

    public ArrayList<String> getAllEntries() {
        ArrayList<String> entries = new ArrayList<String>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_ENTRY;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        if (cursor.moveToFirst()) {
            do {
                entries.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        // return books
        return entries;
    }

}
