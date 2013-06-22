package net.mindsoup.pathfindercharactersheet;

import java.util.HashMap;
import java.util.Map;

import net.mindsoup.pathfindercharactersheet.fragments.AttributesFragment;
import net.mindsoup.pathfindercharactersheet.fragments.OverviewFragment;
import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
import net.mindsoup.pathfindercharactersheet.pf.PfHandedness;
import net.mindsoup.pathfindercharactersheet.pf.PfPace;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfBarbarian;
import net.mindsoup.pathfindercharactersheet.pf.items.Weapon;
import net.mindsoup.pathfindercharactersheet.pf.races.PfDwarf;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkills;
import net.mindsoup.pathfindercharactersheet.pf.util.Dice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class CharacterActivity extends SherlockFragmentActivity {
	
	private PfCharacter dagrim = new PfCharacter(new PfDwarf(), new PfBarbarian(), true);
	
	private String[] drawerItems;
	private ListView drawerList;
	private DrawerLayout drawerLayout;
	private Map<String, SherlockFragment> fragments = new HashMap<String, SherlockFragment>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_character);
		
		drawerItems = getResources().getStringArray(R.array.drawer_items_array);
		drawerList = (ListView)findViewById(R.id.left_drawer);
		
		drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, drawerItems));		
		drawerList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(view.getContext(), Integer.toString(position), Toast.LENGTH_LONG).show();
				
				changeFragment(position);
				
			}
		});
		
		drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setIcon(R.drawable.ic_launcher);
		
		dagrim.setCharisma(8);
		dagrim.setConstitution(16);
		dagrim.setStrength(17);
		dagrim.setDexterity(15);
		dagrim.setIntelligence(11);
		dagrim.setWisdom(14);
		
		dagrim.setMainhandWeapon(new Weapon(new Dice(12, 1), 3, 1, PfHandedness.TWOHAND));
		dagrim.setPace(PfPace.FAST);
		dagrim.setXp(382);
		
		dagrim.trainSkill(PfSkills.ACROBATICS, 1);
		dagrim.trainSkill(PfSkills.SURVIVAL, 1);
		dagrim.trainSkill(PfSkills.KNOWLEDGE_NATURE, 1);
		dagrim.trainSkill(PfSkills.PERCEPTION, 1);
	}
	
	private void changeFragment(int fragment) {
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		SherlockFragment frag;
		switch(fragment) {
			case 0:
				frag = getFragment("Overview", new OverviewFragment());
				break;
			case 1:
				frag = getFragment("Attributes", new AttributesFragment());
				break;
			default:
				frag = getFragment("Overview", new OverviewFragment());
				break;
		}

		fragmentTransaction.replace(R.id.fragment_group, frag);
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
	}
	
	private SherlockFragment getFragment(String name, SherlockFragment newFragment) {
		if(fragments.containsKey(name))
			return fragments.get(name);
		
		fragments.put(name, newFragment);
		return newFragment;
	}
	
	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.character, menu);
		   
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	        case android.R.id.home:
	        	toggleDrawer();
	            return true;
	        case R.id.home_button:
	        	heroButtonClicked();
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
		}
	}
	
	private void heroButtonClicked() {
		Intent intent = new Intent(this, MainActivity.class);
	    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    startActivity(intent);
	}
	
	private void toggleDrawer() {
		// if our home icon is pressed
    	// toggle the navigation drawer
    	if(drawerLayout.isDrawerOpen(drawerList)) {
    		getSupportActionBar().setTitle(R.string.drawer_open);
    		drawerLayout.closeDrawer(drawerList);
    	}
    	else {
    		getSupportActionBar().setTitle(R.string.title);
    		drawerLayout.openDrawer(drawerList);
    	}
	}
	
	public PfCharacter getCharacter() {
		return dagrim;
	}

}
