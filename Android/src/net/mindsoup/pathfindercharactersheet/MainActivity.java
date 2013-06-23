package net.mindsoup.pathfindercharactersheet;

import java.util.ArrayList;

import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfBarbarian;
import net.mindsoup.pathfindercharactersheet.pf.races.PfDwarf;
import net.mindsoup.pathfindercharactersheet.pf.races.PfElf;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockActivity {
	
	private CharacterListAdapter adapter;
	private ArrayList<PfCharacter> characters = new ArrayList<PfCharacter>();
	private ListView characterList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		PfCharacter character = new PfCharacter(new PfDwarf(), new PfBarbarian(), true, "Dagrim Toragson");
		character.setXp(400);
		characters.add(character);
		
		character = new PfCharacter(new PfElf(), new PfBarbarian(), true, "Bjorn Hammerfall");
		character.setXp(17000);
		characters.add(character);
		
		character = new PfCharacter(new PfDwarf(), new PfBarbarian(), true, "Marta Tookdottir");
		character.setXp(7000);
		characters.add(character);
		
		characterList = (ListView)findViewById(R.id.character_list);
		adapter = new CharacterListAdapter(this, R.layout.character_list_item, characters);
		characterList.setAdapter(adapter);
		characterList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				startFragmentActivity(view);
			}
		});
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
	        	addNewCharacter();
	        	return true;
	        case R.id.ogl_button:
	        	Intent intent = new Intent(this, OglActivity.class);
	        	startActivity(intent);
	        	return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	public void startFragmentActivity(View view) {		
		Intent intent = new Intent(this, CharacterActivity.class);
    	startActivity(intent);
	}
	
	public void addNewCharacter() {
		characters.add(new PfCharacter(new PfDwarf(), new PfBarbarian(), true, "Helga the Terrible"));
		adapter.notifyDataSetChanged();	
	}
	
	@Override 
    public void onSaveInstanceState(Bundle savedState) {
    	super.onSaveInstanceState(savedState);
    	
    	savedState.putParcelableArrayList("characters", characters);
    	
    }
    
    @Override
    public void onRestoreInstanceState(Bundle state) {
    	super.onRestoreInstanceState(state);
    	
    	characters = state.getParcelableArrayList("characters");
    	adapter = new CharacterListAdapter(this, R.layout.character_list_item, characters);
		characterList.setAdapter(adapter);
    }
}
