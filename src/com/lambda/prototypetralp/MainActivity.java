package com.lambda.prototypetralp;

import java.io.File;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
	//public final static String EXTRA_MESSAGE = "com.lambda.Prototypetralp.MESSAGE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		
		Button Btn = (Button)findViewById(R.id.text_enabled);     
	    Btn.setOnClickListener(new OnClickListener() {

	        public void onClick(View Button) {

	    Intent intent = new Intent(MainActivity.this, EditMessage.class); 
	    startActivity(intent);

	        } 

	    });
	    
	    Button record = (Button)findViewById(R.id.record_button);     
	    record.setOnClickListener(new OnClickListener() {

	        public void onClick(View Button) {

	        	 Intent imageIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
	             File imagesFolder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "PrototypeTRALP");
	             imagesFolder.mkdirs(); 
	             File image = new File(imagesFolder, "image_001.jpg");
	             Uri uriSavedImage = Uri.fromFile(image);
	             imageIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
	             startActivityForResult(imageIntent,1);
	             //TODO Save video captured.
	        } 

	    });
	    
	   
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
