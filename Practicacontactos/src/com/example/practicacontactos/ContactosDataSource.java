package com.example.practicacontactos;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ContactosDataSource {

	
	
	private SQLiteDatabase database;
	private ContactosSQLLiteHelper dbHelper;
	private String[] contactosColumnas= {ContactosSQLLiteHelper.COLUMN_ID,
			ContactosSQLLiteHelper.COLUMN_NAME,
			ContactosSQLLiteHelper.COLUMN_PHONE,
			ContactosSQLLiteHelper.COLUMN_ADDRESS,
			ContactosSQLLiteHelper.COLUMN_CITY,
			ContactosSQLLiteHelper.COLUMN_EMAIL};
			

public ContactosDataSource(Context context) {
	dbHelper = new ContactosSQLLiteHelper(context);
}

public void open() throws SQLException {
	database = dbHelper.getWritableDatabase();//Dar contexto a la base de datos
}

public void close() {
	dbHelper.close();
}

public contactos createContacto(String name, String phone, String address, String city, String email) {
	ContentValues values = new ContentValues();
	values.put(ContactosSQLLiteHelper.COLUMN_NAME,name);
	values.put(ContactosSQLLiteHelper.COLUMN_PHONE,phone);
	values.put(ContactosSQLLiteHelper.COLUMN_ADDRESS, address);
	values.put(ContactosSQLLiteHelper.COLUMN_CITY,city);
	values.put(ContactosSQLLiteHelper.COLUMN_EMAIL,email);
	
	//Añadir texto
	long insertId = database.insert(ContactosSQLLiteHelper.TABLE_CONTACTS, null,values);
	Cursor cursor = database.query(ContactosSQLLiteHelper.TABLE_CONTACTS,
									contactosColumnas, 
									ContactosSQLLiteHelper.COLUMN_ID + " = " + insertId, 
									null,null, null, null);
	cursor.moveToFirst();
	contactos newContacto = cursorToContacto(cursor);
	cursor.close();
	return newContacto;
}

public void deleteComment(contactos contacto) {
	long id = contacto.getId();
	System.out.println("Comment deleted with id: " + id);
	database.delete(ContactosSQLLiteHelper.TABLE_CONTACTS, ContactosSQLLiteHelper.COLUMN_ID
			+ " = " + id, null);
}

public List<contactos> getAllContactos() {
	List<contactos> contactos = new ArrayList<contactos>();

	Cursor cursor = database.query(ContactosSQLLiteHelper.TABLE_CONTACTS,
			contactosColumnas, null, null, null, null, null);

	cursor.moveToFirst();
	while (!cursor.isAfterLast()) {
		contactos contacto = cursorToContacto(cursor);
		contactos.add(contacto);
		cursor.moveToNext();
	}
	// make sure to close the cursor
	cursor.close();
	return contactos;
}

private contactos cursorToContacto(Cursor cursor) {
	contactos contacto = new contactos();
	//Añadir texto
	contacto.setName(cursor.getString(1));
	contacto.setPhone(cursor.getString(2));
	contacto.setCity(cursor.getString(3));
	contacto.setPhone(cursor.getString(4));
	
	//devolver un string del campo cero
	return contacto;
	}

}
	
	
	

