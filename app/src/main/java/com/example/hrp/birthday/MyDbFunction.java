package com.example.hrp.birthday;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hrp on 11/25/2017.
 */

public class MyDbFunction extends SQLiteOpenHelper {

    private static final String DB_NAME = "Birthday";
    private static final String DB_TABLE = "BD_TB";


    private static final String TAB_ID = "id";
    private static final String TAB_NAME = "name";
    private static final String TAB_BIRTHDAY = "days";

    MyDbFunction(Context C){
        super(C, DB_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String s = "CREATE TABLE "+DB_TABLE+" ("+TAB_ID+" INTEGER PRIMARY KEY ,"+TAB_NAME+" TEXT,"+TAB_BIRTHDAY+" TEXT )";
        db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
     /* /-------Add data to database in SQL ------------- */
     void addingDataToTable(DataTemp dt ) {
            SQLiteDatabase sqldb = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put(TAB_NAME, dt.getName());
            contentValues.put(TAB_BIRTHDAY, dt.getBirthday());

            sqldb.insert(DB_TABLE,null,contentValues);
            sqldb.close();
     }


    String[] myData(){
        SQLiteDatabase sq = this.getReadableDatabase();
        String q = "SELECT * FROM "+DB_TABLE;
        Cursor c = sq.rawQuery(q,null);

        String[] resive_data = new String[c.getCount()];

        c.moveToFirst();
        if (c.moveToFirst()) {
            int counter = 0;
            do {
                resive_data[counter] = c.getString(c.getColumnIndex(TAB_NAME+"")) +"\n Birthday "+ c.getString(c.getColumnIndex(TAB_BIRTHDAY+""));
                counter += 1;
            } while (c.moveToNext());
        }
        return resive_data;
     }
}
