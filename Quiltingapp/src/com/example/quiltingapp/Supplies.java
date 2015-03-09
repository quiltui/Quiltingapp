package com.example.quiltingapp;

import com.example.quiltingapp.Supplies;
import com.example.quiltingapp.Fabrics.StartServiceListener_2;
import com.example.quiltingapp.Fabrics.StartServiceListener_3;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Supplies extends ActionBarActivity {

	private LinearLayout linear_11 = null;
	private Button addnewsupply = null;
	private ImageView imageView3=null;
    private EditText editText=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_supplies);
        linear_11 = (LinearLayout) findViewById(R.id.linear_11);
        imageView3 =(ImageView) findViewById(R.id.imageView3);
		editText = (EditText) findViewById(R.id.editText);
		linear_11.setOnClickListener(new StartServiceListener_1());
		imageView3.setOnClickListener(new StartServiceListener_3());
		addnewsupply = (Button) findViewById(R.id.button1);
		addnewsupply.setOnClickListener(new StartServiceListener_2());
	
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
	class StartServiceListener_2 implements OnClickListener {

        @Override
        public void onClick(View v) {
        	Log.d("check","check");
            Intent intent222 = new Intent();
            intent222.setClass(Supplies.this, Addnewsupply.class);
            startActivity(intent222);
        }

    }
	class StartServiceListener_3 implements OnClickListener {

        @Override
        public void onClick(View v) {
        	
        	String query;
        	Supplylist Supplylist1 =new Supplylist();
        	//FabricOpenHelper dbhelper= new FabricOpenHelper(); 	
        	query="SELECT * FROM Supplystats " + " WHERE " 
                    + Supplylist1.getID() + "=" +  editText.getText()+" OR "+
                    Supplylist1.getAmount()+ "=" +  editText.getText()+" OR "+
                    Supplylist1.getPrice()+ "=" +  editText.getText()+" OR "+
                    Supplylist1.getName()+ "=" +  editText.getText()+" OR "+
                    Supplylist1.getNotes()+ "=" +  editText.getText()+" OR "+
                    Supplylist1.getStore()+ "=" +  editText.getText()+" OR "+
                    Supplylist1.getPic()+ "=" +  editText.getText();
        	        Log.d("query",query);
        }

    }
}