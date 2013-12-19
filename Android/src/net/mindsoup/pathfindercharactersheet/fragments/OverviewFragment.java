package net.mindsoup.pathfindercharactersheet.fragments;

import net.mindsoup.pathfindercharactersheet.CalculationView;
import net.mindsoup.pathfindercharactersheet.CharacterActivity;
import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
import net.mindsoup.pathfindercharactersheet.pf.items.Item;
import net.mindsoup.pathfindercharactersheet.pf.util.Calculation;
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
			
			calcView = (CalculationView)getActivity().findViewById(R.id.calc_cmb);
			calcView.setCalculation(character.getCombatManeuverBonus(0));
			calcView.setText("");
			
			calcView = (CalculationView)getActivity().findViewById(R.id.calc_cmd);
			calcView.setCalculation(character.getCombatManeuverDefense(0));
			calcView.setText("");
			
			calcView = (CalculationView)getActivity().findViewById(R.id.calc_fort_save);
			Calculation fort = new Calculation();
			fort.add("CON bonus", character.getAttributeBonus(character.getConstitution()));
			fort.add("Fortitude bonus", character.getPfClass().getFortSaveModifier(character.getLevel()));
			calcView.setCalculation(fort);
			calcView.setText("");
			
			calcView = (CalculationView)getActivity().findViewById(R.id.calc_ref_save);
			Calculation ref = new Calculation();
			ref.add("DEX bonus",  character.getAttributeBonus(character.getDexterity()));
			ref.add("Reflex bonus", character.getPfClass().getReflexSaveModifier(character.getLevel()));
			calcView.setCalculation(ref);
			calcView.setText("");
			
			calcView = (CalculationView)getActivity().findViewById(R.id.calc_will_save);
			Calculation will = new Calculation();
			will.add("WIS bonus",  character.getAttributeBonus(character.getWisdom()));
			will.add("Will bonus", character.getPfClass().getWillSaveModifier(character.getLevel()));
			calcView.setCalculation(will);
			calcView.setText("");
			
			editText = (TextView)getActivity().findViewById(R.id.overview_text);
			String stats = "<b>Equiped items</b><br>";
			for(Item i : character.getInventoryItems()) {
				if(i.isEquiped()) {
					stats += i.getName() + "<br>";
				}
			}

			editText.setText(Html.fromHtml(stats));
		}
	}
	
	
}
