package com.example.practicacontactos;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactosActivity extends Activity {

	
	
	ListView listaContactos;
	ContactosDataSource datasource;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contactos);
		listaContactos = (ListView)this.findViewById(R.id.listContactos);
		datasource= new ContactosDataSource(this);
		datasource.open();
		List<contactos> values = datasource.getAllContactos();
		ArrayAdapter<contactos> adapter = new ArrayAdapter<contactos>(this, android.R.layout.simple_list_item_1, values);
		listaContactos.setAdapter(adapter);
		
		
		}
	
	
	public void onClickNuevoContacto(View v){
		
	datasource.close();
	startActivity(new Intent(this,NuevoContactoActivity.class));
	finish();
	
	}

	
}
