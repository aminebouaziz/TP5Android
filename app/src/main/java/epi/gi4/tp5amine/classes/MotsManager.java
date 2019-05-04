package epi.gi4.tp5amine.classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class MotsManager {
    private SQLiteDatabase database;

    private MotDbHelper mHelper;

    public MotsManager(Context context) {
        mHelper =  new MotDbHelper(context,"JeuMots.db",null,1);
    }
    public void open() throws SQLException{
        database =mHelper.getWritableDatabase();
    }

    public void close() throws  SQLException{
        database.close();
    }

    public long insertWord(Mot mot){
        ContentValues values = new ContentValues();
        values.put(MotDbHelper.COL1,mot.getLeMot());
        values.put(MotDbHelper.COL2,mot.getTaille());
        values.put(MotDbHelper.COL3,mot.getType());
        values.put(MotDbHelper.COL3,mot.getGenre());
        return database.insert(MotDbHelper.MA_TABLE,null,values);
    }

    public int updateWorld(String leMot,Mot motToupdate){
        ContentValues values = new ContentValues();
        values.put(MotDbHelper.COL1,motToupdate.getLeMot());

        return database.update(MotDbHelper.MA_TABLE,values,MotDbHelper.COL1+" LIKE "+leMot,null);
    }
    public int removeContactByMot(String mot){
        return database.delete(MotDbHelper.MA_TABLE,MotDbHelper.COL1+" LIKE "+mot,null);
    }
}
