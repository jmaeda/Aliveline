package cajac.aliveline;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alexsuk on 5/30/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    //name of table
    private static final int DATABASE_VERSION = 1;
    //name of the database file
    private static final String DATABASE_NAME = "aliveline.db";
    //Table Names
    public static final String TABLE_PRODUCTS = "Todos";
    public static final String TABLE_DATES = "Dates";
    public static final String TABLE_TODO_DATES = "todo_dates";


    //Column names for Todo table
    public static final String KEY_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "desc";
    public static final String COLUMN_DUEDATE = "due_date";
    public static final String COLUMN_ESTIMATEDTIME = "est_time";
    public static final String COLUMN_TIME_USAGE = "time_usage";

    //Column names for Dates table
    public static final String COLUMN_DATES = "dates";

    //Column names for todo_dates table
    public static final String KEY_TODO_ID = "todo_id";
    public static final String KEY_DATES_ID = "dates_id";

    public static final String CREATE_TODO_TABLE = "CREATE TABLE " +  TABLE_PRODUCTS + "(" +
            KEY_ID + " INTEGER PRIMARY KEY," + COLUMN_TITLE + " TEXT, " + COLUMN_DESCRIPTION + " TEXT, " +
            COLUMN_DUEDATE + " DATETIME, " + COLUMN_ESTIMATEDTIME + " TEXT, " + COLUMN_TIME_USAGE + " TEXT" + ")";

    public static final String CREATE_DATE_TABLE = "CREATE TABLE " + TABLE_DATES + "(" + KEY_ID + " INTEGER PRIMARY KEY, "
            + COLUMN_DATES + " DATETIME" + ")";

    //What columns should be included in relaional?
    public static final String CREATE_TODO_DATES_TABLE = "CREATE TABLE " + "(" + KEY_ID + "INTEGER PRIMARY KEY, " +
            KEY_TODO_ID + "INTEGER, " + KEY_DATES_ID + "INTEGER" + ")";


    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATE_TABLE);
        db.execSQL(CREATE_TODO_TABLE);
        db.execSQL(CREATE_TODO_DATES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}