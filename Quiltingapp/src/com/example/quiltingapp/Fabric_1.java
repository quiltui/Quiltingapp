package com.example.quiltingapp;

import com.example.quiltingapp.MainActivity.StartServiceListener1;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class Fabric_1 extends ActionBarActivity {
	
	private TextView textView2 = null;
	private EditText editText1 = null;
	private EditText editText2 = null;
	private EditText editText3 = null;
	private EditText editText4 = null;
	private EditText editText5 = null;
	private EditText editText6 = null;
	private EditText editText7 = null;
	private Button update_button = null;
	private Button save_button = null;
	private ImageView imageView1;
	Fabriclist fabriclist1;
    FabricOpenHelper fabricopenhelper;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fabric_1);
		fabriclist1 = new Fabriclist();
	      
   	 fabricopenhelper= new FabricOpenHelper(this);
   	imageView1=(ImageView) findViewById(R.id.imageView1);
   	     textView2 = (TextView) findViewById(R.id.textView2);
   	     editText1 = (EditText) findViewById(R.id.editText1);
   	     editText2 = (EditText) findViewById(R.id.editText2);
   	     editText3 = (EditText) findViewById(R.id.editText3);
   	     editText4 = (EditText) findViewById(R.id.editText4);
   	     editText5 = (EditText) findViewById(R.id.editText5);
   	     editText6 = (EditText) findViewById(R.id.editText6);
   	     editText7 = (EditText) findViewById(R.id.editText7);
		Button update_button = (Button) findViewById(R.id.button21);
		Button save_button = (Button) findViewById(R.id.button1);
		ViewGroup group = (ViewGroup) findViewById(R.id.linear_1);
		//update_button(group);
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
        	
        	setContentView(R.layout.activity_fabric_edit);
        	String imgDecodableString;
        	//fabriclist1.getID();
        	textView2.setText(fabriclist1.getName());      	
        	editText1.setText(fabriclist1.getPColor());
        	editText2.setText(fabriclist1.getSColor1());
        	editText3.setText(fabriclist1.getStyle());
        	editText4.setText(String.valueOf(fabriclist1.getPrice()));
        	editText5.setText(fabriclist1.getStore());
        	editText6.setText(String.valueOf(fabriclist1.getAmount()));
        	editText7.setText(fabriclist1.getNotes());
        
        	imgDecodableString=fabriclist1.getPic();
        	
        	//imageView1.setImageURI(imgDecodableString);
        	
        	fabriclist1.setName(textView2.getText().toString());      	
        	fabriclist1.setPColor(editText1.getText().toString());
        	fabriclist1.setSColor1(editText2.getText().toString());
           	fabriclist1.setStyle(editText3.getText().toString());
        	fabriclist1.setPrice(Integer.parseInt(editText4.getText().toString()));
        	fabriclist1.setStore(editText5.getText().toString());
           	fabriclist1.setAmount(Integer.parseInt(editText6.getText().toString()));
          	fabriclist1.setNotes(editText7.getText().toString());
        	fabriclist1.setPic(imgDecodableString);
        	fabricopenhelper.addFabric(fabriclist1);
        	fabricopenhelper.addFabric(fabriclist1);
        	Intent intent1 = new Intent();
            intent1.setClass(Fabric_1.this, Fabrics.class);
            startActivity(intent1);
        	
        	
        }

    }
	
	
}
