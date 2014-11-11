package com.example.primitiva;

import java.util.ArrayList;
import java.util.Collections;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	private SharedPreferences sharedPref;
	private ArrayList<Integer> numeros;
	private ArrayList<Integer> numerosAux;
	private int numAux;
	TextView primero, segundo,tercero, cuarto, quinto, sexto,titulo;
	Button btn,btn2;
	Typeface custom_font;
	Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        custom_font = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Medium.ttf");
        primero = (TextView)findViewById(R.id.textView1);
        segundo = (TextView)findViewById(R.id.textView2);
        tercero = (TextView)findViewById(R.id.textView3);
        cuarto = (TextView)findViewById(R.id.textView4);
        quinto = (TextView)findViewById(R.id.textView5);
        sexto = (TextView)findViewById(R.id.textView6);
        titulo = (TextView)findViewById(R.id.textViewTitulo);
        btn = (Button)findViewById(R.id.volver);
        btn2 = (Button)findViewById(R.id.btnapuesta);
        primero.setTypeface(custom_font);
        segundo.setTypeface(custom_font);
        tercero.setTypeface(custom_font);
        cuarto.setTypeface(custom_font);
        quinto.setTypeface(custom_font);
        sexto.setTypeface(custom_font);
        titulo.setTypeface(custom_font);
        btn.setTypeface(custom_font);
        
        sharedPref=	getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
      
        primero.setText(sharedPref.getString("Valor1",""));
        segundo.setText(sharedPref.getString("Valor2",""));
        tercero.setText(sharedPref.getString("Valor3",""));
        cuarto.setText(sharedPref.getString("Valor4",""));
        quinto.setText(sharedPref.getString("Valor5",""));
        sexto.setText(sharedPref.getString("Valor6",""));
        
        btn.setOnClickListener(new View.OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		numeros = Primitiva.generarNumeros();
        		Collections.sort(numeros);
        		Editor editor = sharedPref.edit();
        		for (int i = 0; i < 6; i++) {
        			editor.putString("Valor"+(i+1),String.valueOf(numeros.get(i)));
        		}
        		editor.commit();
        		primero.setText(sharedPref.getString("Valor1",""));
        		segundo.setText(sharedPref.getString("Valor2",""));
        		tercero.setText(sharedPref.getString("Valor3",""));
        		cuarto.setText(sharedPref.getString("Valor4",""));
        		quinto.setText(sharedPref.getString("Valor5",""));
        		sexto.setText(sharedPref.getString("Valor6",""));
        	}
        });
        btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(MainActivity.this, WebAct.class);
				startActivity(intent);
				
			}
		});
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	// Inflate the menu; this adds items to the action bar if it is present.
    	getMenuInflater().inflate(R.menu.main, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// Handle action bar item clicks here. The action bar will
    	// automatically handle clicks on the Home/Up button, so long
    	// as you specify a parent activity in AndroidManifest.xml.
    	int id = item.getItemId();
    	if (id == R.id.action_settings) {
    		return true;
    	}
    	return super.onOptionsItemSelected(item);
    }
}
		
				
				
				
				
    
			
				
				
				
				
					
				



