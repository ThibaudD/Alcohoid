package fr.thib.alcohoid;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class AlcoholDAO extends DAOBase{
	public AlcoholDAO(Context pContext) {
		super(pContext);
		// TODO Auto-generated constructor stub
	}

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
	
	public void AddAlcohol(Alcohol a){
		ContentValues value = new ContentValues();
		value.put(TITLE, a.getTitle());
		value.put(TYPE, a.getType());
		value.put(COUNTRY, a.getCountry());
		value.put(REGION, a.getRegion());
		value.put(PRICE, a.getPrice());
		value.put(DATE, a.getDate());
		value.put(COMMENTS, a.getComments());
		value.put(RATE, a.getRate());
		value.put(AMOUNT, a.getAmount());
		
		mDb.insert(TABLE_NAME, null, value);
		
		a.setId(getLastId());
		
	}
	
	public void DeleteAlcohol(long id){
		mDb.delete(TABLE_NAME, KEY + " = ?", new String[] {String.valueOf(id)});
	}
	
	public void DeleteAlcoholAll(){
		//mDb.delete(TABLE_NAME, AMOUNT + " = ?", new String[] {String.valueOf(4)});
		mDb.delete(TABLE_NAME, null, null);
	}
	 
	public void UpdateAlcohol(Alcohol a){
		ContentValues value = new ContentValues();
		value.put(TITLE, a.getTitle());
		value.put(TYPE, a.getType());
		value.put(COUNTRY, a.getCountry());
		value.put(REGION, a.getRegion());
		value.put(PRICE, a.getPrice());
		value.put(DATE, a.getDate());
		value.put(COMMENTS, a.getComments());
		value.put(RATE, a.getRate());
		value.put(AMOUNT, a.getAmount());
		
		mDb.update(TABLE_NAME, value, KEY  + " = ?", new String[] {String.valueOf(a.getId())});
		
	}
	
	public Alcohol Select(long id){
		Cursor c = mDb.rawQuery("select " + TITLE + " from " + TABLE_NAME + "where id = "+ id, null);
		if(c.getCount()==0){
			return null;
		}
		c.moveToFirst();
		Alcohol a = cursorToAlcohol(c);
		c.close();
		return a;	

	}
	
	public ArrayList<Alcohol> SelectAll(){
		Cursor c = mDb.rawQuery("select * from " + TABLE_NAME , null);
		ArrayList<Alcohol> alcohols = new ArrayList<Alcohol>();
		Log.i("NumberROW", ""+c.getCount());
		if(c.getCount()==0){
			return alcohols;
		}
		c.moveToFirst();
		while(!c.isAfterLast()){
			Alcohol a = cursorToAlcohol(c);
			alcohols.add(a);
			c.moveToNext();
		}
		c.close();
		
		return alcohols;	

	}
	
	private Alcohol cursorToAlcohol(Cursor c){
		Alcohol a = new Alcohol();
		a.setId(c.getInt(0));
		a.setTitle(c.getString(1));
		a.setType(c.getString(2));
		a.setCountry(c.getString(3));
		a.setRegion(c.getString(4));
		a.setPrice(c.getFloat(5));
		a.setDate(c.getString(6));
		a.setComments(c.getString(7));
		a.setRate(c.getFloat(8));
		a.setAmount(c.getInt(9));
		return a;
		
	}
	
	private int getLastId() {
		final String MY_QUERY = "SELECT MAX(id) FROM " + TABLE_NAME;
		Cursor cur = mDb.rawQuery(MY_QUERY, null);
		cur.moveToFirst();
		int id = cur.getInt(0);
		cur.close();
		return id;
	}   
	
	

}
