package net.mindsoup.pathfindercharactersheet;

import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
import net.mindsoup.pathfindercharactersheet.pf.PfHandedness;
import net.mindsoup.pathfindercharactersheet.pf.PfPace;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfBarbarian;
import net.mindsoup.pathfindercharactersheet.pf.items.Weapon;
import net.mindsoup.pathfindercharactersheet.pf.races.PfDwarf;
import net.mindsoup.pathfindercharactersheet.pf.util.Dice;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private PfCharacter dagrim = new PfCharacter(new PfDwarf(), new PfBarbarian(), true);
	private String[] drawerItems;
	private ListView drawerList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		drawerItems = getResources().getStringArray(R.array.drawer_items_array);
		drawerList = (ListView)findViewById(R.id.left_drawer);
		
		drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, drawerItems));
		drawerList.setOnItemClickListener(new DrawerItemClickListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onStart() {
		super.onStart();
		
		dagrim.setCharisma(8);
		dagrim.setConstitution(16);
		dagrim.setStrength(17);
		dagrim.setDexterity(15);
		dagrim.setIntelligence(11);
		dagrim.setWisdom(14);
		
		dagrim.setMainhandWeapon(new Weapon(new Dice(12, 1), 3, 1, PfHandedness.TWOHAND));
		dagrim.setPace(PfPace.FAST);
		dagrim.setXp(382);
		
		EditText editText = (EditText)findViewById(R.id.textField);
		String stats = "";
		
		stats += "Str: " + dagrim.getStrength() + " - +" + dagrim.getAttributeBonus(dagrim.getStrength()) + "\n";
		stats += "Con: " + dagrim.getConstitution() + " - +" + dagrim.getAttributeBonus(dagrim.getConstitution()) + "\n";
		stats += "Dex: " + dagrim.getDexterity() + " - +" + dagrim.getAttributeBonus(dagrim.getDexterity()) + "\n";
		stats += "Wis: " + dagrim.getWisdom() + " - +" + dagrim.getAttributeBonus(dagrim.getWisdom()) + "\n";
		stats += "Int: " + dagrim.getIntelligence() + " - +" + dagrim.getAttributeBonus(dagrim.getIntelligence()) + "\n";
		stats += "Cha: " + dagrim.getCharisma() + " - +" + dagrim.getAttributeBonus(dagrim.getCharisma()) + "\n";
		
		stats += "\n";
		
		stats += "HP: " + dagrim.getMaxHitpoints() + "\n";
		stats += "AC: " + dagrim.getAC() + "\n";
		stats += "Attack bonus: " + dagrim.getAttackBonus(0) + "(" + dagrim.getAttackBonus(1) + ", " + dagrim.getAttackBonus(2) + ")\n";
		stats += "Damage modifier: " + dagrim.getDamageModifier() + "\n";
		
		editText.setText(stats);
	}

}
