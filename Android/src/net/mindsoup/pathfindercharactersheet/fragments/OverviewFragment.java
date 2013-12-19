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
			
			calcView = (CalculationView)getActivity().findViewById(R.id.calc_mab);
			calcView.setCalculation(character.getMeleeAttackBonus(0));
			calcView.setText("");
			
			calcView = (CalculationView)getActivity().findViewById(R.id.calc_rab);
			calcView.setCalculation(character.getRangedAttackBonus(0));
			calcView.setText("");
			
			calcView = (CalculationView)getActivity().findViewById(R.id.calc_cmb);
			calcView.setCalculation(character.getCombatManeuverBonus(0));
			calcView.setText("");
			
			calcView = (CalculationView)getActivity().findViewById(R.id.calc_cmd);
			calcView.setCalculation(character.getCombatManeuverDefense(0));
			calcView.setText("");
			
			calcView = (CalculationView)getActivity().findViewById(R.id.calc_fort_save);
			calcView.setCalculation(character.getFortitudeSave());
			calcView.setText("");
			
			calcView = (CalculationView)getActivity().findViewById(R.id.calc_ref_save);
			calcView.setCalculation(character.getReflexSave());
			calcView.setText("");
			
			calcView = (CalculationView)getActivity().findViewById(R.id.calc_will_save);
			calcView.setCalculation(character.getWillSave());
			calcView.setText("");
			
			calcView = (CalculationView)getActivity().findViewById(R.id.calc_initiative);
			Calculation init = new Calculation();
			init.add("Dex bonus",  character.getAttributeBonus(character.getDexterity()), true);
			calcView.setCalculation(init);
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
