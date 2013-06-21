package net.mindsoup.pathfindercharactersheet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	   MenuInflater inflater = getSupportMenuInflater();
	   inflater.inflate(R.menu.main, (com.actionbarsherlock.view.Menu) menu);
	   
	   return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	        case R.id.new_button:
	        	Toast.makeText(this, "New hero time!", Toast.LENGTH_LONG).show();
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
		}
	}
	
	public void startFragmentActivity(View view) {
		Toast.makeText(this, "start fragments", Toast.LENGTH_SHORT).show();
		
		Intent intent = new Intent(this, CharacterActivity.class);
    	startActivity(intent);
	}

	

}
