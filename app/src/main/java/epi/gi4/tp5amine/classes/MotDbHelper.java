package epi.gi4.tp5amine.classes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MotDbHelper extends SQLiteOpenHelper {

    public static final  String MA_TABLE = "mot";
    public static final  String COL1= "leMot";
    public static final  String COL2= "taille";
    public static final  String COL3="type";
    public static final  String COL4="genre";
    public static final  String CREATION="CREATE TABLE "+MA_TABLE+"("+COL1+" VARCHAR(20) ,"+COL2+" INTEGER,"+COL3+" VARCHAR(20),"+COL4+" VARCHAR(20));";

    public MotDbHelper(Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+MA_TABLE+";");
        onCreate(db);
    }
}
