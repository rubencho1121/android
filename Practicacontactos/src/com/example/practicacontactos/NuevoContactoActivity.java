package com.example.practicacontactos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NuevoContactoActivity extends Activity {

	EditText name;
	EditText phone;
	EditText address;
	EditText city;
	EditText email;
	ContactosDataSource datasource;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nuevo_contacto);
		name = (EditText)this.findViewById(R.id.editName);
		phone = (EditText)this.findViewById(R.id.editPhone);
		address = (EditText)this.findViewById(R.id.editAddress);
		city = (EditText)this.findViewById(R.id.editCity);
		email = (EditText)this.findViewById(R.id.editEmail);
		datasource = new ContactosDataSource(this);
		datasource.open();
	
	}
	
	
	public void onClickIngresoNuevoContacto(View v){
		String nombre = name.getText().toString();
		String telefono= phone.getText().toString();
		String direccion = address.getText().toString();
		String ciudad = city.getText().toString();
		String correo = email.getText().toString();
		datasource.createContacto(nombre, telefono, direccion, ciudad, correo);
		datasource.close();
		startActivity(new Intent(this,ContactosActivity.class));
		finish();
		
	}
		
	

	
}
