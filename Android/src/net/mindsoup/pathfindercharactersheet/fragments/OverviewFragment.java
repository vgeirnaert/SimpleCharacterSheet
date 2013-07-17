package net.mindsoup.pathfindercharactersheet.fragments;

import net.mindsoup.pathfindercharactersheet.CalculationView;
import net.mindsoup.pathfindercharactersheet.CharacterActivity;
import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
import net.mindsoup.pathfindercharactersheet.pf.PfHandedness;
import net.mindsoup.pathfindercharactersheet.pf.items.Weapon;
import net.mindsoup.pathfindercharactersheet.pf.util.Dice;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OverviewFragment extends CharacterFragment {
	
	private PfCharacter character;
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overview, container, false);

    }
	
	@Override
	public void onResume() {
		super.onResume();
		
		setStats();
	}

	@Override
	public void refresh() {
		setStats();
		
	}
	
	private void setStats() {
		if(isAdded()) {
			CharacterActivity ca = (CharacterActivity)this.getActivity();
			character = ca.getCharacter();
			
			TextView editText = (TextView)getActivity().findViewById(R.id.calc_level);
			editText.setText(Integer.toString(character.getLevel()));
			
			editText = (TextView)getActivity().findViewById(R.id.calc_xp);
			editText.setText(Integer.toString(character.getXp()));
			
			CalculationView calcView = (CalculationView)getActivity().findViewById(R.id.calc_hitpoints);
			calcView.setCalculation(character.getMaxHitpoints());
			calcView.setText("");
			
			calcView = (CalculationView)getActivity().findViewById(R.id.calc_ac);
			calcView.setCalculation(character.getAC());
			calcView.setText("");
			
			calcView = (CalculationView)getActivity().findViewById(R.id.calc_ab);
			calcView.setCalculation(character.getAttackBonus(0));
			calcView.setText("");
			
			editText = (TextView)getActivity().findViewById(R.id.overview_text);
			String stats = "";
			
			// hack - everyone gets a greataxe!
			character.setMainhandWeapon(new Weapon(new Dice(12, 1), 3, 1, PfHandedness.TWOHAND));
			stats += "<br><u>Greataxe</u><br>";
			stats += "Damage type: Slashing<br>";
			stats += "Critical range: <b>" + character.getMainhandWeapon().getCriticalRange() + " (x" + character.getMainhandWeapon().getCriticalMultiplier() + ")</b><br>";
			stats += "Damage: <b>" + character.getMainhandWeapon().getDamage() + " + " + character.getDamageModifier() + "</b><br>";
			// hack - everyone gets a greataxe!
			character.setMainhandWeapon(new Weapon(new Dice(4, 1), 2, 2, PfHandedness.ONEHAND));
			stats += "<br><u>Dagger</u><br>";
			stats += "Damage type: Piercing or Slashing<br>";
			stats += "Critical range: <b>" + character.getMainhandWeapon().getCriticalRange() + " (x" + character.getMainhandWeapon().getCriticalMultiplier() + ")</b><br>";
			stats += "Damage: <b>" + character.getMainhandWeapon().getDamage() + " + " + character.getDamageModifier() + "</b><br>";
			// hack - everyone gets a greataxe!
			character.setMainhandWeapon(new Weapon(new Dice(6, 1), 2, 1, PfHandedness.ONEHAND));
			stats += "<br><u>Hunga Munga (thrown and light melee weapon)</u><br>";
			stats += "Damage type: Piercing<br>";
			stats += "Critical range: <b>" + character.getMainhandWeapon().getCriticalRange() + " (x" + character.getMainhandWeapon().getCriticalMultiplier() + ")</b><br>";
			stats += "Damage: <b>" + character.getMainhandWeapon().getDamage() + " + " + character.getDamageModifier() + "</b><br>";
			// hack - everyone gets a greataxe!
			character.setMainhandWeapon(new Weapon(new Dice(3, 1), 2, 1, PfHandedness.ONEHAND));
			stats += "<br><u>Gauntlet</u><br>";
			stats += "Damage type: Bludgeoning<br>";
			stats += "Critical range: <b>" + character.getMainhandWeapon().getCriticalRange() + " (x" + character.getMainhandWeapon().getCriticalMultiplier() + ")</b><br>";
			stats += "Damage: <b>" + character.getMainhandWeapon().getDamage() + " + " + character.getDamageModifier() + "</b><br>";		
			
			editText.setText(Html.fromHtml(stats));
		}
	}
	
	
}
