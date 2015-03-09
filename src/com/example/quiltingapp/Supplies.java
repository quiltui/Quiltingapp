package com.example.quiltingapp;

import com.example.quiltingapp.Supplies;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class Supplies extends ActionBarActivity {

	private LinearLayout linear_11 = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_supplies);
        linear_11 = (LinearLayout) findViewById(R.id.linear_11);
		
		linear_11.setOnClickListener(new StartServiceListener_1());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.supplies, menu);
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
            Intent intent22 = new Intent();
            intent22.setClass(Supplies.this, Supply_1.class);
            startActivity(intent22);
        }

    }
}