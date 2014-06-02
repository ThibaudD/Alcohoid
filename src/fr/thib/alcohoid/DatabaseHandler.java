package fr.thib.alcohoid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	public static final String TABLE_NAME = "alcohol";
	public static final String KEY = "id";
	public static final String TITLE = "title";
	public static final String TYPE = "type";
	public static final String COUNTRY = "country";
	public static final String REGION = "region";
	public static final String PRICE = "price";
	public static final String DATE = "date";
	public static final String COMMENTS = "comments";
	public static final String RATE = "rate";
	public static final String AMOUNT = "amount";
	
	public static final String TABLE_CREATE = 
			"CREATE TABLE " + TABLE_NAME + " (" + KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ TITLE + " TEXT, " + TYPE + " TEXT, " + COUNTRY + " TEXT, " + REGION + " TEXT, "
			+ PRICE + " REAL, " + DATE + " TEXT, " + COMMENTS + " TEXT, " + RATE + " REAL, "
			+ AMOUNT + " INTEGER );";
	
	public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
	 
	  public DatabaseHandler(Context context, String name, CursorFactory factory, int version) {
	    super(context, name, factory, version);
	  }
	 
	  @Override
	  public void onCreate(SQLiteDatabase db) {
	    db.execSQL(TABLE_CREATE);
	  }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(DROP_TABLE);
		onCreate(db);
		
	}
}
