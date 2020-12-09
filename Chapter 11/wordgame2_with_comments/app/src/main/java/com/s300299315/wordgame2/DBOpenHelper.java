package com.s300299315.wordgame2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String TAG = DBOpenHelper.class.getSimpleName();

    //3) Setting the DATABASE_NAME & DATABASE_VERSION & TABLE_NAME
    //3-1) has to be 1 first time or app will crush & named
    private static final int DATABASE_VERSION =1;
    private static final String TABLE = "word_table";
    private static final String  DATABASE_NAME = "word_database";


    //3-2) Design Columns' name in the DB (first column: `_id`, second column: `word`)
    public static final String KEY_ID = "_id";
    public static final String KEY_WORD = "word";

    //3-3) Put the all columns in the array
    private static final String[] COLUMNS = {KEY_ID, KEY_WORD};

    //3-4) Statement to create the table
    private static final String WORD_LIST_TABLE_CREATE =
            "CREATE TABLE " + TABLE + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY, " +
                    // id will auto-increment if no value passed
                    KEY_WORD + " TEXT );";


    //2) Define the `Super Constructor` by myself
    public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //4) Add instance variables for the references to writable and readable databases. Storing these
    //references saves you to work of getting a database reference every time you need to read or
    //write.
    private SQLiteDatabase mWritableDB;
    private SQLiteDatabase mReadableDB;


    //1) Add implementation method within SQLiteOpenHelper
    @Override //Callback function. so When DBOpenHelper is created, the `onCreate` method is called
    public void onCreate(SQLiteDatabase db) {
        //5) Initialize Database & create database table
        db.execSQL(WORD_LIST_TABLE_CREATE);
        //6) Add method for fill the data in the database
        fillDatabaseWithData(db);

    }

    @Override //Callback function
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //11)Drop the table and add new table
        db.execSQL("DROP TABLE IF EXISTS " +TABLE);
        onCreate(db);
    }

    //7) Design Method for fill the data in the DB
    private void fillDatabaseWithData(SQLiteDatabase db) {
        //8) Set the string data which is initialized what I like to want to save in the DB using a array
        String [] words = {"Android", "Adapter", "ListView", "AsyncTask",
                "Android Studio", "SQLiteDatabase", "SQLOpenHelper",
                "Data model", "ViewHolder", "Android Performance",
                "OnClickListener"};

        //9) Create a container to put the data into our table using is something Key-value pairs
        ContentValues values = new ContentValues();

        for(int i=0; i<words.length; i++) {
            //put the Column / Value pairs in the the container
            //put() overrides existing values
            values.put(KEY_WORD,words[i]); // key-value pairs functions .put() & .get()
            // When i = 0; values.put("word", "Android")
            // When i = 1; values.put("word", "Adapter")
            //10) Insert data in to the table
            db.insert(TABLE,null,values);
        }
    }

    //12) Query statement to get the data from database
    // method name "query" return the Word class
    public Word query(int position) {
        //12-1)return a single Word which is located in the `position`
        String query = "SELECT * FROM " + TABLE + " ORDER BY " + KEY_WORD + " ASC" + " LIMIT " + position + ",1";

        //12-2) cursor response to the record
        Cursor cursor = null;

        //12-3) Initialize new Word Object
        Word entry = new Word();
        try {
            if(mReadableDB==null) {
                mReadableDB = getReadableDatabase();
            }
            //12-4) execute query
            cursor = mReadableDB.rawQuery(query,null);
            cursor.moveToFirst();

            //12-5)
            //set the first column & second column value in the Object using a cursor getInt & getString
            entry.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
            entry.setWord(cursor.getString(cursor.getColumnIndex(KEY_WORD)));

        }catch (Exception e) {
            Log.d(TAG, "Exception! " + e);
        } finally {
            //12-6)
            cursor.close();
            return entry;
        }
    }

    //13) Second query statement to get the all data from database(How to query multiple records)
    public ArrayList<Word> query() {
        String query = "SELECT  * FROM " + TABLE +
                " ORDER BY " + KEY_WORD + " ASC ";
        Cursor cursor = null;

        ArrayList<Word> allWords = new ArrayList<Word>();

        try {
            if (mReadableDB == null) {
                mReadableDB = getReadableDatabase();
            }
            cursor = mReadableDB.rawQuery(query, null);
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                Word entry = new Word();
                entry.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                entry.setWord(cursor.getString(cursor.getColumnIndex(KEY_WORD)));
                allWords.add(entry);
                cursor.moveToNext();
            }
        } catch (Exception e) {
            Log.d(TAG, "EXCEPTION! " + e);
        } finally {
            cursor.close();
            return allWords;
        }
    }

    //14) Insert data into database
    //Create the insert() method with the following signature. The user supplies a word, and the
    //method returns the id for the new entry. Generated id's can be big, so insert returns a
    //number of type long.
    public long insert(Word word){
        long newId = 0;

        // create content values container to save the data which going to be saved in database
        ContentValues values = new ContentValues();
        values.put(KEY_WORD, word.getWord());

        try {
            if (mWritableDB == null) {
                mWritableDB = getWritableDatabase();
            }
            //every time insert the value, it will give you new Id which is a `first column`
            newId = mWritableDB.insert(TABLE, null, values);
        } catch (Exception e) {
            Log.d(TAG, "INSERT EXCEPTION! " + e.getMessage());
        }
        return newId;
    }

    //15) Delete data in the database
    //You use the delete() method on SQLiteDatabase to delete an entry in the database
    public int delete(int id) {
        int deleted = 0;
        try {
            if (mWritableDB == null) {
                mWritableDB = getWritableDatabase();
            }
            deleted = mWritableDB.delete(TABLE, //table name
                    KEY_ID + " =? ", new String[]{String.valueOf(id)});
        } catch (Exception e) {
            Log.d (TAG, "DELETE EXCEPTION! " + e.getMessage());
        }
        return deleted;
    }

    //16) Total number of data in table
    public long count(){
        if (mReadableDB == null) {
            mReadableDB = getReadableDatabase();
        }
        return DatabaseUtils.queryNumEntries(mReadableDB, TABLE);
    }
}
