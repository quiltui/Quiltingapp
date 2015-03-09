package com.example.quiltingapp;

import com.example.quiltingapp.Addnewfabric.StartServiceListener_1;

import android.support.v7.app.ActionBarActivity;
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
import android.widget.Toast;

public class Addnewsupply extends ActionBarActivity {
	private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;
    
    static int id=1;
    EditText editText1_names;
    EditText editText1_adds;
    EditText editText2_adds;
    EditText editText3_adds;
    EditText editText4_adds;
    ;
    Supplylist Supplylist1;
    FabricOpenHelper fabricopenhelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addnewsupply);
		 Supplylist1 = new Supplylist();
	      
    	 fabricopenhelper= new FabricOpenHelper(this);
		Button save_button = (Button) findViewById(R.id.button1_adds);
		 editText1_names = (EditText) findViewById(R.id.editText1_names);
		
		 editText1_adds = (EditText) findViewById(R.id.editText1_adds);
		 editText2_adds = (EditText) findViewById(R.id.editText2_adds);
		 editText3_adds = (EditText) findViewById(R.id.editText3_adds);
		 editText4_adds = (EditText) findViewById(R.id.editText4_adds);
		 save_button.setOnClickListener(new StartServiceListener_1());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.addnewsupply, menu);
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
        
        	Supplylist1.setID(id++);
        	Supplylist1.setName(editText1_names.getText().toString()); 
        	Supplylist1.setPrice(Integer.parseInt(editText1_adds.getText().toString()));
        	Supplylist1.setStore(editText2_adds.getText().toString());
        	Supplylist1.setAmount(Integer.parseInt(editText3_adds.getText().toString()));
        	Supplylist1.setNotes(editText4_adds.getText().toString());
        	Supplylist1.setPic(imgDecodableString);
        	fabricopenhelper.addSupply(Supplylist1);
        	Intent intent1 = new Intent();
            intent1.setClass(Addnewsupply.this, Supplies.class);
            startActivity(intent1);
        }

    }
	
}