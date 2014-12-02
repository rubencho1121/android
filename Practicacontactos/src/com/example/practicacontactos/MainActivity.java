package com.example.practicacontactos;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {
	
	EditText user;
	EditText pass;
	SharedPreferences prefs;
	Editor edit;
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)this.findViewById(R.id.editUser);
        pass = (EditText)this.findViewById(R.id.editPassword);
        prefs = this.getSharedPreferences("AppAgenda",Context.MODE_PRIVATE);
        edit = prefs.edit();
        
    }   
        public void onClickAceptar(View V){
        	
        String usuario = user.getText().toString();
        String contrasena = pass.getText().toString();
        edit.putString("usuario", usuario);
       	edit.putString("contrasena", contrasena);
		edit.commit(); //sino se hace el commit no  se gurada los datos
        startActivity(new Intent(this,ContactosActivity.class));
        finish();
        
        
        
        
        	       		
    }


}
