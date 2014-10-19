package net.mindsoup.pathfindercharactersheet;

import net.mindsoup.pathfindercharactersheet.util.TextFileReader;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class OglActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ogl);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	   MenuInflater inflater = getSupportMenuInflater();
	   inflater.inflate(R.menu.ogl, (com.actionbarsherlock.view.Menu) menu);
	   
	   getSupportActionBar().setTitle(R.string.ogl_title);
	   
	   return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.home_button:
			super.onBackPressed();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		
		TextView editText = (TextView)findViewById(R.id.ogl_text);
		editText.setText(Html.fromHtml(TextFileReader.readText(this, "ogl")));
	}

}
