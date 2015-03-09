package com.example.quiltingapp;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends ActionBarActivity {
	
	private Button fabrics_button = null;
	private Button supplies_button = null;
	private Button compare_button = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		fabrics_button = (Button) findViewById(R.id.fabrics_button);
        supplies_button = (Button) findViewById(R.id.supplies_button);
        compare_button = (Button) findViewById(R.id.compare_button);
        fabrics_button.setOnClickListener(new StartServiceListener1());
        supplies_button.setOnClickListener(new StartServiceListener2());
        compare_button.setOnClickListener(new StartServiceListener3());
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
	
	class StartServiceListener1 implements OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent();
            intent1.setClass(MainActivity.this, Fabrics.class);
            Log.d("check","check");
            startActivity(intent1);
        }

    }
	
	class StartServiceListener2 implements OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent();
            intent1.setClass(MainActivity.this, Supplies.class);
            startActivity(intent1);
        }

    }
	
	class StartServiceListener3 implements OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent();
            intent1.setClass(MainActivity.this, Compare.class);
            startActivity(intent1);
        }

    }
}
