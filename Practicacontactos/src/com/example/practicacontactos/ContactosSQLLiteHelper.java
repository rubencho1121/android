package com.example.practicacontactos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactosSQLLiteHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "contact.db";
	private static final int DATABASE_VERSION = 6;
	public static final String TABLE_CONTACTS = "contacts";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_PHONE = "phone";
	public static final String COLUMN_ADDRESS = "address";
	public static final String COLUMN_CITY = "city";
	public static final String COLUMN_EMAIL = "email";
	
	
	
	// Database creation sql statement
	  private static final String DATABASE_CREATE = "create table "+ TABLE_CONTACTS 
	+ "(" + COLUMN_ID + " integer primary key autoincrement, " 
		  + COLUMN_NAME+ " text not null, " 
	      + COLUMN_PHONE+ " text not null," 
	      + COLUMN_ADDRESS+ " text not null,"
	      + COLUMN_CITY + " text not null,"
	      + COLUMN_EMAIL+ " text not null);";
	
	public ContactosSQLLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		    db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
		    onCreate(db);
		
	}

}