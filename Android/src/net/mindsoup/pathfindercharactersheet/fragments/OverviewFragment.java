package net.mindsoup.pathfindercharactersheet.fragments;

import net.mindsoup.pathfindercharactersheet.CharacterActivity;
import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
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
			
			TextView editText = (TextView)getActivity().findViewById(R.id.overview_text);
			String stats = "";
			
			stats += "<b><u>Attribute bonuses</u></b><br>";
			stats += "Str: <b>" + character.getAttributeBonus(character.getStrength()) + "</b><br>";
			stats += "Con: <b>" + character.getAttributeBonus(character.getConstitution()) + "</b><br>";
			stats += "Dex: <b>" + character.getAttributeBonus(character.getDexterity()) + "</b><br>";
			stats += "Wis: <b>" + character.getAttributeBonus(character.getWisdom()) + "</b><br>";
			stats += "Int: <b>" + character.getAttributeBonus(character.getIntelligence()) + "</b><br>";
			stats += "Cha: <b>" + character.getAttributeBonus(character.getCharisma()) + "</b><br>";
			
			stats += "<br>";
			
			stats += "<b><u>Combat stats</u></b><br>";
			stats += "AC: <b>" + character.getAC() + "</b><br>";
			stats += "Attack bonus: <b>" + character.getAttackBonus(0) + "</b><br>";
			stats += "Damage modifier: <b>" + character.getDamageModifier() + "</b><br>";
			stats += "Attacks per round: <b>" + character.getNumAttacksPerRound() + "</b><br>";		
			
			editText.setText(Html.fromHtml(stats));
		}
	}
	
	
}
