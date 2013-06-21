package net.mindsoup.pathfindercharactersheet;

import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
import net.mindsoup.pathfindercharactersheet.pf.PfHandedness;
import net.mindsoup.pathfindercharactersheet.pf.PfPace;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfBarbarian;
import net.mindsoup.pathfindercharactersheet.pf.items.Weapon;
import net.mindsoup.pathfindercharactersheet.pf.races.PfDwarf;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkill;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkills;
import net.mindsoup.pathfindercharactersheet.pf.util.Dice;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockActivity {
	
	private PfCharacter dagrim = new PfCharacter(new PfDwarf(), new PfBarbarian(), true);
	private String[] drawerItems;
	private ListView drawerList;
	private DrawerLayout drawerLayout;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		drawerItems = getResources().getStringArray(R.array.drawer_items_array);
		drawerList = (ListView)findViewById(R.id.left_drawer);
		
		drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, drawerItems));
		drawerList.setOnItemClickListener(new DrawerItemClickListener());
		
	
		drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout); 
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	   MenuInflater inflater = getSupportMenuInflater();
	   inflater.inflate(R.menu.character, (com.actionbarsherlock.view.Menu) menu);
	   
	   return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	        case android.R.id.home:
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
	        	
	            return true;
	        case R.id.dice_button:
	        	Toast.makeText(this, "Hero time!", Toast.LENGTH_LONG).show();
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
		}
	}
	
	public void heroButtonClicked(View view) {
		Toast.makeText(this, "Hero time!", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onStart() {
		super.onStart();
		
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
		
		EditText editText = (EditText)findViewById(R.id.textField);
		String stats = "";
		
		stats += "Str: " + dagrim.getStrength() + " [" + dagrim.getAttributeBonus(dagrim.getStrength()) + "]\n";
		stats += "Con: " + dagrim.getConstitution() + " [" + dagrim.getAttributeBonus(dagrim.getConstitution()) + "]\n";
		stats += "Dex: " + dagrim.getDexterity() + " [" + dagrim.getAttributeBonus(dagrim.getDexterity()) + "]\n";
		stats += "Wis: " + dagrim.getWisdom() + " [" + dagrim.getAttributeBonus(dagrim.getWisdom()) + "]\n";
		stats += "Int: " + dagrim.getIntelligence() + " [" + dagrim.getAttributeBonus(dagrim.getIntelligence()) + "]\n";
		stats += "Cha: " + dagrim.getCharisma() + " [" + dagrim.getAttributeBonus(dagrim.getCharisma()) + "]\n";
		
		stats += "\n";
		
		stats += "HP: " + dagrim.getMaxHitpoints() + "\n";
		stats += "AC: " + dagrim.getAC() + "\n";
		stats += "Attack bonus: " + dagrim.getAttackBonus(0) + ")\n";
		stats += "Damage modifier: " + dagrim.getDamageModifier() + "\n";
		
		stats += "\n";
		
		for(PfSkills s : PfSkills.values()) {
			stats += PfSkill.getName(this, s) + " ";
			if(dagrim.canUseSkill(s)) {
				stats += dagrim.getSkillBonus(s);
			} else {
				stats += "(untrained)";
			}
			
			stats += "\n";
		}
		
		editText.setText(stats);
	}

}
