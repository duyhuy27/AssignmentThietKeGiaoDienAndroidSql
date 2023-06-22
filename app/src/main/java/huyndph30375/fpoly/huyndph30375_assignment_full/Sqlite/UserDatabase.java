package huyndph30375.fpoly.huyndph30375_assignment_full.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDatabase extends SQLiteOpenHelper {
    public static final String databaseName = "SignUp.db";

    public UserDatabase(@Nullable Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table allusers(email TEXT primary key, password TEXT, name TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop Table if exists allusers");
    }

    public Boolean insertData(String email, String password, String name){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("name", name);

        long result = database.insert("allusers", null, contentValues);
        if (result == -1){
            return  false;
        }
        else {
            return true;
        }
    }
    public Boolean checkEmail(String email){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from allusers where email = ?", new String[] {email});
        if (cursor.getCount() > 0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from allusers where email = ? and password = ? ", new String[] {email, password});
        if (cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }
}
