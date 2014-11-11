package com.example.primitiva;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class WebAct extends Activity {

	private WebView mWebView;
	private Button volverBtn;
	private Intent intent;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        volverBtn = (Button) findViewById(R.id.volver);
        mWebView = (WebView) findViewById(R.id.webView1);
        mWebView.reload();
        
        // Activo JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);
        
        // Cargamos la url que necesitamos    
        mWebView.loadUrl("https://juegos.loteriasyapuestas.es/CF/games/LAPR/play.do");
        
        volverBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(WebAct.this, MainActivity.class);
				startActivity(intent);
				
			}
		});
    }
}
