package com.example.quiltingapp;

import com.example.quiltingapp.MainActivity.StartServiceListener1;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class Fabrics extends ActionBarActivity {
	
	private LinearLayout linear_1 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fabrics);
		
		linear_1 = (LinearLayout) findViewById(R.id.linear_1);
		
		linear_1.setOnClickListener(new StartServiceListener_1());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fabrics, menu);
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
	class StartServiceListener_1 implements OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent();
            intent1.setClass(Fabrics.this, Fabric_1.class);
            startActivity(intent1);
        }

    }
}
