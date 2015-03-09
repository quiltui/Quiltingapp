package com.example.quiltingapp;

import com.example.quiltingapp.Fabric_1.StartServiceListener;


import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Addnewfabric extends ActionBarActivity {

	static int id=1;
	private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;
    EditText editText1_name;
    EditText editText1_add;
    EditText editText2_add;
    EditText editText3_add;
    EditText editText4_add;
    EditText editText5_add;
    EditText editText6_add;
    EditText editText7_add;
    Fabriclist fabriclist1;
    FabricOpenHelper fabricopenhelper;
    
    private Button save_button = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addnewfabric);
		 fabriclist1 = new Fabriclist();
	      
    	 fabricopenhelper= new FabricOpenHelper(this);
		Button save_button = (Button) findViewById(R.id.button1_add);
		 editText1_name = (EditText) findViewById(R.id.editText1_name);
		
		 editText1_add = (EditText) findViewById(R.id.editText1_add);
		 editText2_add = (EditText) findViewById(R.id.editText2_add);
		 editText3_add = (EditText) findViewById(R.id.editText3_add);
		 editText4_add = (EditText) findViewById(R.id.editText4_add);
		 editText5_add = (EditText) findViewById(R.id.editText5_add);
		 editText6_add = (EditText) findViewById(R.id.editText6_add);
		 editText7_add = (EditText) findViewById(R.id.editText7_add);
		
		
		save_button.setOnClickListener(new StartServiceListener_1());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.addnewfabric, menu);
		return true;
	}

	public void loadImagefromGallery(View view) {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }
 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data
 
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
 
                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();
 
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                ImageView addimage = (ImageView) findViewById(R.id.imageView1_add);
                // Set the Image in ImageView after decoding the String
                
                //addimage.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
                addimage.setImageBitmap(Bitmap.createScaledBitmap( BitmapFactory.decodeFile(imgDecodableString), 400, 400, true));
 
            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }
 
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
        
        	fabriclist1.setID(id++);
        	fabriclist1.setName(editText1_name.getText().toString());      	
        	fabriclist1.setPColor(editText1_add.getText().toString());
        	fabriclist1.setSColor1(editText2_add.getText().toString());
           	fabriclist1.setStyle(editText3_add.getText().toString());
        	fabriclist1.setPrice(Integer.parseInt(editText4_add.getText().toString()));
        	fabriclist1.setStore(editText5_add.getText().toString());
           	fabriclist1.setAmount(Integer.parseInt(editText6_add.getText().toString()));
          	fabriclist1.setNotes(editText7_add.getText().toString());
        	Log.d("save",imgDecodableString);
        	fabriclist1.setPic(imgDecodableString);
        	fabricopenhelper.addFabric(fabriclist1);
        	Intent intent1 = new Intent();
            intent1.setClass(Addnewfabric.this, Fabrics.class);
            startActivity(intent1);
        }

    }
	
}