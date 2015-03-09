package com.example.quiltingapp;

import java.util.ArrayList;
import java.util.List;

import com.example.quiltingapp.MainActivity.StartServiceListener1;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Fabrics extends ActionBarActivity {
	
	LinearLayout linear_1;
    private ImageView imageView2=null;
    private EditText editText=null;
    private Button addnewfabric = null;
    FabricOpenHelper fabricopen;
    ArrayList<Fabriclist> AllFabs1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("check","check");
		setContentView(R.layout.activity_fabrics);
		AllFabs1 = new ArrayList<Fabriclist>();
	     fabricopen = new FabricOpenHelper(getApplicationContext());
		Log.d("check","check");
		GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter(this));

	   gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	        	Toast.makeText(Fabrics.this, "" + position, Toast.LENGTH_SHORT).show();
	        	Intent intent1 = new Intent();
	            intent1.setClass(Fabrics.this, Fabric_1.class);
	            startActivity(intent1);
	            
	        }
	    });
		linear_1 = (LinearLayout) findViewById(R.id.linear_1);
		imageView2 =(ImageView) findViewById(R.id.imageView2);
		editText = (EditText) findViewById(R.id.editText);
		//linear_1.setOnClickListener(new StartServiceListener_1());
		imageView2.setOnClickListener(new StartServiceListener_3());
		addnewfabric = (Button) findViewById(R.id.button1);
		addnewfabric.setOnClickListener(new StartServiceListener_2());
	
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
	
	class StartServiceListener_2 implements OnClickListener {

        @Override
        public void onClick(View v) {
        	Log.d("check","check");
            Intent intent222 = new Intent();
            intent222.setClass(Fabrics.this, Addnewfabric.class);
            startActivity(intent222);
        }

    }
	class StartServiceListener_3 implements OnClickListener {

        @Override
        public void onClick(View v) {
        	
        	String query;
        	Fabriclist Fabiclist1 =new Fabriclist();
        	//FabricOpenHelper dbhelper= new FabricOpenHelper(); 	
        	query="SELECT * FROM Fabricstats " + " WHERE " 
                    + Fabiclist1.getID() + "=" +  editText.getText()+" OR "+
                    Fabiclist1.getAmount()+ "=" +  editText.getText()+" OR "+
                    Fabiclist1.getPrice()+ "=" +  editText.getText()+" OR "+
                    Fabiclist1.getName()+ "=" +  editText.getText()+" OR "+
                    Fabiclist1.getNotes()+ "=" +  editText.getText()+" OR "+
                    Fabiclist1.getPColor()+ "=" +  editText.getText()+" OR "+
                    Fabiclist1.getSColor1()+ "=" +  editText.getText()+" OR "+
                    Fabiclist1.getSColor2()+ "=" +  editText.getText()+" OR "+
                    Fabiclist1.getSColor3()+ "=" +  editText.getText()+" OR "+
                    Fabiclist1.getStyle()+ "=" +  editText.getText()+" OR "+
                    Fabiclist1.getStore()+ "=" +  editText.getText()+" OR "+
                    Fabiclist1.getPic()+ "=" +  editText.getText();
        	        Log.d("query",query);
        }

    }
	
	public class ImageAdapter extends BaseAdapter {
	    private Context mContext;
	    
	    public ImageAdapter(Context c) {
	        mContext = c;
	    }

	    public int getCount() {
	    	
	       // return fabricopen.getAllFabric().size();
	    	return mThumbIds.length;

	    }

	    public Object getItem(int position) {
	        return null;
	    }

	    public long getItemId(int position) {
	        return position;
	    }

	    // create a new ImageView for each item referenced by the Adapter
	    public View getView(int position, View convertView, ViewGroup parent) {
	        ImageView imageView;
	        Bitmap bm;
	        //Fabriclist currImage = fabricopen.getAllFabric().get(position);
	        if (convertView == null) {  // if it's not recycled, initialize some attributes
	            imageView = new ImageView(mContext);
	            imageView.setLayoutParams(new GridView.LayoutParams(200,200));
	            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	            imageView.setPadding(8, 8, 8, 8);
	        } else {
	            imageView = (ImageView) convertView;
	        }
	        imageView.setImageResource(mThumbIds[position]);
	       // bm = decodeSampledBitmapFromUri(currImage.getPic(), 250, 250);
	       // imageView.setImageBitmap(bm);
			return imageView;
	    }
	    
	    private Integer[] mThumbIds = {
	            R.drawable.fabric1, R.drawable.fabric2,
	            R.drawable.fabric3, R.drawable.fabric4,
	            R.drawable.fabric5
	    };
	    public Bitmap decodeSampledBitmapFromUri(String path, int reqWidth, int reqHeight) { 
            Bitmap bm = null;
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, options);
            options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
            options.inJustDecodeBounds = false;
            bm = BitmapFactory.decodeFile(path, options);
            return bm;  
        }
        public int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
            final int height = options.outHeight;
            final int width = options.outWidth;
            int inSampleSize = 1;
     
            if (height > reqHeight || width > reqWidth) {
            	final int halfHeight = height / 4;
                final int halfWidth = width / 4;
                while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
                      inSampleSize *= 2;
                }
            }
            return inSampleSize;   
        }  
    }
	
	    
	
}