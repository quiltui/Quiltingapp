package com.example.quiltingapp;



import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class Supply_1 extends ActionBarActivity {
	
	private EditText mEdit1 = null;
	private EditText mEdit2 = null;
	private EditText mEdit3 = null;
	private EditText mEdit4 = null;
	private EditText mEdit5 = null;
	private EditText mEdit6 = null;
	private EditText mEdit7 = null;
	private Button update_button = null;
	private Button save_button = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fabric_1);
		EditText mEdit1 = (EditText) findViewById(R.id.editText1);
		EditText mEdit2 = (EditText) findViewById(R.id.editText2);
		EditText mEdit3 = (EditText) findViewById(R.id.editText3);
		EditText mEdit4 = (EditText) findViewById(R.id.editText4);
		EditText mEdit5 = (EditText) findViewById(R.id.editText5);
		EditText mEdit6 = (EditText) findViewById(R.id.editText6);
		EditText mEdit7 = (EditText) findViewById(R.id.editText7);
		Button update_button = (Button) findViewById(R.id.button2);
		Button save_button = (Button) findViewById(R.id.button1);
		
		update_button.setOnClickListener(new StartServiceListener());
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fabric_1, menu);
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
	
	class StartServiceListener implements OnClickListener {

        @Override
        public void onClick(View v) {
        	mEdit1.setEnabled(true);
        	mEdit2.setEnabled(true);
        	mEdit3.setEnabled(true);
        	mEdit4.setEnabled(true);
        	mEdit5.setEnabled(true);
        	mEdit6.setEnabled(true);
        	mEdit7.setEnabled(true);
        }

    }
}